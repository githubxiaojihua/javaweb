<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%> <!-- 引入struts2标签  要是ognl就必须嵌套到struts2标签中一起使用 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!-- 通过ognl表达式条用String的长度方法  -->
hello的长度是: <s:property value="'hello'.length()" /><br/>
<!-- 可以调用类的静态属性 条件:@全限定名@属性 -->
π的长度:<s:property value="@java.lang.Math@PI" /><br/>
<!-- 可以调用类的静态方法
条件: @全限定名@方法
     需要开启静态方法的使用 (默认struts2在ognl中对静态方法的执行是关闭的)
     struts.ognl.allowStaticMethodAccess-------true
-->
随机数是: <s:property value="@java.lang.Math@random()" />

<!-- 主要: <s:property value="获取值栈的数据" /> 待定.... -->
</body>
</html>