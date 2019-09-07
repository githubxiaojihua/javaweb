
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- 导入好相关的jar包，设置要下面的语句就可以使用jstl了 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

    <!-- jsp普通循环 -->
    <%
        for(int i=0; i<11; i++){
    %>
        <%=i%>
    <%
        }
    %>

    <c:forEach begin="1" end="10" step="1" var="i">
        ${i}
    </c:forEach>

    <c:forEach begin="1" end="20" step="2" var="j">
        ${j}
    </c:forEach>


</body>
</html>