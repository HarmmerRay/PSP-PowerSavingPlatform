package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.ElecBrake;
import org.example.mapper.zy.ElecBrakeWeekMapper;

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
    public int deleteElecBrakeWeek(ElecBrake elecBrake) {
        return sqlSession.delete("elecBrakeWeekMapper.deleteElecBrakeWeek",elecBrake);
    }

    @Override
    public int updateElecBrakeWeek(ElecBrake elecBrake) {
        return sqlSession.update("elecBrakeWeekMapper.updateElecBrakeWeek",elecBrake);
    }

    @Override
    public ElecBrake selectElecBrakeWeek(ElecBrake elecBrake) {
        return sqlSession.selectOne("elecBrakeWeekMapper.selectElecBrakeWeek",elecBrake);

    }

    @Override
    public List<ElecBrake> selectAll() {
        return sqlSession.selectList("elecBrakeWeekMapper.selectAll");
    }
}
