package org.example.mapper.zy;

import org.example.entity.ElecBrake;

import java.util.List;

public interface ElecBrakeWeekMapper {
    public int insertElecBrakeWeek(ElecBrake elecBrakeWeek);
    public int deleteElecBrakeWeek(ElecBrake elecBrakeWeek);
    public int updateElecBrakeWeek(ElecBrake elecBrakeWeek);
    public ElecBrake selectElecBrakeWeek(ElecBrake elecBrakeWeek);
    public List<ElecBrake> selectAll();
}
