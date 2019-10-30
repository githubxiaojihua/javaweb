<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!-- 通过struts2的内置标签 将整个值栈的内部结构图在页面显示 -->
    <s:debug></s:debug>

<!-- 获取xcontext区域的数据  -->
    <s:property value="#session.msg1"/><br/>
    <s:property value="#application.msg2"/><br/>
    <s:property value="#attr.msg1"/>----<s:property value="#attr.msg2"/><br/>
    <s:property value="#msg"/><br/>

    <!-- 值栈的数据也可以用el获取到 -->
    ${sessionScope.msg1 }<br/>
    ${applicationScope.msg2 }<br/>
    ${requestScope.msg }--->${msg}<br/>
</body>
</html>