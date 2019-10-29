<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>struts</title>
</head>
<body>
    <!-- day01 -->
    <a href="${pageContext.request.contextPath}/hello">struts2的初访问</a><br/>
    <a href="${pageContext.request.contextPath}/hello2">访问第二种Action创建方式（实现Action接口)</a><br/>
    <a href="${pageContext.request.contextPath}/hello3">访问第三种Action创建方式（继承自ActionSupport)</a><br/>

    <!-- 通配符请求 -->
    <a href="${pageContext.request.contextPath}/product_save">商品保存</a><br/>
    <a href="${pageContext.request.contextPath}/product_delete">商品删除</a><br/>
    <a href="${pageContext.request.contextPath}/product_update">商品修改</a><br/>
    <a href="${pageContext.request.contextPath}/product_find">商品查询</a><br/><br/>


    <hr>
    <!-- 动态请求 -->
    <a href="${pageContext.request.contextPath}/product!save">商品保存</a><br/>
    <a href="${pageContext.request.contextPath}/product!delete">商品删除</a><br/>
    <a href="${pageContext.request.contextPath}/product!update">商品修改</a><br/>
    <a href="${pageContext.request.contextPath}/product!find">商品查询</a>

    <!-- day02 -->
    <h2>Servlet的API访问方式(3种)</h2>
    <a href="${pageContext.request.contextPath}/jsp/form.jsp">ServletActionContext的方式</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/form.jsp">ActionContext的方式</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/form.jsp">实现特定接口的方式</a><br/>
    <a href="${pageContext.request.contextPath}/ad8">证明action是单实例还是多实例</a><br/>
    <a href="${pageContext.request.contextPath}/ad9">result的type测试</a><br/>

    <a href="${pageContext.request.contextPath}/jsp/form2.jsp">struts2的页面数据封装(属性方式-基本类型和String类型)</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/form2.jsp">struts2的页面数据封装(属性方式-对象类型)</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/form2.jsp">struts2的页面数据封装(属性方式-复杂类型封装)</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/form2.jsp">struts2的页面数据封装(模型封装)</a><br/>
</body>
</html>