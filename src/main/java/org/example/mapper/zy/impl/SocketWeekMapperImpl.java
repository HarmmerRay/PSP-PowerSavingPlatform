package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.Socket;
import org.example.mapper.zy.SocketWeekMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

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
    @CacheEvict(key = "#socket.uid+#socket.zid+#socket.cid")
    public int deleteSocketWeek(Socket socketWeek) {
        return sqlSession.delete("socketWeekMapper.deleteSocketWeek",socketWeek);
    }

    @Override

    public int updateSocketWeek(Socket socketWeek) {
        return sqlSession.update("socketWeekMapper.updateSocketWeek",socketWeek);
    }

    @Override
    @Cacheable(key = "#socket.uid+#socket.zid+#socket.cid" ,unless ="#result==null")
    public Socket selectSocketWeek(Socket socketWeek) {
        return sqlSession.selectOne("socketWeekMapper.selectSocketWeek",socketWeek);

    }

    @Override
    @Cacheable(key = "#result.hashCode()" ,unless = "#result==null")
    public List<Socket> selectAll() {
        return sqlSession.selectList("socketWeekMapper.selectAll");
    }
}
