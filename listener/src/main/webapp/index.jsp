<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2>监听对象属性的变化</h2>
<a href="${pageContext.request.contextPath}/attr/add.jsp">属性添加</a><br>
<a href="${pageContext.request.contextPath}/attr/rem.jsp">属性移除</a><br>
<a href="${pageContext.request.contextPath}/attr/rep.jsp">属性替换</a><br>

<h2>绑定和解绑</h2>
<a href="${pageContext.request.contextPath}/bd/bd.jsp">绑定</a><br>
<a href="${pageContext.request.contextPath}/bd/undb.jsp">解绑</a><br>
<h2>活化和钝化</h2>
<a href="${pageContext.request.contextPath}/act/add.jsp">向session中放入数据</a><br>
<a href="${pageContext.request.contextPath}/act/test.jsp">测试活化</a><br>
</body>
</html>