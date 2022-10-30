package org.example.controller.zy;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.service.zy.entity.ResultTo;
import org.example.service.zy.interfaceImpl.StateServiceImpl;
import org.example.service.zy.serviceInterface.StateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/state")
@Api(tags = "状态管理")
public class StateController {
    StateService stateService=new StateServiceImpl();
    @ApiOperation("关闭系统")
    @PostMapping("/shutdown")
    public int shutdown(){
        return stateService.shutdown();
    }

    @ApiOperation("固定时间关闭系统")
    @PostMapping("/shutdown_s")
    public @ResponseBody int shutdown_s(@RequestBody @ApiParam(name = "无etime的ResultTo对象") String json){
        JSONObject jsonObject= JSON.parseObject(json);
        ResultTo resultTo=jsonObject.getObject("resultTo",ResultTo.class);
            return stateService.shutdownS(resultTo);
    }

    @ApiOperation("固定时间区间关闭系统")
    @PostMapping("/shutdown_se")
    public @ResponseBody int shutdown_se(@RequestBody @ApiParam(name="有etime的ResultTo对象") String json){
        JSONObject jsonObject= JSON.parseObject(json);
        ResultTo resultTo=jsonObject.getObject("resultTo",ResultTo.class);
                return stateService.shutdownSe(resultTo);
    }

    @ApiOperation("启动系统")
    @PostMapping("/startup")
    public int startup(){
        return stateService.startup();
    }

    @ApiOperation("启动系统节能模式")
    @PostMapping("/savingMode")
    public int savingMode(){
        return stateService.savingMode();
    }
}
