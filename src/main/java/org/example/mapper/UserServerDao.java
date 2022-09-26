package org.example.mapper;


import org.example.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServerDao extends BaseDao {
    //增
    public boolean regeditUser(User user) throws ClassNotFoundException, SQLException {
        String sql = "insert into user values (null,?,?)";
        Object[] val = {user.getUname(), user.getUpassword()};
        return insert_update_del(sql, val);
    }
    //查所有
    public List<User> quaryAll() throws ClassNotFoundException, SQLException {
        List<User> list = new ArrayList<User>();
        String sql = "select * from user";
        Object[] val = {};
        ResultSet rs = query(sql, val);
        while (rs.next()) {
            User user = new User();
            user.setUid(rs.getString("uid"));
            user.setUname(rs.getString("uname"));
            user.setUpassword(rs.getString("upassword"));
            list.add(user);
        }
        return list;
    }
    //通过🆔id查
    public User queryById(int uid) throws ClassNotFoundException, SQLException {
        User user = new User();
        String sql = "select * from user where uid=?";
        Object[] val = {uid};
        ResultSet rs = query(sql, val);
        while (rs.next()) {
            user.setUid(rs.getString("uid"));
            user.setUname(rs.getString("uname"));
            user.setUpassword(rs.getString("upassword"));
        }
        return user;
    }
    //改
    public boolean updateUser(User user) throws ClassNotFoundException, SQLException {
        String sql = "update user set uname=?,upassword=? where uid=?";
        Object[] val = {user.getUname(), user.getUpassword(), user.getUid()};
        if (insert_update_del(sql, val)) {
            return true;
        } else {
            return false;
        }

    }
    //删
    public boolean deleteUser(int uid) throws ClassNotFoundException, SQLException {
        String sql = "delete from user where uid=?;";
        Object[] val = {uid};
        return insert_update_del(sql, val);
    }

}
