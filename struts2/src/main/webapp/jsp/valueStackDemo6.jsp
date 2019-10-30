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
    <!-- %的作用就是将表达式强制转换成ognl表达式 -->
    <%request.setAttribute("msg", "abcd/1234"); %>
    <s:debug></s:debug>
    <!-- 通过普通的标签从context中的request中获取设置的值 -->
    <input type="text" name="username" value="<s:property value="#request.msg"/>" />

    <!-- 通过struts的textField标签获取值栈中的值的时候需要使用%告诉标签这是ognl表达式，否则他不认识 -->
    <s:textfield value="%{#request.msg}"></s:textfield>
</body>
</html>