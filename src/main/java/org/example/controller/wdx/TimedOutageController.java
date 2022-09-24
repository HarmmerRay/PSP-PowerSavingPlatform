package org.example.controller.wdx;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.example.ResultTo;
import org.example.service.wdx.StateService;
import org.example.service.wdx.TimedOutageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/toc")
@Api(tags = "断电管理")
public class TimedOutageController {

    @Resource
    private TimedOutageService  timedOutageService;
    @Resource
    private StateService stateService;

    @GetMapping("/tos")
    @ApiOperation("定时断电")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "断电时间", dataType = "String", required = true),
            @ApiImplicitParam(name = "msg", value = "断电提示", dataType = "String", required = true)
    })
    public ResultTo tos(
            @RequestParam("time") String time,@RequestParam("msg") String msg) {
        return timedOutageService.tos(time,msg);

    }

    @GetMapping("/stos")
    @ApiOperation("定时断电")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stime", value = "断电时间", dataType = "String", required = true),
            @ApiImplicitParam(name = "etime", value = "断电时间", dataType = "String", required = true),
            @ApiImplicitParam(name = "msg", value = "断电提示", dataType = "String", required = true)
    })
    public ResultTo stos(
            @RequestParam("stime") String stime,@RequestParam("etime") String etime,@RequestParam("msg") String msg) {
        return timedOutageService.stos(stime,etime,msg);

    }

}