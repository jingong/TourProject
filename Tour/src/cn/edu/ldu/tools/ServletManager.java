package cn.edu.ldu.tools;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by jiajingong on 2017/7/6.
 */
public class ServletManager {
    public Map<String,String> upload(HttpServletRequest request,String path){
        Map<String,String> map = new HashMap<>();
        //判断是否含有文件  根据表头entype进行判断
        boolean isContent = ServletFileUpload.isMultipartContent(request);
        if (!isContent){
            //验证，如果没有文件直接返回
            return null;
        }
        File file = new File(path);
        if(!file.exists() && !file.isDirectory()){
            file.mkdir();
        }
        //创建一个上传工具类
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        //给上传的文件路径进行编码
        upload.setHeaderEncoding("utf-8");
        try {
            //通过upload解析请求码
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                //判断当前文件是否为普通文本表单
                if (fileItem.isFormField()){
                    //getFieldName():获取的就是input的name
                    String name = fileItem.getFieldName();
                    //获取文本表单的内容，utf-8解决乱码
                    String value = fileItem.getString("utf-8");
                    map.put(name,value);
                }else {
                    //文件表单
                    String filename = fileItem.getName().replace(" ","");
                    if (filename == null || filename.equals("")){
                        //结束当前循环，进行下一次
                        continue;
                    }
                    System.out.println("1.filename：" + filename);
                    //截取文件名 +1：不包含“/”
                    filename = filename.substring(filename.lastIndexOf("/") + 1);
                    //图片正则
                    Pattern pattern = Pattern.compile(".+(jpg|png|gif|JPG|PNG|GIF|jpeg|JPEG)");
                    Matcher m1 = pattern.matcher(filename);
                    //如果匹配成功
                    if (m1.matches()){
                        map.put("photoName",filename);
                        //http://127.0.0.1:8080/Tour/upload/
                        map.put("photoUrl",Config.pathUrl + filename);
                    }
                    //音乐正则
                    Pattern pattern1 = Pattern.compile(".+(mp3|MP3|WAV|wav)");
                    Matcher m2 = pattern1.matcher(filename);
                    if (m2.matches()){
                        map.put("musicName",filename);
                        map.put("musicUrl",Config.pathUrl + filename);
                    }
                    //获取输入流，读取文件
                    InputStream is = fileItem.getInputStream();
                    //创建一个文件输出流，写入文件
                    FileOutputStream fos = new FileOutputStream(path + "/" + filename);
                    //每次读取1024个字节
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len=is.read(buffer)) > 0){
                        //写入文件
                        fos.write(buffer,0,len);
                    }
                    //关闭流
                    fos.close();
                    is.close();
                }

            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    public static boolean download(String musicName){
        //音乐路径的拼接地址
        String path = Config.pathUrl + musicName;
        try {
            //获取链接
            URL url = new URL(path);
            //打开连接
            URLConnection connection = url.openConnection();
            //设置超时
            connection.setConnectTimeout(5 * 1000);
            connection.connect();
            File file = new File(Config.DOWNLOADPATH);
            if (!file.exists() && !file.isDirectory()){
                file.mkdir();
            }
            InputStream is = connection.getInputStream();
            FileOutputStream fos = new FileOutputStream(Config.DOWNLOADPATH + "/" + musicName);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = is.read(buffer)) > 0){
                fos.write(buffer,0,len);
            }
            fos.close();
            is.close();
            return true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
