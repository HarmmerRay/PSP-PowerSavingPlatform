package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.checkerframework.checker.units.qual.C;
import org.example.entity.Socket;
import org.example.mapper.zy.SocketDayMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;


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
    @CacheEvict(key = "#socket.uid+#socket.zid+#socket.cid")
    public int deleteSocketDay(Socket socketDay) {
        return sqlSession.delete("socketDayMapper.deleteSocketDay",socketDay);
    }

    @Override

    public int updateSocketDay(Socket socketDay) {
        return sqlSession.update("socketDayMapper.updateSocketDay",socketDay);
    }

    @Override
    @Cacheable(key = "#socket.uid+#socket.zid+#socket.cid" ,unless ="#result==null")
    public Socket selectSocketDay(Socket socketDay) {
        return sqlSession.selectOne("socketDayMapper.selectSocketDay",socketDay);

    }

    @Override
    @Cacheable(key = "#result.hashCode()" ,unless = "#result==null")
    public List<Socket> selectAll() {
        return sqlSession.selectList("socketDayMapper.selectAll");
    }
}
