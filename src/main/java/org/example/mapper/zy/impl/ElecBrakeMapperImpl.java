package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.ElecBrake;
import org.example.mapper.zy.ElecBrakeMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
/**
 * @author zy
 */
@CacheConfig(cacheNames = "elecBrakeMapper")
public class ElecBrakeMapperImpl implements ElecBrakeMapper {
    public SqlSession sqlSession;
    public ElecBrakeMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}
    @Override
    public int insertElecBrake(ElecBrake elecBrake) {
        return sqlSession.insert("elecBrakeMapper.insertElecBrake",elecBrake);
    }

    @Override
    @CacheEvict(key="#elecBrake.uid+#elecBrake.zid")
    public int deleteElecBrake(ElecBrake elecBrake) {
        return sqlSession.delete("elecBrakeMapper.deleteElecBrake",elecBrake);
    }

    @Override

    public int updateElecBrake(ElecBrake elecBrake) {
        return sqlSession.update("elecBrakeMapper.updateElecBrake",elecBrake);
    }

    @Override
    @Cacheable(key = "elecBrake.uid+#elecBrake.zid" ,unless = "#result==null")
    public ElecBrake selectElecBrake(ElecBrake elecBrake) {
        return sqlSession.selectOne("elecBrakeMapper.selectElecBrake",elecBrake);

    }
    @Override
    /**
     * result==null 不进行缓存
     */
    @Cacheable(key = "#result.hashCode()" ,unless = "#result==null")
    public List<ElecBrake> selectAll() {
        return sqlSession.selectList("elecBrakeMapper.selectAll");
    }
}
