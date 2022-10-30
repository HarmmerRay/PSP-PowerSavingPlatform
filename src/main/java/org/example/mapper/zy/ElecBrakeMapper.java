package org.example.mapper.zy;

import org.example.entity.ElecBrake;

import java.util.List;

public interface ElecBrakeMapper {
    public int insertElecBrake(ElecBrake elecBrake);
    public int deleteElecBrake(ElecBrake elecBrake);
    public int updateElecBrake(ElecBrake elecBrake);
    public ElecBrake selectElecBrake(ElecBrake elecBrake);
    public List<ElecBrake> selectAll();

}
