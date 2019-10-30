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
    <!-- #的作用：在页面中获取context区域的值；遍历手工制造的list和map -->
    <!-- list -->
    <s:iterator value="{'aaa','bbb','ccc'}" var="ll">
        <s:property value="#ll"/>
    </s:iterator>
    <hr/>
    <!-- map 需要使用#定义-->
    <s:iterator value="#{'aaa':'111','bbb':'222','ccc':'333'}" var="mm">
        <!-- 是map的映射键值关系 -->
        <s:property value="#mm.key"/>---><s:property value="#mm.value"/>
    </s:iterator>

    <!-- struts2设计页面样式 (了解) -->
    <hr/>
    <input type="radio" name="sex" value="01">男
    <input type="radio" name="sex" value="02">女
    <hr/>
    <!-- 只用普通list是无法做到 radio的value和name显示的不一样 -->
    <s:radio list="{'男','女'}" name="sex"></s:radio>
    <hr/>
    <!-- 需要使用map -->
    <s:radio list="#{'01':'男','02':'女'}" name="sex"></s:radio>
</body>
</html>