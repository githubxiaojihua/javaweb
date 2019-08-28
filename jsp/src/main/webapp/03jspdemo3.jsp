
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("rkey","textvalue");
%>
<!-- jsp动态标签，实现请求转发 -->
<jsp:forward page="04jspdemo4.jsp"></jsp:forward>

</body>
</html>
