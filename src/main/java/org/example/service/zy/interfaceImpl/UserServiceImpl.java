package org.example.service.zy.interfaceImpl;

import org.example.mapper.zy.impl.UserMapperImpl;
import org.example.entity.User;
import org.example.mapper.zy.UserMapper;
import org.example.service.zy.entity.ResultVo;
import org.example.service.zy.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * @author zy
 */
@Service
public class UserServiceImpl implements UserService {

    UserMapper userMapper;

    public UserServiceImpl() throws IOException {
        userMapper=new UserMapperImpl();
    }

    @Override
    public ResultVo register(User user) {
        synchronized(this) {
            // 1. 根据用户名查询用户是否存在
            User user1=userMapper.selectUser(user);

            // 2. 如果用户不存在，则添加用户
            if(user1 == null) {
                user1=user;
                user1.setUpassword(this.md5(user.getUpassword()));

                int addUser = userMapper.insertUser(user);
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
    public ResultVo login(User user) {
        // 1. 根据用户名查询用户是否存在
        //user1是从数据库选出来的
        User user1 = userMapper.selectUser(user);
        if(user1 == null) {
            return new ResultVo(500, "用户不存在", null);
        } else {
            // 2. 如果用户存在，则校验密码是否正确
            String pwd = this.md5(user.getUpassword());
            if(pwd.equals(user1.getUpassword())) {
                return new ResultVo(200, "登录成功", user);
            } else {
                return new ResultVo(500, "密码错误", null);
            }
        }
    }

    @Override
    public String md5(String password) {
        //生成一个md5加密器
        try{
            byte []bytes=password.getBytes(StandardCharsets.UTF_8);

            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算MD5 的值
            md.update(password.getBytes());

            //BigInteger 将8位的字符串 转成16位的字符串 得到的字符串形式是哈希码值
            //BigInteger(参数1,参数2) 参数1 是 1为正数 0为0 -1为负数
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
