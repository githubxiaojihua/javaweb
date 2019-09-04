<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px" align="center">
		<tr>
			<th width="8%">商品图片</th>
			<th width="8%">商品id</th>
			<th width="8%">商品名称</th>
			<th width="8%">市场价格</th>
			<th width="8%">商城价格</th>
			<th width="8%">上架时间</th>
			<th>商品描述</th>
			<th width="8%">操作</th>
		</tr>
		<c:if test="${empty list}">
			<tr>
				<td colspan="7">暂无商品</td>
			</tr>
		</c:if>
		<c:if test="${not empty list}">
			<c:forEach items="${list}" var="pro">
				<tr>
					<td><img src="${pageContext.request.contextPath}/${pro.pimage}" height="75px"/></td>
					<td>${pro.pid}</td>
					<td>${pro.pname}</td>
					<td>${pro.market_price}</td>
					<td>${pro.shop_price}</td>
					<td>${pro.pdate}</td>
					<td>${pro.pdesc}</td>
					<td>
						<a href="${pageContext.request.contextPath}/product?method=edit&id=${pro.pid}">修改</a>
						<!-- 注意：在js中写el表达式的时候需要加上单引号 -->
						<!-- 这里还可以写href="javascript:void(0);" -->
						<a href="#" onclick="del('${pro.pid}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
<script type="text/javascript">
	function del(id){
		var flag = confirm("您确认要删除吗？");
		//根据返回值判断是否删除
		if(flag){
			//执行删除操作
			location.href = "${pageContext.request.contextPath}/product?method=delete&pid="+id;
		}
	}
</script>
</html>