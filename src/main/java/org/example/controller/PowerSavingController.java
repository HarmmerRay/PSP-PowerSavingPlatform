package org.example.controller;

import org.example.DBUtil;
import org.example.entity.ElecBrake;
import org.example.mapper.wgy.PowerSavingDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PowerSavingController implements PowerSavingDAO {
    public Connection connection = DBUtil.getConnection();
    private ResultSet rs = null;
    private PreparedStatement preparedStatement = null;
    private String table = "elecBrake";
    public static String other = "";

    public List<ElecBrake> getList(ResultSet rs) throws SQLException {
        ArrayList<ElecBrake> list = new ArrayList<ElecBrake>();
        while (rs.next()) {
            ElecBrake elecBrake = new ElecBrake();
            elecBrake.setZid(rs.getInt("zid"));
            elecBrake.setUid(rs.getString("uid"));
            elecBrake.setStatus(rs.getInt("status"));
            elecBrake.setU(rs.getFloat("u"));
            elecBrake.setI(rs.getFloat("i"));
            elecBrake.setP(rs.getFloat("p"));
            elecBrake.setW(rs.getFloat("w"));
            elecBrake.setT(rs.getFloat("t"));
            elecBrake.setCreateTime(rs.getDate("createTime"));
            elecBrake.setUpdateTime(rs.getDate("updateTime"));
            list.add(elecBrake);
        }
        return list;
    }

    //从数据库取数据
    @Override
    public List<ElecBrake> findAll(ElecBrake whereWrap, boolean mode) {
        // TODO Auto-generated method stub
        try {
            String sql = "select * from " + DBUtil.perfix + table + DBUtil.sufix;
            sql = preparedSql(sql, whereWrap, mode, null);
            DBUtil.saySql("org.example.controller.PowerSavingController#findAll(" + whereWrap + "," + mode + ")", sql.toString());
            rs = preparedStatement.executeQuery();
            return getList(rs);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(preparedStatement, rs);
        }
    }

    public String preparedSql(String sql, ElecBrake whereWrap, boolean mode, String other) throws SQLException {
        if (other == null) {
            other = this.other;
        }
        if (whereWrap == null) {
            sql += " " + other;
            preparedStatement = connection.prepareStatement(sql);
            return sql;
        }
        String distance = "";
        if (!mode) {
            distance = "%";
        }
        StringBuffer whereSql = new StringBuffer(" where '1'='1'");
        if (whereWrap.getZid() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "zid" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "zid" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getUid() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "uid" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "uid" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getStatus() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "status" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "status" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getU() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "u" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "u" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getI() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "i" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "i" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getP() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "p" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "p" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getW() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "w" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "w" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getT() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "t" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "t" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getCreateTime() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "createTime" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "createTime" + DBUtil.sufix + " like ?");
            }
        }
        if (whereWrap.getUpdateTime() != null) {
            if (mode) {
                whereSql.append(" and " + DBUtil.perfix + "updateTime" + DBUtil.sufix + " = ?");
            } else {
                whereSql.append(" and " + DBUtil.perfix + "updateTime" + DBUtil.sufix + " like ?");
            }
        }
        int index = 0;
        sql = whereSql.insert(0, sql).toString();
        sql += " " + other;
        preparedStatement = connection.prepareStatement(sql);
        if (whereWrap.getZid() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getZid() + distance);
        }
        if (whereWrap.getUid() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getUid() + distance);
        }
        if (whereWrap.getStatus() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getStatus() + distance);
        }
        if (whereWrap.getU() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getU() + distance);
        }
        if (whereWrap.getI() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getI() + distance);
        }
        if (whereWrap.getP() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getP() + distance);
        }
        if (whereWrap.getW() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getW() + distance);
        }
        if (whereWrap.getT() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getT() + distance);
        }
        if (whereWrap.getCreateTime() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getCreateTime() + distance);
        }
        if (whereWrap.getUpdateTime() != null) {
            preparedStatement.setString(++index, distance + whereWrap.getUpdateTime() + distance);
        }

        System.out.println(preparedStatement);
        return sql;
    }

    @Override
    public List<ElecBrake> findAll() {
        return findAll(null, true);
    }

    @Override
    public float TestPower() {
        PowerSavingController powerSavingController = new PowerSavingController();
        List<ElecBrake> elecBrakeList = powerSavingController.findAll();

        float ps = 0;
        for (ElecBrake e : elecBrakeList) {
            float p = e.getI() * e.getU();
            ps += p;
        }
        float average_p =ps/elecBrakeList.size();
        return average_p;
    }

}
