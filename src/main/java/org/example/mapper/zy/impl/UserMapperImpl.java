package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.User;
import org.example.mapper.zy.UserMapper;

import java.util.List;

/**
 * @author zy
 */
public class UserMapperImpl implements UserMapper {
    public SqlSession sqlSession;
    public UserMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}
    @Override
    public int insertUser(User user) {
        return sqlSession.insert("userMapper.insertUser",user);
    }

    @Override
    public int deleteUser(User user) {
        return sqlSession.delete("userMapper.deleteUser",user);
    }

    @Override
    public int updateUser(User user) {
        return sqlSession.update("userMapper.updateUser",user);
    }

    @Override
    public User selectUser(User user) {
        return sqlSession.selectOne("userMapper.selectUser",user);

    }

    @Override
    public List<User> selectAll() {
        return sqlSession.selectList("userMapper.selectAll");
    }
}
