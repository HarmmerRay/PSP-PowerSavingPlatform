package org.example.service.zy;

import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @author zy
 */
@Service
public class HareWareServiceImpl implements HardWareService {
    /**
     * 获取 电压 电流 温度 数据
     *
     * @return
     */
    @Override
    public Socket acquireSocket(User user,ElecBrake elecBrake,Socket socket) {

        float u=(new Random(System.currentTimeMillis()).nextInt(40)+200);
        //200~240V
        float i=(new Random(new Random().nextInt()).nextInt(8)+2);
        //2~10A
        float t=(new Random(new Random().nextInt()).nextInt(20)+55);
        //20~75℃
        return new Socket(socket.getCid(),elecBrake.getZid(), user.getUid(), 1,u,i,u*i, u*i*1,t,new Date(),new Date());
    }

    @Override
    public ElecBrake acquireElecBrake(User user,ElecBrake elecBrake) {
        float u=(new Random(System.currentTimeMillis()).nextInt(40)+200);
        //200~240V
        float i=(new Random(new Random().nextInt()).nextInt(8)+2);
        //2~10A
        float t=(new Random(new Random().nextInt()).nextInt(20)+55);
        //20~75℃
        return new ElecBrake(elecBrake.getZid(), user.getUid(), 1,u,i,u*i, u*i*1,t,new Date(),new Date());
    }
}
