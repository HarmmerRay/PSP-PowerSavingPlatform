package org.example.service.wdx;

import org.example.ResultTo;

public class TimedOutageServicelmpl implements TimedOutageService{
    @Override
    public ResultTo tos(String time, String msg) {
        return new ResultTo();
    }

    @Override
    public ResultTo stos(String stime, String etime, String msg) {
        return null;
    }
}
