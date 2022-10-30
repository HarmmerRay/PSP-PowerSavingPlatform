package org.example.controller.zy.test;

import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.example.mapper.zy.SocketMapper;

import org.example.mapper.zy.impl.SocketMapperImpl;

import org.example.service.zy.interfaceImpl.MonitorServiceImpl;
import org.example.service.zy.serviceInterface.MonitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 配置完配置文件后  测试redis是否正常工作
 * @author zy
 */
@Controller
public class RedisTestController {
    @Resource
    MonitorService monitorService;
    @RequestMapping("redisTest")
    public String redisTest(){

        User user=new User();
        user.setUid("000000");
        user.setUpassword("000000");
        user.setUname("xxxx");
        user.setUgender(true);
        user.setUtelephone("13290824341");
        user.setElecCharge(0);

        ElecBrake elecBrake=new ElecBrake();
        elecBrake.setUid(user.getUid());
        elecBrake.setZid(1);

        Socket socket=new Socket();
        socket.setUid(user.getUid());
        socket.setZid(elecBrake.getZid());
        socket.setCid(2);

        try {
            monitorService.produceElecBrake(user,elecBrake);
            monitorService.produceSocket(user,elecBrake,socket);
        } catch (IOException e) {
            e.printStackTrace();
        }





        return "success!:";
    }

}
