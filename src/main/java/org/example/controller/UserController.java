package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.example.ResultVo;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理模块")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uname", value = "用户名", dataType = "String", required = true),
            @ApiImplicitParam(name = "upassword", value = "密码", dataType = "String", required = true)
    })
    public ResultVo register(
            @RequestParam("uid") String uid,
            @RequestParam("upassword") String upassword,
            @RequestParam("uname") String uname,
            @RequestParam("ugender") Integer ugender,
            @RequestParam("utelephone") String utelephone,
            @RequestParam("elecCharge") Integer elecCharge) {
        return userService.addUser(uid, upassword, uname, ugender, utelephone, elecCharge);
    }

    @GetMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uname", value = "用户名", dataType = "String", required = true),
            @ApiImplicitParam(name = "upassword", value = "密码", dataType = "String", required = true)
    })
    public ResultVo login(@RequestParam("uname") String uname, @RequestParam("upassword") String upassword) {
        return userService.checkLogin(uname, upassword);
    }
}

