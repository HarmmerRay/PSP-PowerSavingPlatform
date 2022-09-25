package zy.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Socket;
import org.example.mapper.zy.SocketWeekMapper;
import org.example.mapper.zy.impl.SocketWeekMapperImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class SocketWeekMapperTest {
    private SqlSession sqlSession;
    private SocketWeekMapper socketWeekMapper;
    @Before
    public void init() throws IOException {
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        this.socketWeekMapper=new SocketWeekMapperImpl(sqlSession);
    }

    @Test
    public void insert(){
        Socket socket=new Socket(1,1,"000000",1, 220.0F, 20.0F, 4400.0F, 10000F, (float) 27.1,new Date(),new Date());
        int returnValue=socketWeekMapper.insertSocketWeek(socket);
        System.out.println(returnValue);
    }
    @Test
    public void delete(){
        Socket socket=new Socket(1,1,"000000",1, 220.0F, 20.0F, 4400.0F, 10000F, (float) 27.1,new Date(),new Date());
        int rv=socketWeekMapper.deleteSocketWeek(socket);
        System.out.println(rv);
    }
    @Test
    public void update(){
        Socket socket=new Socket(1,1,"000000",1, 220.0F, 20.0F, 4400.0F, 10000F, (float) 27.1,new Date(),new Date());
        int rv=socketWeekMapper.updateSocketWeek(socket);
        System.out.println(rv);
    }
    @Test
    public void select(){
        Socket socket=new Socket(1,1,"000000",1, 220.0F, 20.0F, 4400.0F, 10000F, (float) 27.1,new Date(),new Date());
        System.out.println(socketWeekMapper.selectSocketWeek(socket));
    }
    @Test
    public void selectAll(){
        for (Socket s:
                socketWeekMapper.selectAll()) {
            System.out.println(s);
        }
    }
}