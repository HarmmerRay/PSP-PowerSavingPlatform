package org.example.service.zy.interfaceImpl;

import org.example.entity.Brake;
import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.example.service.zy.serviceInterface.MonitorService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @author zy
 */
@Service
public class MonitorServiceImpl implements MonitorService {
    private Socket socket;
    private ElecBrake elecBrake;
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
     * 监测数据是否异常
     *
     * @return 正常代表1绿  不稳定代表0黄   故障代表-1红
     */
    @Override
    public int monitor() {
        if (socket!=null &elecBrake != null) {
            Float t = socket.getT();
            if (t > 75) {
                return -1;
            } else {
                if (t < 45) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        if (elecBrake != null) {
            Float t = elecBrake.getT();
            if (t > 75) {
                return -1;
            } else {
                if (t < 45) {
                    return 0;
                } else {
                    return 1;
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
     * @return
     */
    @Override
    @Cacheable(key = "#result.hashCode()",unless = "#result==null", value = "cacheConfig1",sync = true)
    public Socket produceSocket(User user, ElecBrake elecBrake, Socket socket) {

        float u=(new Random(System.currentTimeMillis()).nextInt(40)+200);
        //200~240V
        float i=(new Random(new Random().nextInt()).nextInt(8)+2);
        //2~10A
        float t=(new Random(new Random().nextInt()).nextInt(20)+55);
        //20~75℃
        Socket socket1=new Socket(socket.getCid(),elecBrake.getZid(), user.getUid(), 1,u,i,u*i, u*i*1,t,new Date(),new Date());
        MonitorService.show(socket1);
        return socket1;
    }

    @Override
    @Cacheable(key = "#result.hashCode()",unless = "#result==null", value = "cacheConfig1" ,sync = true)
    public ElecBrake produceElecBrake(User user,ElecBrake elecBrake) {
        float u=(new Random(System.currentTimeMillis()).nextInt(40)+200);
        //200~240V
        float i=(new Random(new Random().nextInt()).nextInt(8)+2);
        //2~10A
        float t=(new Random(new Random().nextInt()).nextInt(20)+55);
        //20~75℃
        ElecBrake elecBrake1= new ElecBrake(elecBrake.getZid(), user.getUid(), 1,u,i,u*i, u*i*1,t,new Date(),new Date());
        MonitorService.show(elecBrake1);
        return elecBrake1;
    }

    /**
     * 向数据库写入东西
     */

}
