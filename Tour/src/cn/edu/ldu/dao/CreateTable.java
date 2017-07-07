package cn.edu.ldu.dao;

import java.sql.SQLException;

/**
 * Created by jiajingong on 2017/7/6.
 */
public class CreateTable {
    public static void main(String[] args) {
        String sql = "create table tourinfo(" +
                        "id int not null auto_increment," +
                        "userName varchar(45)," +
                        "description varchar(255)," +
                        "musicName varchar(45)," +
                        "musicUrl varchar(255)," +
                        "photoName varchar(45)," +
                        "photoUrl varchar(255)," +
                        "date varchar(45)," +
                        "sign varchar(45)," +
                        "primary key(id))" +
                        "default charset=utf8";
        DBHelper db = new DBHelper(sql);
        try {
            int update = db.pst.executeUpdate();
            System.out.println(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
