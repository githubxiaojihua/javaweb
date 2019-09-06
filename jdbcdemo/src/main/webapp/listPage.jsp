<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
</head>
<body>
	<table border="1px" align="center">
		<tr align="right">
			<td colspan="8">
				<form id="search" action="${pageContext.request.contextPath}/product" method="post">
					<input type="hidden" name="method" value="select"/>
					名称：<input type="text" name="name" value="${name}"/>
					关键字：<input type="text" name="kw" value="${kw}"/>
					<input type="submit" value="提交"/>
				</form>
			</td>
			<td colspan="1"><input type="button" value="删除勾选" id="btn"></td>
		</tr>
		<tr>

			<th width="4%"><input type="checkbox" id="delAll"/> </th>
			<th width="8%">商品图片</th>
			<th width="8%">商品id</th>
			<th width="8%">商品名称</th>
			<th width="8%">市场价格</th>
			<th width="8%">商城价格</th>
			<th width="8%">上架时间</th>
			<th>商品描述</th>
			<th width="8%">操作</th>
		</tr>
		<c:if test="${empty page.data}">
			<tr>
				<td colspan="7">暂无商品</td>
			</tr>
		</c:if>
		<c:if test="${not empty page.data}">
			<form id="actForm" action="${pageContext.request.contextPath}/product">
				<input type="hidden" name="method" value="delSel"/>
			<c:forEach items="${page.data}" var="pro">

				<tr>
					<td width="4%"><input type="checkbox"  name="id" value="${pro.pid}" /></td>
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
			</form>
		</c:if>
	</table>
	<!-- 分页组件 page中的totalPage属性是动态计算的，但是在el表达始终仍然可以直接调用totalPage
		这并不会返回0，而是会调用getTotalPage方法进行计算。如果将PageBean中的getTotalPage方法注释掉
		那么初始化本jsp的时候会出错
	-->
	<center>
		<c:if test="${page.pageNumber>1}">
			<a href="${pageContext.request.contextPath}/product?method=page&pageNumber=${page.pageNumber-1}">上一页</a>
		</c:if>
		<c:forEach begin="1" end="${page.totalPage}" step="1" var="pageNum">
			<c:if test="${page.pageNumber == pageNum}">
				${pageNum}
			</c:if>
			<c:if test="${page.pageNumber != pageNum}">
				<a href="${pageContext.request.contextPath}/product?method=page&pageNumber=${pageNum}">${pageNum}</a>
			</c:if>

		</c:forEach>
		<c:if test="${page.pageNumber<page.totalPage}">
			<a href="${pageContext.request.contextPath}/product?method=page&pageNumber=${page.pageNumber+1}">下一页</a>
		</c:if>
		第${page.pageNumber}页/共${page.totalPage}页
	</center>

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

	//全选全不选
	$(function(){
	    $("#delAll").change(function(){
	        $("[name='id']").prop("checked",$(this).prop("checked"));
		});
	    $("#btn").click(function(){
	        $("#actForm").submit();
		});
	});
</script>
</html>