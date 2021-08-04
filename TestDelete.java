package com.tian.lesson02;

import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDelete {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet re = null;


        try {
            conn = JdbcUtils.getConnection(); //获取到一个连接，
            st = conn.createStatement();        //获得sql的执行对象
            String sql = "DELETE FROM users WHERE id=4";
            int i = st.executeUpdate(sql);
            if (i > 0) {
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, re);
        }
    }
}