package org.example.controller.zy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.User;
import org.example.mapper.zy.UserMapper;
import org.example.mapper.zy.impl.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;

/**
 * 配置完配置文件后  测试redis是否正常工作
 * @author zy
 */
@Controller
public class RedisTestController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @RequestMapping("redisTest")
    public String redisTest(){

        String resource = "mybatis_config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = new UserMapperImpl(sqlSession);
        User user=new User();
        user.setUid("000000");
        userMapper.selectUser(user);
        //write into redis cache
        stringRedisTemplate.opsForValue().set("test",String.valueOf(user));
        // read from redis cache
        System.out.println(stringRedisTemplate.opsForValue().get("test"));
        return "success!:"+stringRedisTemplate.opsForValue().get("test");
    }

}
