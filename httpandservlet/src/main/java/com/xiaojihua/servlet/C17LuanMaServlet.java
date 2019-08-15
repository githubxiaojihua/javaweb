package com.xiaojihua.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;

/**
 * 解决请求乱码的问题，post或者是get
 *
 */
public class C17LuanMaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
            下面这一段是从post方法中移过来的，也就是说从post转发过来的
            同样可以使用Post请求解决方式来解决乱码.
            但是如果直接提交GET请求用下面这一段还是乱码，应该用下下一段
         */
        request.setCharacterEncoding("utf-8");
        //获取username
        String username = request.getParameter("username");
        System.out.println(username);
        //获取hobby
        String[] hobbys = request.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbys));
        //获取所有
        Map<String, String[]> map = request.getParameterMap();
        for(String key:map.keySet()){
            System.out.println(key+":"+Arrays.toString(map.get(key)));
        }
        //===================================================================
        /*
            以下是通用方式的解决方式，适合POST和GET
         */
		/*//获取username
		String username = request.getParameter("username");
		System.out.println(new String(username.getBytes("iso-8859-1"),"utf-8"));
		//获取hobby
		String[] hobbys = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobbys));
		//获取所有
		Map<String, String[]> map = request.getParameterMap();
		for(String key:map.keySet()){
			System.out.println(key+":"+new String(Arrays.toString(map.get(key)).getBytes("iso-8859-1"),"utf-8"));
		}*/
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        //针对于post请求  乱码解决方式
//		request.setCharacterEncoding("utf-8");
//		//获取username
//		String username = request.getParameter("username");
//		System.out.println(username);
//		//获取hobby
//		String[] hobbys = request.getParameterValues("hobby");
//		System.out.println(Arrays.toString(hobbys));
//		//获取所有
//		Map<String, String[]> map = request.getParameterMap();
//		for(String key:map.keySet()){
//			System.out.println(key+":"+Arrays.toString(map.get(key)));
//		}
    }
}
