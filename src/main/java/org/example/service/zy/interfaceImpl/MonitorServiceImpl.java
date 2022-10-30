package org.example.service.zy.interfaceImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.config.zy.RedisConfig;
import org.example.entity.Brake;
import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.example.mapper.zy.ElecBrakeMapper;
import org.example.mapper.zy.SocketMapper;
import org.example.mapper.zy.impl.ElecBrakeMapperImpl;
import org.example.mapper.zy.impl.SocketMapperImpl;
import org.example.service.zy.serviceInterface.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Random;

/**
 * @CacheConfig:
 * The content of the cacheName parameter in cacheConfig must be the returned configuration name in RedisConfig
 * @author zy
 */
@Service
@CacheConfig(cacheNames = "admin")
public class MonitorServiceImpl implements MonitorService {
    private Socket socket;
    private ElecBrake elecBrake;
    private ProtectServiceImpl protectService;
    @Autowired
    private RedisConfig redisConfig;
    public MonitorServiceImpl(){

    }
    /**
     * 监测整个电路
     * @param elecBrake
     */
    public MonitorServiceImpl(ElecBrake elecBrake){
        this.elecBrake=elecBrake;
    }

    /**
     * 唯一标识一个插座检测
     * @param elecBrake
     * @param socket
     */
    public MonitorServiceImpl(ElecBrake elecBrake, Socket socket){
        this.elecBrake=elecBrake;
        this.socket=socket;
    }

    /**
     *
     * @param brake
     * @return Brake   to do cache
     */
    public static Brake show(Brake brake) {

        try{
            Socket socket=(Socket) brake;
            System.out.println("监控到的的Socket数据对象:"+socket+":"+socket.toString());
            return socket;
        }catch (Exception e){
            ElecBrake elecBrake=(ElecBrake) brake;
            System.out.println("监控到的ElecBrake数据对象:"+elecBrake+":"+elecBrake.toString());
            return elecBrake;
        }

    }
    /**
     * 向数据库写入东西
     * @param brake
     * @return  int 影响行数 ，因为show时已经入缓存了，此处不设置缓存了
     * @throws IOException
     */
    public static int storage(Brake brake) throws IOException {
        String resource = "mybatis_config.xml";
        SqlSession sqlSession;
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        try {
            Socket socket = (Socket) brake;
            SocketMapper socketMapper = new SocketMapperImpl(sqlSession);
            int a=socketMapper.insertSocket(socket);

            return a;

        } catch (Exception e) {
            ElecBrake elecBrake = (ElecBrake) brake;
            ElecBrakeMapper elecBrakeMapper = new ElecBrakeMapperImpl(sqlSession);
            int a=elecBrakeMapper.insertElecBrake(elecBrake);

            return a;
        }
    }

    /**
     * 监测数据是否异常
     *
     * @return 正常代表1绿  不稳定代表0黄   故障代表-1红
     */
    @Override
    public int monitor() {
        if (socket!=null &elecBrake != null) {
            Float t = socket.getT();
            if (t > 100) {
                return 0 ;
            } else {
                if (t > 70) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }else{
            if (elecBrake != null) {
                Float t = elecBrake.getT();
                if (t > 100) {
                    return 0;
                } else {
                    if (t > 70) {
                        return 1;
                    } else {
                        return 2;
                    }
                }

            }
        }

        return 500;
    }

    /**
     * 用于对方法返回结果进行缓存，如果已经存在该缓存，则直接从缓存中获取，缓存的key可以从入参中指定，缓存的 value 为方法返回值。
     * value :选择使用哪个缓存的名称，配置后就会应用那个缓存名称对应的配置
     * 标记类表示类中所有方法支持缓存   标记方法仅表示该方法支持
     */

    /**
     * 生产 电压 电流 温度 数据
     *展示后  存入缓存
     *
     * 缓存的 key  = "MonitorService::00000011"
     *  CacheConfig的cachenames必须有否则会报错 at least one cache per cache operation
     *
     * @return
     */
    @Override
    @Cacheable(key = "#user.uid+#elecBrake.zid+#socket.cid",unless = "#result==null")
    public Socket produceSocket(User user, ElecBrake elecBrake, Socket socket) throws IOException {

        float u=(new Random(System.currentTimeMillis()).nextInt(40)+200);
        //200~240V
        float i=(new Random(new Random().nextInt()).nextInt(8)+2);
        //2~10A
        float t=(new Random(new Random().nextInt()).nextInt(20)+55);
        //20~75℃

        this.socket=socket=new Socket(socket.getCid(),elecBrake.getZid(), user.getUid(), 1,u,i,u*i, u*i*1,t,new Date(),new Date());
        protectService=new ProtectServiceImpl(user,elecBrake,socket);
        show(socket);
        storage(socket);
        protectService.run();
        return socket;
    }

    @Override

    @Cacheable(key = "#user.uid+#elecBrake.zid",unless = "#result==null")
    public ElecBrake produceElecBrake(User user,ElecBrake elecBrake) throws IOException {
        //监控所有插座的产生数据，从缓存读
//        RedisTemplate redisTemplate=new RedisTemplate();
//        redisTemplate.opsForValue().get("elecBrake.getUid()+elecBrake.getZid()");

        float u=(new Random(System.currentTimeMillis()).nextInt(40)+200);
        //200~240V
        float i=(new Random(new Random().nextInt()).nextInt(8)+2);
        //2~10A
        float t=(new Random(new Random().nextInt()).nextInt(20)+55);
        //20~75℃
        this.elecBrake=elecBrake= new ElecBrake(elecBrake.getZid(), user.getUid(), 1,u,i,u*i, u*i*1,t,new Date(),new Date());
        protectService=new ProtectServiceImpl(user,elecBrake,socket);
        show(elecBrake);
        storage(elecBrake);
        protectService.run();
        return elecBrake;
    }


}
