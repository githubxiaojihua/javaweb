<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<!--  
				好处: 能去servlet绕一圈取数据 然后到index.jsp展示数据
			-->
			<%--<% request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);%>--%>
			<!-- 自定义首页，到servlet中转一圈取数据再到真正的index页面展示 -->
			<%--<% response.sendRedirect(request.getContextPath() + "/product?method=findHotAndNew");%>--%>
			<%
				/**
				 * 这里对应的filter应该使用MyFilter而不应该使用EncodingFilger，
				 * 使用后者会导致请求转发过去后获取不到method参数，具体原因还需要
				 * 在探究
				 */

				request.getRequestDispatcher("/product?method=findHotAndNew").forward(request, response);
			%>
</body>
</html>