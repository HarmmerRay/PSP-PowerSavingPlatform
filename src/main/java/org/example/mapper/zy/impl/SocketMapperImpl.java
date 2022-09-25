package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.Socket;
import org.example.mapper.zy.SocketMapper;

import java.util.List;
/**
 * @author zy
 */
public class SocketMapperImpl implements SocketMapper{
    public SqlSession sqlSession;
    public SocketMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}
    @Override
    public int insertSocket(Socket socket) {
        return sqlSession.insert("socketMapper.insertSocket",socket);
    }

    @Override
    public int deleteSocket(Socket socket) {
        return sqlSession.delete("socketMapper.deleteSocket",socket);
    }

    @Override
    public int updateSocket(Socket socket) {
        return sqlSession.update("socketMapper.updateSocket",socket);
    }

    @Override
    public Socket selectSocket(Socket socket) {
        return sqlSession.selectOne("socketMapper.selectSocket",socket);

    }

    @Override
    public List<Socket> selectAll() {
        return sqlSession.selectList("socketMapper.selectAll");
    }
}
