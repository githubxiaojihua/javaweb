
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>这是错误页面</h4>
<!-- 只有设置了isErrorPage等于true后才能使用exception对象 -->
<%=exception.getMessage()%>

</body>
</html>
