package org.example;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DBUtil {

    public final static String perfix="`";
    public final static String sufix="`";
    public static SimpleDateFormat simpleDateTimeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    public static Timestamp geCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    public static String geCurrentFormatDateTime() {
        return simpleDateTimeFormat.format(geCurrentTimestamp());
    }
    public static String geCurrentFormatDate() {
        return simpleDateFormat.format(geCurrentTimestamp());
    }
    public static void saySql(String method,String sql) {
        System.out.println(method+"\r\n   --->"+sql);
    }
    public static Connection connection;
    public static Connection getConnection() {
        if (connection==null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8","root","root");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void close(ResultSet resultSet,Statement statement) {
        try {
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void close(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement preparedStatement, ResultSet resultSet) {
        // TODO Auto-generated method stub
        try {
            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
