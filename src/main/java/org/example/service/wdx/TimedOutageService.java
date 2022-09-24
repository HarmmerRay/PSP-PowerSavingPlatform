package org.example.service.wdx;

import org.example.ResultTo;

public interface TimedOutageService {
    ResultTo tos(String time,String msg);
    ResultTo stos(String stime ,String etime,String msg);
}
