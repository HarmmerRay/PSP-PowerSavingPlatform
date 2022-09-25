package org.example.mapper.zy.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.entity.ElecBrake;
import org.example.mapper.zy.ElecBrakeMapper;

import java.util.List;
/**
 * @author zy
 */
public class ElecBrakeMapperImpl implements ElecBrakeMapper {
    public SqlSession sqlSession;
    public ElecBrakeMapperImpl(SqlSession sqlSession){this.sqlSession=sqlSession;}
    @Override
    public int insertElecBrake(ElecBrake elecBrake) {
        return sqlSession.insert("elecBrakeMapper.insertElecBrake",elecBrake);
    }

    @Override
    public int deleteElecBrake(ElecBrake elecBrake) {
        return sqlSession.delete("elecBrakeMapper.deleteElecBrake",elecBrake);
    }

    @Override
    public int updateElecBrake(ElecBrake elecBrake) {
        return sqlSession.update("elecBrakeMapper.updateElecBrake",elecBrake);
    }

    @Override
    public ElecBrake selectElecBrake(ElecBrake elecBrake) {
        return sqlSession.selectOne("elecBrakeMapper.selectElecBrake",elecBrake);

    }

    @Override
    public List<ElecBrake> selectAll() {
        return sqlSession.selectList("elecBrakeMapper.selectAll");
    }
}
