<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.xiaojihua.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <!-- el内置对象的使用 -->
    <!-- param：保存了所有请求参数的Map对象，但是如果请求参数中有多个key值相同的参数那么只会保留第一个 -->
    ${param.username}
    <hr/>
    <!-- param：以数组的形式保存了所有请求参数的Map对象，解决了多个参数名称相同只保留一个的问题-->
    ${paramValues}
    <hr/>
    <!-- 获取paramValues中某个请求参数---单值 -->
    ${paramValues.username[0]}
    <hr/>
    <!-- 获取paramValues中某个请求参数---多值 -->
    ${paramValues.hobby[1]}
    <hr/>
    <!-- 获取请求头map中某个请求参数---有特殊符号的值 -->
    ${header["user-agent"]}
    <hr/>
    <!-- 获取请求头map中的所有值，每个值都用数组来表示，可以解决多个同名值 -->
    ${headerValues}
    <hr/>
    <!-- 获取请求头map中指定元素的值 -->
    ${headerValues["user-agent"][0]}
    <hr/>
    <!-- 获取web.xml中配置的全局参数 -->
    ${initParam.db}
    <hr/>
    <!-- 获取请求头map -->
    ${header}
    <hr/>
    <!-- 获取cookie中存储的session值， -->
    ${cookie.JSESSIONID.value}
    <hr/>
    <!-- 获取pageContext对象中的值 -->
    ${pageContext.request.contextPath}
</body>
</html>