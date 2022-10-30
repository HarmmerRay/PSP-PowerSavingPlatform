package org.example.service.zy.serviceInterface;


import org.example.service.zy.entity.ResultTo;
import org.springframework.stereotype.Service;

/**
 * @author zy
 */
@Service
public interface StateService {
    /**
     * 0 断电  1 运行中  2节能模式
     * 关闭系统
     * @return  状态值
     */
    int shutdown();

    /**
     * 定时间点断电
     * @param resultTo  获取开始时间
     * @return
     */
    int shutdownS(ResultTo resultTo);

    /**
     * 定时间区间断电
     * @param resultTo 获取开始时间 和截止时间
     * @return
     */
    int shutdownSe(ResultTo resultTo);

    /**
     * 启动系统
     * @return 状态值
     */
    int startup();

    /**
     * 开启系统节能模式
     * @return 状态值
     */
    int savingMode();

    /**
     * 查看当前系统状态，并返回
     * @return 状态值
     */
    int state();
}
