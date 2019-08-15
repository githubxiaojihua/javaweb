package com.xiaojihua.servlet.C18Redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求转发，是request发起的，
 * 与response的重定向有根本性的区别，具体看课程脑图
 */
public class C01MeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String money = request.getParameter("money");
		
		System.out.println("我说：咋了");
		System.out.println("甲说：没钱，借"+money);
		System.out.println("我说：没有");
		System.out.println("我说：我去帮你借！");

		//把money放入request域中
		//request与对象的操作，其它域对象还有servletContext,session
		//域对象都有xxxAttibute方法，set,get,remove
		//request域对象中的值只在同一次请求中有效。
		request.setAttribute("moneyx", money);
		//请求转发到bzr，注意地址是内部地址/bzr是直接写servlet的地址
		//这个跟重定向还不一样重定向需要写上项目名称比如：/httpservlet/bzr
		request.getRequestDispatcher("/bzr").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
