package org.example.service.zy.serviceInterface;

import org.example.entity.ElecBrake;
import org.example.entity.Socket;

/**
 * 做数据的持久化，
 * Day 一天中的所有数据抽样 存储到Day表
 *  Week则从 Day 表中 抽样  存储到Week表
 * @author zy
 */
public interface DayAndWeekService {
    /**
     *删除这个总闸今天所有的数据
     * 每天晚上12：05进行
     * @param elecBrake
     * @return
     */
    public int deleteAll(ElecBrake elecBrake);

    /**
     * 删除这个插座今天的所有数据
     * 每天晚上12:05进行
     * @param socket
     * @return
     */
    public int deleteAll(Socket socket);

    /**
     * 从监控到的所有elecBrake数据中 抽样 持久化到 Day表
     * 每天晚上12点进行
     * @param elecBrake 表示持久化那个电闸数据
     * @return
     */
    public int elecBrakeDayPersistence(ElecBrake elecBrake);

    /**
     * 从Day表的所有elecBrake数据中 抽样 持久化到 Week表
     * 每天晚上12点进行
     * @param elecBrake 表示持久化那个电闸数据
     * @return
     */
    public int elecBrakeWeekPersistence(ElecBrake elecBrake);

    /**
     * 从监控到的所有socket数据中 抽样 持久化到 Day表
     * 每天晚上12点进行
     * @param socket 表示持久化那个插座数据
     * @return
     */
    public int socketDayPersistence(Socket socket);

    /**
     * 从Day表所有socket数据中 抽样 持久化到 Week表
     * 每天晚上12点进行
     * @param socket 表示持久化那个插座数据
     * @return
     */
    public int socketWeekPersistence(Socket socket);
}
