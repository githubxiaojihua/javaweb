<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!-- 注意page指令的相关属性 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp"
 pageEncoding="UTF-8" buffer="8kb" autoFlush="true" session="true" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List list = new ArrayList();
    int i = 1/0;//由于配置了page errorPage指令因此会跳转到错误页面
%>

</body>
</html>
