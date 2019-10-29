<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		 <!-- 属性封装:基本类型和String类型  -->	
		<%--<form action="${pageContext.request.contextPath}/ad11" method="post">
			用户名:<input type="text" name="userName" />
			年龄:<input type="text" name="age" />
			<input type="submit" value="提交" />
		</form>--%>

		<!-- 属性封装:对象类型  OGNL表达式-->
		<%--<form action="${pageContext.request.contextPath}/ad12" method="post">
			用户名:<input type="text" name="user.userName" />
			年龄:<input type="text" name="user.age" />
			<input type="submit" value="提交" />
		</form>--%>
		
		<!-- 属性封装:复杂类型 (list) -->
		<%--<form action="${pageContext.request.contextPath}/ad13" method="post">
			用户名:<input type="text" name="list[0].userName" /><br/>
			年龄:<input type="text" name="list[0].age" /><br/>
			用户名:<input type="text" name="list[1].userName" /><br/>
			年龄:<input type="text" name="list[1].age" /><br/>
			用户名:<input type="text" name="list[2].userName" /><br/>
			年龄:<input type="text" name="list[3].age" /><br/>
			<input type="submit" value="提交" />
		</form>--%>
		
		<hr/>
		<!-- 属性封装:复杂类型 (map) map['aaa'].userName-->
		<form action="${pageContext.request.contextPath}/ad13" method="post">
			用户名:<input type="text" name="map['aaa'].userName" /><br/>
			年龄:<input type="text" name="map['aaa'].age" /><br/>
			用户名:<input type="text" name="map['bbb'].userName" /><br/>
			年龄:<input type="text" name="map['bbb'].age" /><br/>
			用户名:<input type="text" name="map['ccc'].userName" /><br/>
			年龄:<input type="text" name="map['ccc'].age" /><br/>
			<input type="submit" value="提交" />
		</form>
		
		<!-- 模型封装 -->
		<%--<form action="${pageContext.request.contextPath}/ad14" method="post">
			用户名:<input type="text" name="userName" />
			年龄:<input type="text" name="age" />
			<input type="submit" value="提交" />
		</form>--%>
	
</body>
</html>