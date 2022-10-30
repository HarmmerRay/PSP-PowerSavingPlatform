package org.example.service.zy.interfaceImpl;

import org.example.SpringBootDemoApp;
import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.example.service.zy.serviceInterface.MonitorService;
import org.example.service.zy.serviceInterface.ProtectService;
import org.springframework.stereotype.Service;

/**
 * @author zy
 */

public class ProtectServiceImpl  implements ProtectService  {
    private User user;
    private ElecBrake elecBrake;
    private Socket socket;
    public ProtectServiceImpl(){};
    public ProtectServiceImpl(User user,ElecBrake elecBrake) {
        this.user=user;
        this.elecBrake=elecBrake;
    }
    public ProtectServiceImpl(User user,ElecBrake elecBrake,Socket socket){
        this.user=user;
        this.elecBrake=elecBrake;
        this.socket=socket;
    }


    public void run() {

        if(socket==null){

                int a=selfProtect(user,elecBrake);
                if(a==2){
                    System.out.println("电路正常，绿");
                }
                if(a==1){
                    System.out.println("电线感觉到热了哦，黄");
                }else {
                    if(a==0){
                        System.out.println("电路异常即将断电，红");
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }else {

                int a=selfProtect(user,elecBrake,socket);
                if(a==2){
                    System.out.println("电路正常，绿");
                }
                if(a==1){
                    System.out.println("电线感觉到热了哦，黄");
                }else {
                    if(a==0){
                        System.out.println("电路异常即将断电，红");
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }

    /**
     * 自我保护方法，守护进程；
     *
     * @param user
     */
    @Override
    public int selfProtect(User user, ElecBrake elecBrake, Socket socket) {
        MonitorService monitor=new MonitorServiceImpl(elecBrake,socket);
        int status=monitor.monitor();
        if(status==2){
            System.out.println("绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿");
            /**
             * 状态良好  绿
             */
            return 2;
        }
            if(status==1){
                System.out.println("黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄");
                /**
                 * 状态不稳定 黄
                 * 警告()  传 0 值给前端，让前端警告
                 */
                return 1;
            }
         if(status==0){
             System.out.println("红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红");
             /**
              * 状态异常  红
              * 确定插座精准断电
              * 断电()
              */
             SpringBootDemoApp.ctx.close();
        return 0;
         }
        return 500;
    }

    @Override
    public int selfProtect(User user, ElecBrake elecBrake) {
         MonitorService monitor=new MonitorServiceImpl(elecBrake);
        int status=monitor.monitor();
        if(status==2){
            System.out.println("绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿绿");
            /**
             * 状态良好  绿
             */
            return 2;
        }
        if(status==1){
            System.out.println("黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄黄");
            /**
             * 状态不稳定 黄
             * 警告()  传 0 值给前端，让前端警告
             */
            return 1;
        }
        if(status==0){
            System.out.println("红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红红");
            /**
             * 状态异常  红
             *
             * 整个断电()
             */
            SpringBootDemoApp.ctx.close();
            return 0;
        }
        return 500;
    }
}
