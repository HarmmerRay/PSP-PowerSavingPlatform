package org.example.controller.zy;

import io.swagger.annotations.*;
import org.example.service.zy.entity.ResultTo;
import org.example.service.zy.interfaceImpl.TimedOutageServicelmpl;
import org.example.service.zy.serviceInterface.StateService;
import org.example.service.zy.serviceInterface.TimedOutageService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zy
 */
@RestController

@Api(tags = "断电时间设置")
public class TimedOutageController {


    private TimedOutageService timedOutageService=new TimedOutageServicelmpl();

    //此处的RequestMapping 要和类名上的保持同类型的注释 否则请求不过来
    @PostMapping("/tos")
    @ApiOperation("设置时间点断电时间")

    public @ResponseBody ResultTo tos(
             @RequestParam(name="断电开始time") String time,@RequestParam(name = "msg") String msg) {
        return timedOutageService.tos(time,msg);

    }

    @PostMapping("/stos")
    @ApiOperation("设置时间区间断电时间")
    public @ResponseBody ResultTo stos(
             @RequestParam(name = "stime") String stime, @RequestParam(name = "etime") String etime, @RequestParam(name = "msg") String msg) {
        return timedOutageService.stos(stime,etime,msg);

    }

}