package com.tian.lesson01;

import java.sql.*;

public class JdbcFirstDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");     //1.加载驱动8.0x版本的数据库驱动文件(5.0没有cj，8.0需要加上）

        // 2.用户信息和url
        //useUnicode=true&characterEncoding=utf8&useSSL=false
        //支持中文编码&设定字符集为utf-8&关闭连接（8.0不需要建立ssl连接的，你需要显示关闭）
        String url ="jdbc:mysql://localhost:3306/game?useUnicode=true&characterEncoding=utf8&useSSL=flase";
        String username="root";
        String password="555555";

        //3.连接成功，数据库对象(connection代表数据库)
        Connection connection = DriverManager.getConnection(url, username, password);
        //xingxingfatianzijianqiaoxiatianzi
        //4.执行sql的对象
        Statement statement = connection.createStatement();
        //5.执行sql的对象去执行sql，可能存在结果，查看返回结果
        String sql = "SELECT * FROM pvz";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id=" + resultSet.getObject("id"));
            System.out.println("name=" + resultSet.getObject("NAME"));
            System.out.println("race=" + resultSet.getObject("race"));
            System.out.println("attack=" + resultSet.getObject("attack"));
            System.out.println("defense=" + resultSet.getObject("defense"));
            System.out.println("life=" + resultSet.getObject("life"));
            System.out.println("=========================");
        }
        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}