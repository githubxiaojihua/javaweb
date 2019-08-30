<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.xiaojihua.bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <%
        //定义数组
        String[] strArr = new String[]{"aa","bb","cc"};
        request.setAttribute("strArr",strArr);
        //定义list
        List<String> strList = new ArrayList<String>();
        strList.add("AA");
        strList.add("BB");
        strList.add("CC");
        request.setAttribute("strList",strList);
        //定义Map
        Map<String,String> strMap = new HashMap<String,String>();
        strMap.put("xx","XX");
        strMap.put("yy","YY");
        strMap.put("zz","ZZ");
        request.setAttribute("strMap",strMap);
        //定义bean
        User user = new User();
        user.setUsername("张三");
        user.setPassword("11111");
        request.setAttribute("user",user);
        //设置带有特殊字符的key
        request.setAttribute("hello.world","hw");

    %>


    获取数组中的数据：
    老方式：<%=((String[])request.getAttribute("strArr"))[0]%><br/>
    el方式：${strArr[0]}
    <hr/>
    获取list中的数据：
    老方式：<%=((List<String>)request.getAttribute("strList")).get(0)%><br/>
    el方式：${strList[0]}
    <hr/>
    获取Map中的数据：
    老方式：<%=((Map<String,String>)request.getAttribute("strMap")).get("xx")%><br/>
    el方式：${strMap.xx}
    <hr/>
    获取bean中的数据：
    老方式：<%=((User)request.getAttribute("user")).getUsername()%><br/>
    el方式：${user.username}
    <hr/>
    el方式获取找不到的属性：
    ${dfsdfsdf}
    <hr/>
    el方法获取key值中有特殊符号的属性：
    ${requestScope["hello.world"]}
</body>
</html>