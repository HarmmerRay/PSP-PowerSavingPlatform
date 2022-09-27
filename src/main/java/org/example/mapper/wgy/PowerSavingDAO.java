package org.example.mapper.wgy;

import org.example.entity.ElecBrake;

import java.util.List;

public interface PowerSavingDAO {
    public List<ElecBrake> findAll(ElecBrake whereWrap, boolean mode);
    public List<ElecBrake> findAll();
    public float TestPower();
}
