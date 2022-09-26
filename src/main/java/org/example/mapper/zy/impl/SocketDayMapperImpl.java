package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.Socket;
import org.example.mapper.zy.SocketDayMapper;


import java.util.List;
/**
 * @author zy
 */
public class SocketDayMapperImpl implements SocketDayMapper {
    public SqlSession sqlSession;
    public SocketDayMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}
    @Override
    public int insertSocketDay(Socket socketDay) {
        return sqlSession.insert("socketDayMapper.insertSocketDay",socketDay);
    }

    @Override
    public int deleteSocketDay(Socket socketDay) {
        return sqlSession.delete("socketDayMapper.deleteSocketDay",socketDay);
    }

    @Override
    public int updateSocketDay(Socket socketDay) {
        return sqlSession.update("socketDayMapper.updateSocketDay",socketDay);
    }

    @Override
    public Socket selectSocketDay(Socket socketDay) {
        return sqlSession.selectOne("socketDayMapper.selectSocketDay",socketDay);

    }

    @Override
    public List<Socket> selectAll() {
        return sqlSession.selectList("socketDayMapper.selectAll");
    }
}
