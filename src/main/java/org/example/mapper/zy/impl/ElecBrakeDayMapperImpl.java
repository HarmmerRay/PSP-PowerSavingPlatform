package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.ElecBrake;
import org.example.mapper.zy.ElecBrakeDayMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author zy
 */

public class ElecBrakeDayMapperImpl implements ElecBrakeDayMapper {
    public SqlSession sqlSession;
    public ElecBrakeDayMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}

    @Override
    public int insertElecBrakeDay(ElecBrake elecBrake) {
        return sqlSession.insert("elecBrakeDayMapper.insertElecBrakeDay",elecBrake);
    }

    @Override
    @CacheEvict(key="#elecBrake.uid+#elecBrake.zid")
    public int deleteElecBrakeDay(ElecBrake elecBrake) {
        return sqlSession.delete("elecBrakeDayMapper.deleteElecBrakeDay",elecBrake);
    }

    @Override

    public int updateElecBrakeDay(ElecBrake elecBrake) {
        return sqlSession.update("elecBrakeDayMapper.updateElecBrakeDay",elecBrake);
    }

    @Override
    @Cacheable(key = "#elecBrake.uid+#elecBrake.zid" ,unless = "#result==null")
    public ElecBrake selectElecBrakeDay(ElecBrake elecBrake) {
        return sqlSession.selectOne("elecBrakeDayMapper.selectElecBrakeDay",elecBrake);

    }

    @Override
    @Cacheable(key = "#result.hashCode()" ,unless = "#result==null")
    public List<ElecBrake> selectAll() {
        return sqlSession.selectList("elecBrakeDayMapper.selectAll");
    }
}
