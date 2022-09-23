package org.example.service;


import org.example.MD5Utils;
import org.example.ResultVo;
import org.example.entity.User;
import org.example.mapper.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDAO userDAO;

    @Transactional
    public ResultVo addUser(String uid, String upassword, String uname, Integer ugender, String utelephone, Integer elecCharge) {
        synchronized(this) {
            // 1. 根据用户名查询用户是否存在
            User user = userDAO.getUserByName(uname);

            // 2. 如果用户不存在，则添加用户
            if(user == null) {
                String pwd = MD5Utils.md5(upassword);
                user = new User();
                user.setUid(uid);
                user.setUpassword(upassword);
                user.setUname(uname);
                user.setUgender(ugender);
                user.setUtelephone(utelephone);
                user.setElecCharge(elecCharge);
                int addUser = userDAO.addUser(user);
                if(addUser > 0) {
                    return new ResultVo(200, "注册成功", user);
                }else{
                    return new ResultVo(500, "注册失败", null);
                }
            }else{
                // 3. 如果用户存在，则返回用户已存在
                return new ResultVo(500, "用户已存在", null);
            }
        }
    }

    @Override
    public ResultVo checkLogin(String name, String password) {
        // 1. 根据用户名查询用户是否存在
        User user = userDAO.getUserByName(name);
        if(user == null) {
            return new ResultVo(500, "用户不存在", null);
        } else {
            // 2. 如果用户存在，则校验密码是否正确
            String pwd = MD5Utils.md5(password);
            if(pwd.equals(user.getUpassword())) {
                return new ResultVo(200, "登录成功", user);
            } else {
                return new ResultVo(500, "密码错误", null);
            }
        }
    }
}


