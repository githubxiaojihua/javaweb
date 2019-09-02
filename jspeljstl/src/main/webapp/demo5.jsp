
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
    <!-- 通过普通jsp来判断 -->
   <%-- <%
        int i = 8;
        if(i >4){
    %>
        <h3>i是大于4的</h3>
    <%
        }else{
    %>
        <h3>i是小于等于4的</h3>
    <%
        }
    %>--%>

    <%
        int i = 3;
        request.setAttribute("i",i);
        //pageContext.setAttribute("flag","1111");
    %>

    <c:if test="${i>4}">
        <h3>i是大于4的</h3>
    </c:if>

    <!-- var="flag" scope="request" 作用是将前面test表达式中的结果保存到一个变量中
         并指定变量存储的位置，这里存储到request中，如果打开上面的
            pageContext.setAttribute("flag","1111");
         那么输出会是1111
    -->
    <c:if test="${i<=4}" var="flag" scope="request">
        i小于4
        ${flag}
    </c:if>


</body>
</html>