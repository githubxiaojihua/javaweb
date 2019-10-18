package com.xiaojihua.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class MyFilterHt implements Filter
{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 解决请求和相应乱码
	 * @param req
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//解决响应乱码
		response.setCharacterEncoding("UTF-8");

		//解决请求乱码
		// 要增强的方法:request.getParameter
		// 被代理的对象: request
		final HttpServletRequest request=(HttpServletRequest)req;

		// 动态的生成代理对象
		HttpServletRequest hsr=(HttpServletRequest)Proxy.newProxyInstance(
				request.getClass().getClassLoader(), 
				request.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						
						// 1 判断是否是需要增强的方法 getParameter
						if("getParameter".equals(method.getName()))
						{
							// 知道getParameter使用的是哪个提交方式 
							String m = request.getMethod();
							//String name = request.getParameter("method");
							// 判断是get还是post
							if("get".equalsIgnoreCase(m))
							{
								// 以前方法调用后的乱码
								String s =(String)method.invoke(request, args);
								//防止要获取的参数不在request中
								if(s != null){
									// 增强--解决乱码
									s=new String(s.getBytes("iso8859-1"),"utf-8");
								}

								return s;
							}

							if("post".equalsIgnoreCase(m))
							{
								request.setCharacterEncoding("utf-8");

							}
						}
						
						// 如果是别的方法
						return method.invoke(request, args);
					}
				});
		
		// 放行
		chain.doFilter(hsr, response);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
