<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- 导入好相关的jar包，设置要下面的语句就可以使用jstl了 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

    <%
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        request.setAttribute("list",list);

        Map<String,String> map = new HashMap();
        map.put("xx","XX");
        map.put("yy","YY");
        map.put("zz","ZZ");
        request.setAttribute("map",map);
    %>

    <c:forEach items="${list}" var="str" varStatus="vs">
        第${vs.count}个元素为：${str}，索引是：${vs.index}
    </c:forEach>

    <c:forEach items="${map}" var="val">
        key:${val.key},value:${val.value}
    </c:forEach>
</body>
</html>