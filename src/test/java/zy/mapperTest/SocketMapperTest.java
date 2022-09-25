package zy.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Socket;
import org.example.mapper.zy.SocketMapper;
import org.example.mapper.zy.impl.SocketMapperImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class SocketMapperTest {
    private SqlSession sqlSession;
    private SocketMapper socketMapper;
    @Before
    public void init() throws IOException {
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        this.socketMapper=new SocketMapperImpl(sqlSession);
    }

    @Test
    public void insert(){
        Socket socket=new Socket(1,1,"000000",1, 220.0F, 20.0F, 4400.0F, 10000F, (float) 27.1,new Date(),new Date());
        int returnValue=socketMapper.insertSocket(socket);
        System.out.println(returnValue);
    }
    @Test
    public void delete(){
        Socket socket=new Socket(1,1,"000000",1, 220.0F, 20.0F, 4400.0F, 10000F, (float) 27.1,new Date(),new Date());
        int rv=socketMapper.deleteSocket(socket);
        System.out.println(rv);
    }
    @Test
    public void update(){
        Socket socket=new Socket(1,1,"000000",1, 220.0F, 20.0F, 4400.0F, 10000F, (float) 27.1,new Date(),new Date());
        int rv=socketMapper.updateSocket(socket);
        System.out.println(rv);
    }
    @Test
    public void select(){
        Socket socket=new Socket(1,1,"000000",1, 220.0F, 20.0F, 4400.0F, 10000F, (float) 27.1,new Date(),new Date());
        System.out.println(socketMapper.selectSocket(socket));
    }
    @Test
    public void selectAll(){
        for (Socket s:
             socketMapper.selectAll()) {
            System.out.println(s);
        }
    }
}
