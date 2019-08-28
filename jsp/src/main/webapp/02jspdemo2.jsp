
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("skey","svalue");
    //通过pageContext向session中写入同样的值。覆盖掉
    pageContext.setAttribute("skey","ssvalue",PageContext.SESSION_SCOPE);
    //通过pageContext向request中写入属性
    pageContext.setAttribute("rkey","rvalue",PageContext.REQUEST_SCOPE);

    request.setAttribute("test","tvalue");
    session.setAttribute("test","ttvalue");
    application.setAttribute("test","tttvalue");
%>
<%=session.getAttribute("skey")%>
<%=request.getAttribute("rkey")%>
<!-- findAttribute是从最小范围往最大范围找 -->
<%=pageContext.findAttribute("test")%>

</body>
</html>
