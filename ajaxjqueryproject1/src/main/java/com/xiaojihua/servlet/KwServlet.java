package com.xiaojihua.servlet;

import com.google.gson.Gson;
import com.xiaojihua.service.KwService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class KwServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //解决请求乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应乱码
        response.setContentType("text/html;charset=utf-8");

        String kw = request.getParameter("kwName");
        KwService service = new KwService();
        try {
            List<Object> list = service.findList(kw);
            Gson gson = new Gson();
            String jsonStr = gson.toJson(list);
            //将json写入到浏览器
            response.getWriter().println(jsonStr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        doGet(request,response);
    }
}
