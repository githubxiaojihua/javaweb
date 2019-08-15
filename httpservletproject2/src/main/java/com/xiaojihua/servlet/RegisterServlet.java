package com.xiaojihua.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaojihua.bean.Customer;
import com.xiaojihua.service.RegisterService;
import org.apache.commons.beanutils.BeanUtils;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			//处理post方式乱码
			request.setCharacterEncoding("utf-8");
			//处理响应乱码
			response.setContentType("text/html;charset=utf-8");
			//获取前台录入的数据  map
			Map<String, String[]> map = request.getParameterMap();
			//创建bean
			Customer cus = new Customer();
			//把map中的数据拷贝到bean中
			BeanUtils.populate(cus, map);
			System.out.println(cus);
			//创建service
			RegisterService rs = new RegisterService();
			//调用service方法
			rs.saveCustomer(cus);
			//根据异常判断是否注册成功
			response.getWriter().print("注册成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().print("注册失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
