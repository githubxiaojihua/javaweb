package com.xiaojihua.servlet.C18Redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求转发的对象，接收从上个servlet转发过来的请求
 */
public class C02BzrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从上一次请求中获取moneyx
		String moneyx=(String)request.getAttribute("moneyx");
		System.out.println("班主任：嘎哈来了！");
		System.out.println("我说：甲同学回家没钱了，借"+moneyx);
		System.out.println("班主任：给你500");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
