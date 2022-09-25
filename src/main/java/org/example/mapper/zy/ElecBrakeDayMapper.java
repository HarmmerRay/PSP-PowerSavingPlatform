package org.example.mapper.zy;

import org.example.entity.ElecBrake;

import java.util.List;

public interface ElecBrakeDayMapper {
    public int insertElecBrakeDay(ElecBrake elecBrakeDay);
    public int deleteElecBrakeDay(ElecBrake elecBrakeDay);
    public int updateElecBrakeDay(ElecBrake elecBrakeDay);
    public ElecBrake selectElecBrakeDay(ElecBrake elecBrakeDay);
    public List<ElecBrake> selectAll();
}
