package com.tian.lesson02;

import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection(); //获取到一个连接，
            st = conn.createStatement();        //获得sql的执行对象

            //sql
            String sql = "SELECT * from users WHERE `id`=5";

            rs = st.executeQuery(sql);//查询完毕会返回一个结果集
            while (rs.next()) {
                System.out.println(rs.getString("NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }
} //