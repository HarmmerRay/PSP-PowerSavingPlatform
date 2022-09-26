package org.example.service.zy;

import org.example.entity.Brake;
import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.springframework.stereotype.Service;

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
     * 展示现在 电压 电流 温度
     *
     * @return 返回给前端数据对象
     */
    @Override
    public Brake show() {
        if(socket!=null &elecBrake!=null){
            System.out.println(socket);
            return socket;
        }
        if(elecBrake!=null){
            System.out.println(elecBrake);
            return elecBrake;
        }

        throw new RuntimeException("值为空");

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
}
