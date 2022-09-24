package org.example.controller.wdx;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.example.ResultClose;
import org.example.service.wdx.StateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/state")
@Api(tags = "状态管理")
public class StateController {

    @Resource
    private StateService StateService;

    @GetMapping("/cstate")
    @ApiOperation("变电状态")
    @ApiImplicitParam(name = "state", value = "状态值", dataType = "int", required = true)
    public ResultClose close(
            @RequestParam("state") int state) {
        return StateService.state(state);
    }


}

