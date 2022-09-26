package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.Socket;
import org.example.mapper.zy.SocketWeekMapper;

import java.util.List;
/**
 * @author zy
 */
public class SocketWeekMapperImpl implements SocketWeekMapper {
    public SqlSession sqlSession;
    public SocketWeekMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}
    @Override
    public int insertSocketWeek(Socket socketWeek) {
        return sqlSession.insert("socketWeekMapper.insertSocketWeek",socketWeek);
    }

    @Override
    public int deleteSocketWeek(Socket socketWeek) {
        return sqlSession.delete("socketWeekMapper.deleteSocketWeek",socketWeek);
    }

    @Override
    public int updateSocketWeek(Socket socketWeek) {
        return sqlSession.update("socketWeekMapper.updateSocketWeek",socketWeek);
    }

    @Override
    public Socket selectSocketWeek(Socket socketWeek) {
        return sqlSession.selectOne("socketWeekMapper.selectSocketWeek",socketWeek);

    }

    @Override
    public List<Socket> selectAll() {
        return sqlSession.selectList("socketWeekMapper.selectAll");
    }
}
