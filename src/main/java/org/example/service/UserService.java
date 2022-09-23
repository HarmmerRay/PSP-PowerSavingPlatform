package org.example.service;


import org.example.ResultVo;

public interface UserService {
    // 添加用户
    ResultVo addUser(String uid, String upassword, String uname, Integer ugender, String utelephone, Integer elecCharge);
    // 根据用户名查询用户
    ResultVo checkLogin(String name, String password);
}







