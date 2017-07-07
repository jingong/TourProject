package cn.edu.ldu.dao;

import cn.edu.ldu.bean.TourBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jiajingong on 2017/7/6.
 */
public class TourDao {



    //把数据插入到数据库
    public static boolean setTour(Map<String,String> map){
        String sql = "insert into tourinfo(userName,description,musicName,musicUrl,photoName,photoUrl,date,sign) " +
                "values(?,?,?,?,?,?,?,?)";
        DBHelper db = new DBHelper(sql);
        try {
            db.pst.setString(1,map.get("userName"));
            db.pst.setString(2,map.get("description"));
            db.pst.setString(3,map.get("musicName"));
            db.pst.setString(4,map.get("musicUrl"));
            db.pst.setString(5,map.get("photoName"));
            db.pst.setString(6,map.get("photoUrl"));
            db.pst.setString(7,map.get("date"));
            db.pst.setString(8,map.get("sign"));
            int update = db.pst.executeUpdate();
            if (update > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static List<TourBean> getDiary(){
        String sql = "select * from tourinfo order by id desc";
        DBHelper db = new DBHelper(sql);
        List<TourBean> list = null;
        try {
            ResultSet query = db.pst.executeQuery();
            list = new ArrayList<>();
            while (query.next()){
                TourBean bean = new TourBean();
                bean.setDate(query.getString("date"));
                bean.setDescription(query.getString("description"));
                bean.setMusicUrl(query.getString("musicUrl"));
                bean.setMusicName(query.getString("musicName"));
                bean.setPhotoName(query.getString("photoName"));
                bean.setPhotoUrl(query.getString("photoUrl"));
                bean.setSign(query.getString("sign"));
                bean.setUserName(query.getString("userName"));
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close();
        }
        return list;
    }
    public static boolean deleteTour(String sign){
        String sql = "delete from tourinfo where sign=?";
        DBHelper db = new DBHelper(sql);
        try {
            db.pst.setString(1,sign);
            int update = db.pst.executeUpdate();
            if (update > 0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
