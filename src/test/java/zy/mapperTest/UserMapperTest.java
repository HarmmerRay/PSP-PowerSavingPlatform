package zy.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.User;
import org.example.mapper.zy.UserMapper;
import org.example.mapper.zy.impl.UserMapperImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;
    @Before
    public void init() throws IOException {
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        this.userMapper=new UserMapperImpl(sqlSession);
    }

    @Test
    public void insert(){
        User user=new User();
        user.setUid("000000");
        user.setUpassword("000000");
        user.setUname("zy");
        user.setUgender(true);
        user.setUtelephone("13290824341");
        user.setElecCharge(0);
        userMapper.insertUser(user);
    }
    @Test
    public void delete(){
        User user=new User();
        user.setUid("000000");

        System.out.println(userMapper.deleteUser(user));
    }
    @Test
    public void update(){
        User user=new User();
        user.setUid("000000");
        user.setUpassword("000000");
        user.setUname("xxxx");
        user.setUgender(true);
        user.setUtelephone("13290824341");
        user.setElecCharge(0);
        System.out.println(userMapper.updateUser(user));
    }
    @Test
    public void select(){
        User user=new User();
        user.setUid("000000");
        System.out.println(userMapper.selectUser(user));
    }
    @Test
    public void selectAll(){
        List<User> list=userMapper.selectAll();
        for (User user:
            list) {
            System.out.println(user);
        }
    }


}
