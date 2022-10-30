package org.example.service.zy.interfaceImpl;

import org.example.service.zy.entity.ResultTo;
import org.example.service.zy.serviceInterface.TimedOutageService;
import org.springframework.stereotype.Service;

@Service
public class TimedOutageServicelmpl implements TimedOutageService {
    @Override
    public ResultTo tos(String stime, String msg) {
        ResultTo resultTo=new ResultTo();
        resultTo.setStime(stime);
        resultTo.setMsg("设置成功,系统将在"+stime+"断电");
        return resultTo;
    }

    @Override
    public ResultTo stos(String stime, String etime, String msg) {
        ResultTo resultTo=new ResultTo();
        resultTo.setStime(stime);
        resultTo.setEtime(etime);
        resultTo.setMsg("设置成功，系统将在"+stime+"断电"+"，在"+etime+"启动");
        return resultTo;
    }
}
