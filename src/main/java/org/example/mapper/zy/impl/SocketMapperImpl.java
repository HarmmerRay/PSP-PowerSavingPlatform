package org.example.mapper.zy.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Socket;
import org.example.mapper.zy.SocketMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * @author zy
 */
public class SocketMapperImpl implements SocketMapper{
    public SqlSession sqlSession;
    public SocketMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}
    public SocketMapperImpl() throws IOException {
        String resource="mybatis_config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession=sqlSessionFactory.openSession();
    }
    @Override
    public int insertSocket(Socket socket) {
        int a=sqlSession.insert("socketMapper.insertSocket",socket);
        sqlSession.commit();
        return a;
    }

    @Override
    @CacheEvict(key = "#socket.uid+#socket.zid+#socket.cid")
    public int deleteSocket(Socket socket) {
        return sqlSession.delete("socketMapper.deleteSocket",socket);
    }

    @Override

    public int updateSocket(Socket socket) {
        return sqlSession.update("socketMapper.updateSocket",socket);
    }

    @Override
    @Cacheable(key = "#socket.uid+#socket.zid+#socket.cid" ,unless ="#result==null")
    public Socket selectSocket(Socket socket) {
        return sqlSession.selectOne("socketMapper.selectSocket",socket);

    }

    @Override
    @Cacheable(key = "#result.hashCode()" ,unless = "#result==null")
    public List<Socket> selectAll() {
        return sqlSession.selectList("socketMapper.selectAll");
    }
}
