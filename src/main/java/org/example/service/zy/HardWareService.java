package org.example.service.zy;

import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;

/**
 *  智能插座 智能总闸硬件
 * 模拟产生数据
 * @author zy
 */
public interface HardWareService {
    /**
     * 获取 电压 电流 温度 数据
     * 插座
     *      可以用继承优化
     * @return
     */
    public Socket acquireSocket(User user,ElecBrake elecBrake,Socket socket);

    /**
     * 获取 电压 电流 温度 数据
     *  总闸u
     * @return
     */
    public ElecBrake acquireElecBrake(User user,ElecBrake elecBrake);

}
