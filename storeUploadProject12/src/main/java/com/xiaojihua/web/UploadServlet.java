package com.xiaojihua.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        /**
         * 当表单的enctype类型为：application/x-www-form-urlencoded（默认）时
         * 获取表单数据的方式
         */
        /*request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String userName = request.getParameter("username");
        String upload = request.getParameter("upload");
        System.out.println(userName + "---" + upload);*/
        try {
            //1、创建磁盘文件工厂
            DiskFileItemFactory disk = new DiskFileItemFactory();
            //2、生成上传的核心对象
            ServletFileUpload upload = new ServletFileUpload(disk);
            //3、解析请求体（request)
            List<FileItem> list = upload.parseRequest(request);
            //4、遍历所有表单项
            for(FileItem fi : list){
                //判断当前表单项是否为普通项目 true:普通项目 false:上传项目
                if(fi.isFormField()){
                    //获取普通表单项名称
                    String userName = fi.getFieldName();
                    //获取普通表单项的值
                    //String value = fi.getString();
                    //如果包含中文则应该指定编码方式
                    String value = fi.getString("utf-8");
                    System.out.println(userName + "---" + value);
                }else{
                    //如果是上传项目则需要获取IO流进行读写
                    //这里不能盲目的写getBytes("iso8859-1")有可能是不对的，如果使用默认的getBytes()则
                    //内部 走的是系统默认编码也就是file.
                    //上傳的文件名中包含中文的话需要进行转码（参考了上面if语句中的getString("utf-8")的源码
                    String fileName = new String(fi.getName().getBytes(),"utf-8");
                    System.out.println(fileName);
                    //获取文件内容
                    InputStream inputStream = fi.getInputStream();
                    //构建文件路径，写入服务器，获取upload文件在服务器中的真实路径，
                    //upload文件指的是在webApp下面的，但是到了服务器上就不知道具体位置了，需要通过编码
                    //的方式来获取
                    String path = getServletContext().getRealPath("upload");
                    System.out.println("服务器地址：" + path);
                    FileOutputStream os = new FileOutputStream(path + "/" + fileName);
                    IOUtils.copy(inputStream,os);
                    //关闭流
                    os.close();
                    inputStream.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4、遍历所有表单项（也就是浏览器提交的那一块块的部分或者叫payload)

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        doGet(request,response);
    }
}
