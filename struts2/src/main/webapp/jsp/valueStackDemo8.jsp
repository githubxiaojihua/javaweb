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

    <s:debug></s:debug>
    <!--
        后台Action(ActionDemo20)使用push(list)
        将list增加到了栈顶，这时想要使用原来的方式比如
        property value="userName"是无法拿到的
        因为在值栈中直接push的list没有proptyName
        因此只能通过这种方式来那
        [0]代表从第0个位置到最后的所有，top代表第一个
        下面就是代表获取值栈中的第一个元素（list),然后获取他的第一个
        元素user然后获取他的userName属性
     -->
    <s:property value="[0].top[0].userName"/>
    <!-- 同样也可以使用这种方式来访问有proptyname的属性 -->
    <s:property value="[1].top.userName"/>
    <!-- 与上面的作用一样 -->
    <s:property value="userName"/>
</body>
</html>