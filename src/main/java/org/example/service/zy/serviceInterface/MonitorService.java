package org.example.service.zy.serviceInterface;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Brake;
import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.example.mapper.zy.ElecBrakeMapper;
import org.example.mapper.zy.SocketMapper;
import org.example.mapper.zy.impl.ElecBrakeMapperImpl;
import org.example.mapper.zy.impl.ElecBrakeWeekMapperImpl;
import org.example.mapper.zy.impl.SocketMapperImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.text.BreakIterator;

/**
 *   监测
 * @author zy
 */

public interface MonitorService {
    /**
     * 展示现在 电压 电流 温度
     *
     * @return 返回给前端数据对象
     * <p>
     * 向上转型：检测子类中有没有重写父类的方法，有就用子类的，没有就用父类的
     * 向下转型: 可以用到子类有但父类不存在的方法.
     */

    /**

     * @return
     */
    /**
     *
     * 生产 电压 电流 温度 数据
     *    插座
     *         可以用继承优化
     * @param user  登录后有整个的user对象
     * @param elecBrake  只把 zid 封装成的对象
     * @param socket  只把 cid封装成的对象
     * @return
     */
    public Socket produceSocket(User user, ElecBrake elecBrake, Socket socket) throws IOException;

    /**
     * 生产 电压 电流 温度 数据
     * 产生完成,方法体内直接show 和 存入数据库 和存入缓存
     *  总闸u
     * @return
     */
    public ElecBrake produceElecBrake(User user,ElecBrake elecBrake) throws IOException;
    /**
     * 监测数据是否异常
     * @return 正常代表1绿  不稳定代表0黄   故障代表-1红
     */
    public int monitor();



}
