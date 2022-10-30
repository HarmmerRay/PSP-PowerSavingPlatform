package zy.serviceTest;

import org.example.entity.ElecBrake;
import org.example.entity.Socket;
import org.example.entity.User;
import org.example.mapper.zy.SocketMapper;
import org.example.mapper.zy.impl.SocketMapperImpl;

import org.example.service.zy.interfaceImpl.MonitorServiceImpl;
import org.example.service.zy.serviceInterface.MonitorService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import zy.ApplicationContextProvider;

import javax.annotation.Resource;
import java.io.IOException;
@SpringBootTest
@SpringBootConfiguration
@RunWith(SpringRunner.class)
public class MonitorServiceTest {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    MonitorService monitorService;
    public MonitorServiceTest(){

    }
    @Test
    public void dataProduce() throws IOException {


    }
}
