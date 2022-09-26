package org.example.service.zy;

import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author zy
 */
@Service
public class ProtectServiceImpl implements ProtectService {
    /**
     * 自我保护方法，守护进程；
     *
     * @param user
     */
    @Override
    public int  selfProtect(User user, ElecBrake elecBrake, Socket socket) {
        MonitorService monitor=new MonitorServiceImpl(elecBrake);
        int status=monitor.monitor();
        if(status==1){
            /**
             * 状态良好  绿
             */
            return 1;
        }
            if(status==0){
                /**
                 * 状态不稳定 黄
                 * 警告()
                 */
                return 0;
            }
         if(status==-1){
             /**
              * 状态异常  红
              * 确定插座精准断电
              * 断电()
              */
        return -1;
         }
        return 500;
    }

    @Override
    public int selfProtect(User user, ElecBrake elecBrake) {
        MonitorService monitor=new MonitorServiceImpl(elecBrake);
        int status=monitor.monitor();
        if(status==1){
            /**
             * 状态良好  绿
             */
            return 1;
        }
        if(status==0){
            /**
             * 状态不稳定 黄
             * 警告()
             */
            return 0;
        }
        if(status==-1){
            /**
             * 状态异常  红
             *
             * 整个断电()
             */
            return -1;
        }
        return 500;
    }
}
