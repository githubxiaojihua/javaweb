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
    <%
        request.setAttribute("i",3);
        request.setAttribute("j",7);
        request.setAttribute("q","9");
        request.setAttribute("k","k");

        //创建一个空的list
        List<String> list = new ArrayList<String>();
        request.setAttribute("list",list);
        //创建一个空的数组
        String[] strs = null;
        request.setAttribute("strs",strs);

    %>
    i=3,j=7,q="9",k="k",list和strs=null
    <!-- 正常的数值计算 -->
    算数运算i+j:${i+j}
    <hr/>
    <!-- 将q转换为数字然后运算 -->
    算数运算i+q:${i+q}
    <hr/>
    <!-- 下面的这一句由于运算时不能将字符串“k”有效转换成数字因此会报错误 -->
    <%--算数运算i+k:${i+k}--%>
    <hr/>
    empty运算符判断list是否为空：${empty list}
    <hr/>
    empty运算符判断数组是否为空：${empty strs}
    <hr/>
    el表达式运算三元表达式：${1==1?"abc":"cba"}
</body>
</html>