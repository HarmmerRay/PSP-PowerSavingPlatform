package org.example.service.zy.interfaceImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.mapper.zy.*;
import org.example.mapper.zy.impl.*;
import org.example.service.zy.serviceInterface.DayAndWeekService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author zy
 */
public class DayAndWeekServiceImpl implements DayAndWeekService {
    ElecBrakeMapper elecBrakeMapper;
    ElecBrakeDayMapper elecBrakeDayMapper;
    ElecBrakeWeekMapper elecBrakeWeekMapper;
    SocketMapper socketMapper;
    SocketDayMapper socketDayMapper;
    SocketWeekMapper socketWeekMapper;
    SqlSession sqlSession;
    public DayAndWeekServiceImpl() throws IOException {
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        elecBrakeMapper =new ElecBrakeMapperImpl(sqlSession);
        elecBrakeDayMapper =new ElecBrakeDayMapperImpl(sqlSession);
        elecBrakeWeekMapper =new ElecBrakeWeekMapperImpl(sqlSession);
        socketMapper =new SocketMapperImpl(sqlSession);
        socketDayMapper =new SocketDayMapperImpl(sqlSession);
        socketWeekMapper =new SocketWeekMapperImpl(sqlSession);
    }

    /**
     * 删除这个总闸今天所有的数据
     * 每天晚上12：05进行
     *
     * @param elecBrake
     * @return
     */
    @Override
    public int deleteAll(ElecBrake elecBrake) {
        return elecBrakeMapper.deleteElecBrake(elecBrake);
    }

    /**
     * 删除这个插座今天的所有数据
     * 每天晚上12:05进行
     *
     * @param socket
     * @return
     */
    @Override
    public int deleteAll(Socket socket) {
        return socketMapper.deleteSocket(socket);
    }

    /**
     * 从监控到的所有elecBrake数据中 抽样 持久化到 Day表
     * 每天晚上12点进行
     *一个小时 一次  或者求一个小时内的平均值，持久一次
     *
     * 24*60*6=8640 条数据   表示10秒监控一次一天可产生这么多数据  一个小时360条数据
     * @return
     */
    @Override
    public int elecBrakeDayPersistence(ElecBrake elecBrake) {
        List<ElecBrake> list=elecBrakeMapper.selectAll();
        int num=0;
        int ret=0;
        float u=0;float i=0;float t=0;float p=0;float w=0;
        for (ElecBrake e :
                list) {
            num++;
            u=u+e.getU()/360;
            i=i+e.getI()/360;
            t=t+e.getT()/360;
            p=p+e.getP()/360;
            w=w+e.getW()/360;

            //计算num是不是360的倍数
            if(((float)num/360%1)==0){
                ElecBrake elecBrake1=new ElecBrake(elecBrake.getZid(),elecBrake.getUid(),
                        elecBrake.getStatus(),u,i,p,w,t,new Date(),new Date());
                ret=ret+elecBrakeMapper.insertElecBrake(elecBrake1);
                u=0;i=0;t=0;p=0;w=0;
            }

        }
        return ret;
    }

    /**
     * 从Day表的所有elecBrake数据中 抽样 持久化到 Week表
     * 每天晚上12点进行
     *一天 一次   或者求一天的平均值
     * @return
     */
    @Override
    public int elecBrakeWeekPersistence(ElecBrake elecBrake) {
        List<ElecBrake> list=elecBrakeDayMapper.selectAll();
        int num=0;
        int ret=0;
        float u=0;float i=0;float t=0;float p=0;float w=0;
        for(ElecBrake e:list){
            num++;
            //day表中一天的数据就24条，求个平均数，持久化到week表
            u=u+e.getU()/24;
            i=i+e.getI()/24;
            t=t+e.getT()/24;
            p=p+e.getP()/24;
            w=w+e.getW()/24;

            //计算num是不是360的倍数
            if(((float)num/24%1)==0){
                ElecBrake elecBrake1=new ElecBrake(elecBrake.getZid(),elecBrake.getUid(),
                        elecBrake.getStatus(),u,i,p,w,t,new Date(),new Date());
                ret=ret+elecBrakeMapper.insertElecBrake(elecBrake1);
                u=0;i=0;t=0;p=0;w=0;
            }
        }

        return ret;
    }

    /**
     * 从监控到的所有socket数据中 抽样 持久化到 Day表
     * 每天晚上12点进行
     *
     * @return
     */
    @Override
    public int socketDayPersistence(Socket socket) {
        List<Socket> list=socketMapper.selectAll();
        int num=0;
        int ret=0;
        float u=0;float i=0;float t=0;float p=0;float w=0;
        for (Socket s :
                list) {
            num++;
            u=u+s.getU()/360;
            i=i+s.getI()/360;
            t=t+s.getT()/360;
            p=p+s.getP()/360;
            w=w+s.getW()/360;

            //计算num是不是360的倍数
            if(((float)num/360%1)==0){
                Socket socket1=new Socket(socket.getCid(),socket.getZid(),socket.getUid(),
                        socket.getStatus(), u,i,p,w,t,new Date(),new Date());
                ret=ret+socketMapper.insertSocket(socket1);
                u=0;i=0;t=0;p=0;w=0;
            }
        }
        return ret;
    }

    /**
     * 从Day表所有socket数据中 抽样 持久化到 Week表
     * 每天晚上12点进行
     *
     * @return
     */
    @Override
    public int socketWeekPersistence(Socket socket) {
        List<Socket> list=socketMapper.selectAll();
        int num=0;
        int ret=0;
        float u=0;float i=0;float t=0;float p=0;float w=0;
        for (Socket s : list) {
            num++;
            //day表中一天的数据就24条，求个平均数，持久化到week表
            u=u+s.getU()/24;
            i=i+s.getI()/24;
            t=t+s.getT()/24;
            p=p+s.getP()/24;
            w=w+s.getW()/24;

            //计算num是不是24的倍数
            if(((float)num/24%1)==0){
                Socket socket1=new Socket(socket.getCid(),socket.getZid(),
                        socket.getUid(),socket.getStatus(),
                        u,i,p,w,t,new Date(),new Date());
                ret=ret+socketMapper.insertSocket(socket1);
                u=0;i=0;t=0;p=0;w=0;
            }
        }
        return ret;
    }

}

