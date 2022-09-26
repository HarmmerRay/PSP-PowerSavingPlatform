package org.example.mapper;

import org.example.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//增删改查

public class BaseDao {

    public boolean insert_update_del(String sql,Object val[]) throws ClassNotFoundException, SQLException {
        boolean flag=false;
        Connection con= new DBUtil().getConnection();
        PreparedStatement pstmt=con.prepareStatement(sql);
        if(val!=null) {
            for(int i=0;i<val.length;i++) {
                pstmt.setObject(i+1, val[i]);
            }
        }
        if(pstmt.executeUpdate()>0) {
            flag=true;
        }
        return flag;
    }

    public ResultSet query(String sql,Object val[]) throws ClassNotFoundException, SQLException {
        boolean flag=false;
        Connection con=new DBUtil().getConnection();
        PreparedStatement pstmt=con.prepareStatement(sql);
        if(val!=null) {
            for(int i=0;i<val.length;i++) {
                pstmt.setObject(i+1, val[i]);
            }
        }
        ResultSet rs=pstmt.executeQuery();
        return rs;
    }


}

