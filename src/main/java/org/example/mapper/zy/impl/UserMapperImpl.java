package org.example.mapper.zy.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.User;
import org.example.mapper.zy.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 * Dao设计可以  是只有一个interface 所有implement 贯彻它
 * @author zy
 */

public class UserMapperImpl implements UserMapper {
    public SqlSession sqlSession;
    public UserMapperImpl( SqlSession sqlSession){this.sqlSession=sqlSession;}
    public UserMapperImpl() throws IOException {
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();

    }
    @Override

    public int insertUser(User user) {
        int a= sqlSession.insert("userMapper.insertUser",user);
        sqlSession.commit();
        return a;
    }

    @Override
    @CacheEvict(key = "#user.uid")
    public int deleteUser(User user) {
        return sqlSession.delete("userMapper.deleteUser",user);
    }

    @Override
    public int updateUser(User user) {
        return sqlSession.update("userMapper.updateUser",user);
    }

    @Override
    @Cacheable(key = "#user.uid",unless = "#result==null")
    public User selectUser(User user) {
        return sqlSession.selectOne("userMapper.selectUser",user);

    }

    @Override
    @Cacheable(key = "#result.hashCode()",unless = "#result==null")
    public List<User> selectAll() {
        return sqlSession.selectList("userMapper.selectAll");
    }
}
