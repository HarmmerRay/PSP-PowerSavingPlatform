package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.ElecBrake;
import org.example.mapper.zy.ElecBrakeWeekMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
/**
 * @author zy
 */
public class ElecBrakeWeekMapperImpl implements ElecBrakeWeekMapper {
    public SqlSession sqlSession;
    public ElecBrakeWeekMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}
    @Override
    public int insertElecBrakeWeek(ElecBrake elecBrake) {
        return sqlSession.insert("elecBrakeWeekMapper.insertElecBrakeWeek",elecBrake);
    }

    @Override
    @CacheEvict(key="#elecBrake.uid+#elecBrake.zid")
    public int deleteElecBrakeWeek(ElecBrake elecBrake) {
        return sqlSession.delete("elecBrakeWeekMapper.deleteElecBrakeWeek",elecBrake);
    }

    @Override

    public int updateElecBrakeWeek(ElecBrake elecBrake) {
        return sqlSession.update("elecBrakeWeekMapper.updateElecBrakeWeek",elecBrake);
    }

    @Override
    @Cacheable(key = "#elecBrake.uid+#elecBrake.zid" ,unless = "#result==null")
    public ElecBrake selectElecBrakeWeek(ElecBrake elecBrake) {
        return sqlSession.selectOne("elecBrakeWeekMapper.selectElecBrakeWeek",elecBrake);

    }

    @Override
    @Cacheable(key = "#result.hashCode()" ,unless = "#result==null")
    public List<ElecBrake> selectAll() {
        return sqlSession.selectList("elecBrakeWeekMapper.selectAll");
    }
}
