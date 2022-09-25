package zy.mapperTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.ElecBrake;
import org.example.mapper.zy.ElecBrakeMapper;
import org.example.mapper.zy.impl.ElecBrakeMapperImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class ElecBrakeMapperTest {
    private SqlSession sqlSession;
    private ElecBrakeMapper elecBrakeMapper;
    @Before
    public void init() throws IOException {
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        this.elecBrakeMapper=new ElecBrakeMapperImpl(sqlSession);
    }

    @Test
    public void insert(){
        ElecBrake elecBrake=new ElecBrake(1,"000000",1,220F,22F,4840F,10000F,26.6F,new Date(),new Date());
        int rv=elecBrakeMapper.insertElecBrake(elecBrake);
        System.out.println(rv);
    }
    @Test
    public void delete(){
        ElecBrake elecBrake=new ElecBrake(1,"000000",1,220F,22F,4840F,10000F,26.6F,new Date(),new Date());
        int rv=elecBrakeMapper.deleteElecBrake(elecBrake);
        System.out.println(rv);
    }
    @Test
    public void update(){
        ElecBrake elecBrake=new ElecBrake(1,"000000",1,220F,22F,4840F,10000F,26.6F,new Date(),new Date());
        int rv=elecBrakeMapper.updateElecBrake(elecBrake);
        System.out.println(rv);
    }
    @Test
    public void select(){
        ElecBrake elecBrake=new ElecBrake(1,"000000",1,220F,22F,4840F,10000F,26.6F,new Date(),new Date());
        ElecBrake elecBrake1=elecBrakeMapper.selectElecBrake(elecBrake);
        System.out.println(elecBrake1);
    }
    @Test
    public void selectAll(){
        for (ElecBrake e :
                elecBrakeMapper.selectAll()) {
            System.out.println(e);
        }
    }
}
