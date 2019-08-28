
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 下面是程序片段生成在jsp对应的servlet的service方法中 --%>
<%
    int i = 0;
    System.out.println(i);
    int x = 5;
    int y = 8;
    System.out.println(x+y);
%>
<%-- 输出表达式，生成在service方法中，相当与调用了out.println，语句后面不能有分号 --%>
<%=x+y %>

<%-- 声明成员，不会出现在service方法中，生命的是对应servlet的成员变量 --%>
<%! int t = 19; %>

</body>
</html>
