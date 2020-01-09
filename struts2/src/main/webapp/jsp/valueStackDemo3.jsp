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
<!-- 通过ognl获取值栈的数据 当前action的username属性(掌握)
			 类似调用这个方法:vs.findValue(Property Name);

		 -->
    <!-- 获取push的对象 -->
    <s:property value="userName"/>
    <s:property value="age"/>
    <!-- 获取set的map值 -->
    <s:property value="name"/>
    <s:property value="agee"/>
</body>
</html>