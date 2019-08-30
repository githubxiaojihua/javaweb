<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>el</h2>
<a href="/jspeljstl/demo1.jsp">获取简单数据</a><br>
<a href="/jspeljstl/demo2.jsp">获取复杂数据</a><br>
<a href="/day14/demo3.jsp">执行运算</a><br>
<a href="/day14/demo4.jsp?username=tom&passwodr=123&hobby=smoking&hobby=tHead">获取前台的请求参数</a>
<h2>jstl</h2>
<a href="${pageContext.request.contextPath}/demo5.jsp">jstl if基本应用</a><br>
<a href="${pageContext.request.contextPath}/demo6.jsp">jstl foreach基本应用</a><br>
<a href="${pageContext.request.contextPath}/demo7.jsp">jstl foreach高级应用</a>
</body>
</html>