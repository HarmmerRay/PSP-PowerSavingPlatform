package org.example.controller.zy;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.entity.ElecBrake;
import org.example.entity.User;
import org.example.service.zy.serviceInterface.ProtectService;
import org.example.service.zy.interfaceImpl.ProtectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author zy
 */
@Controller

@Api(tags = "守护电路")
public class SelfProtectController {
    ProtectServiceImpl protectService;
    @PostMapping("/selfProtect")
    @ApiOperation("自我保护")
    public int selfProtect(@RequestBody @ApiParam("用户 和 电闸 的Json 来指定保护对象")String json){
        JSONObject jsonObject= JSON.parseObject(json);
        User user=jsonObject.getObject("user",User.class);
        ElecBrake elecBrake=jsonObject.getObject("elecBrake",ElecBrake.class);
        System.out.println("自我保护已开启");
        while (true){
            protectService=new ProtectServiceImpl(user,elecBrake);
            protectService.run();
        }

            //600 待完善，先从终端输出实验结果
        }
    }



