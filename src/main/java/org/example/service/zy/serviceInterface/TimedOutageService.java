package org.example.service.zy.serviceInterface;

import org.example.service.zy.entity.ResultTo;
import org.springframework.stereotype.Service;

@Service
public interface TimedOutageService {
    /**
     * 何时开始断电
     * @param time
     * @param msg
     * @return
     */
    ResultTo tos(String time, String msg);

    /**
     * 断电区间
     * @param stime
     * @param etime
     * @param msg
     * @return
     */
    ResultTo stos(String stime ,String etime,String msg);
}
