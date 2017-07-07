package cn.edu.ldu.dao;

import java.sql.*;


/**
 * Created by jiajingong on 2017/7/6.
 */
public class DBHelper {
    public static final String url = "jdbc:mysql://127.0.0.1:3306/db_tour?useUnicode=true&characterEncoding=utf-8";

    public static final String user = "root";

    public static final String password = "root";
    //包的支持
    public static final String name = "com.mysql.jdbc.Driver";

    private Connection connection;

    public PreparedStatement pst;



    public DBHelper() {
    }
    public DBHelper(String sql) {
        //
        try {
            //实用工具类加载驱动
            Class.forName(name);
            System.out.println("驱动加载成功");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("获取链接成功");
            pst = connection.prepareStatement(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取链接失败");
        }

    }
    public void close(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection = null;
                pst = null;
            }
        }
    }
}
