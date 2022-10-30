package org.example.service.zy.interfaceImpl;

import org.example.SpringBootDemoApp;
import org.example.service.zy.entity.ResultTo;
import org.example.service.zy.serviceInterface.StateService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zy
 */
@Service
public class StateServiceImpl implements StateService {


    /**
     * 0 断电  1 运行中  2节能模式
     *
     * @param
     * @return
     */
    @Override
    public int  shutdown() {
            SpringBootDemoApp.state=0;
            System.out.println("智能电路系统停止运行");
            SpringBootDemoApp.ctx.close();
            return state();
    }

    /**
     * 定时间点断电
     *
     * @param resultTo 获取开始时间
     * @return
     */
    @Override
    public int shutdownS(ResultTo resultTo) {
        System.out.println(resultTo.getMsg());
        //若间隔时间太长，可以加入 现在的时间与 设定的时间之差，在差值时间之前几秒再运行此程序
        while (true){
            if(new Date().toString().equals(resultTo.getStime())){
                return shutdown();
            }
        }

    }

    /**
     * 定时间区间断电
     *
     * @param resultTo 获取开始时间 和截止时间
     * @return
     */
    @Override
    public int shutdownSe(ResultTo resultTo) {
        String stime=resultTo.getStime();
        String etime=resultTo.getEtime();
        System.out.println(resultTo.getMsg());
        while (true){
            System.out.println("正在等待………………");
            if(new Date().toString().equals(stime)){
                return shutdown();
            }
            //在开始时间和截止时间  的差值时间之前几秒再次运行此程序.
            if(new Date().toString().equals(etime)){
                return startup();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int startup() {
            SpringBootDemoApp .state=1;
            System.out.println("智能电路系统开始工作");
            return state();
    }

    @Override
    public int savingMode() {
            if(SpringBootDemoApp.state==1){
                System.out.println("节能模式开启");

                //这个只是改变系统当前状态  通过读取系统状态来开启对应的模式   开机 关机 省电 都可以这样做
                SpringBootDemoApp.state=2;
                return state();
            }
            else {
                System.out.println("Error: 您还未启动系统");
                return 500;
            }

    }

    @Override
    public int state() {
        return SpringBootDemoApp.state;
    }
}
