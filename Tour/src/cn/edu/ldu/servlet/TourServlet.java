package cn.edu.ldu.servlet;

import cn.edu.ldu.bean.TourBean;
import cn.edu.ldu.dao.TourDao;
import cn.edu.ldu.tools.Config;
import cn.edu.ldu.tools.ServletManager;
import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by jiajingong on 2017/7/6.
 */
public class TourServlet extends HttpServlet {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PrintWriter writer;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.request = request;
        this.response = response;
        this.request.setCharacterEncoding("UTF-8");
        this.response.setCharacterEncoding("UTF-8");
        //给相应内容编码
        this.response.setContentType("text/html;charset=utf-8");
        //跨域处理
        this.response.setHeader("Access-Control-Allow-Origin","*");
        //获取输出流
        writer = this.response.getWriter();
        String method = this.request.getParameter("method");
        switch (method){
            case "sendData"://提交表单到服务器
                //获取到的音乐文件以及图片文件写入到服务器，存储到数据库上的文件路径
                //获取存放文件的绝对路径
                String path = getServletContext().getRealPath("/upload");
                System.out.println(path);
                ServletManager manager = new ServletManager();
                Map<String, String> map = manager.upload(request, path);
                boolean success = TourDao.setTour(map);
                if (success){
                    //若存储成功，使用json把map集合转换为json字符串
                    String json = new Gson().toJson(map);
                    writer.print(json);
                }

                break;
            case "getData":
                List<TourBean> list = TourDao.getDiary();
                String json = new Gson().toJson(list);
                //System.out.println(json);
                writer.print(json);
                break;
            case "download":
                String musicName = this.request.getParameter("music");
                boolean s = ServletManager.download(musicName);
                if (s){
                    writer.print(Config.DOWNLOADPATH + "/" + musicName);
                }else{
                    writer.print("不好意思，下载失败！");
                }
                break;
            case "deleteTour":
                String sign = this.request.getParameter("sign");
                System.out.println("sign:" + sign);
                boolean b = TourDao.deleteTour(sign);
                if (b){
                    writer.print(1);
                }
                break;
        }
        writer.flush();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
