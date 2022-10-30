package org.example.controller.zy;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.entity.User;
import org.example.service.zy.entity.ResultVo;
import org.example.service.zy.interfaceImpl.UserServiceImpl;
import org.example.service.zy.serviceInterface.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * 启动项目页面
 * @author zy
 */
@Controller
@Api(tags = "开始")
public class StartController {
    @ApiOperation("登录")
    @PostMapping("/login")
    public @ResponseBody Object login(@RequestBody User user) throws IOException {
        UserService userService =new UserServiceImpl();
        ResultVo resultVo=userService.login(user);
        return resultVo;
    }
    @ApiOperation("注册")
    @PostMapping("/register")
    public @ResponseBody Object register(@RequestBody User user) throws IOException {
        UserService userService=new UserServiceImpl();
        ResultVo resultVo=userService.register(user);
        return resultVo;
    }
}
