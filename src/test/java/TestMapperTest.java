import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.TestMapper;
import org.example.mapper.TestMapperImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMapperTest {
    private TestMapper testMapper;
    private SqlSession sqlSession;
    
    @Before
    public void init() throws IOException{
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
        testMapper=new TestMapperImpl(sqlSession);
    }
    @Test
    public void insertTest(){
        org.example.entity.Test test=new org.example.entity.Test("222222");
        testMapper.insertTest(test);
    }
    @Test
    public void deleteTest(){
        org.example.entity.Test test=new org.example.entity.Test("222222");
        testMapper.deleteTest(test);
    }
    @Test
    public void updateTest(){
        org.example.entity.Test test=new org.example.entity.Test("222222");
        testMapper.updateTest(test);
    }
    //org.junit.runners.model.InvalidTestClassError: Invalid test class 'TestMapperTest':
//        1. Method selectAll() should be void
//        2. Method updateTest should have no parameters
//        3. Method selectTestById() should be void
//        4. Method selectTestById should have no parameters
//        5. Method insertTest should have no parameters
//        6. Method deleteTest should have no parameters
    @Test
    public void selectTestById(){
        org.example.entity.Test test=new org.example.entity.Test("111111");
        System.out.println(testMapper.selectTestById(test));
    }
    @Test
    public void selectAll(){
        List<org.example.entity.Test> testList=testMapper.selectAll();
        for (org.example.entity.Test test:
             testList) {
            System.out.println(test);
        }
    }
}
