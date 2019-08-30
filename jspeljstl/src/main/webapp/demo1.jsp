<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- 这里有一个问题就是必须设置isELIgnored="false" 原因是servlet2.3及以前是默认为true的为了向后兼容
，这个跟servlet版本相关，看servlet版本可以在servlet.jar的MANIFEST.MF文件下的
Specification-Version属性

还有一个解决方法就是修改web.xml，出现这个问题是因为通过maven建立的web项目的web.xml抬头是这样的：
<!DOCTYPE web-app PUBLIC
"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
"http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app>
<display-name>Archetype Created Web Application</display-name>
</web-app>


而且正常应该是：
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xmlns="http://java.sun.com/xml/ns/javaee"
xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" id="WebApp_ID" version="2.5">
<display-name>Archetype Created Web Application</display-name>


</web-app>

注意上面的web-app版本是2.5
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    session.setAttribute("skey", "svalue");
    application.setAttribute("akey", "avalue");

    session.setAttribute("rrr", "svalue");
    application.setAttribute("rrr", "avalue");
%>

<!-- 通过el表达式获取简单属性 -->
<!-- 使用el内置对象从指定域中获取属性 -->
${sessionScope.skey}
<hr/>
${applicationScope.akey}
<hr/>
<!-- 自动从pageScope,requestScope,sessionScope,applicationScope,等与对象中
 从小到达进行检索相关属性-->
${skey}
<hr/>
${akey}
<hr/>
${rrr}
</body>
</html>