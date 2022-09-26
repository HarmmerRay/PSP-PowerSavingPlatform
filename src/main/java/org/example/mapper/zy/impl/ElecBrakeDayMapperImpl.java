package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.ElecBrake;
import org.example.mapper.zy.ElecBrakeDayMapper;

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
    public int deleteElecBrakeDay(ElecBrake elecBrake) {
        return sqlSession.delete("elecBrakeDayMapper.deleteElecBrakeDay",elecBrake);
    }

    @Override
    public int updateElecBrakeDay(ElecBrake elecBrake) {
        return sqlSession.update("elecBrakeDayMapper.updateElecBrakeDay",elecBrake);
    }

    @Override
    public ElecBrake selectElecBrakeDay(ElecBrake elecBrake) {
        return sqlSession.selectOne("elecBrakeDayMapper.selectElecBrakeDay",elecBrake);

    }

    @Override
    public List<ElecBrake> selectAll() {
        return sqlSession.selectList("elecBrakeDayMapper.selectAll");
    }
}
