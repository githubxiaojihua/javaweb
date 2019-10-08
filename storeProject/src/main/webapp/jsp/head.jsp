<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<!-- 将head独立出来 -->
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>WEB01</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	</head>
	<script type="text/javascript">
        /**
		 * 页面加载时候异步读取分类信息
         */
		$(function(){
		    var urlStr = "${pageContext.request.contextPath}/category";
		    //走数据库查询
		    //var dataStr = {method:"findAll"};
            var dataStr = {method:"fromRedis"};
		    $.ajax({
				url:urlStr,
				type:"post",
				data:dataStr,
				success:function(obj){
				    $(obj).each(function(index,ele){
						$("#menu").append("<li><a href='#'>"+ele.cname+"</a></li>");
					});
				},
				error:function(e){
                    alert(obj);
				},
				dataType:"json"
			});
		});

	</script>
	<body>
	<div class="container-fluid">
		<!-- 抽取导航条和菜单栏 -->
		<!--
            时间：2015-12-30
            描述：菜单栏
        -->
		<div class="container-fluid">
			<div class="col-md-4">
				<img src="${pageContext.request.contextPath}/img/logo2.png" />
			</div>
			<div class="col-md-5">
				<img src="${pageContext.request.contextPath}/img/header.png" />
			</div>
			<div class="col-md-3" style="padding-top:20px">
				<c:if test="${not empty sessionScope.user}">
					<ol class="list-inline">
						<li>欢迎你:${user.name}用户</li>
						<!-- 先访问servlet 通过servlet在转发给web-inf下 -->
						<!-- 以后最好不要jsp访问jsp了 要先访问servlet 通过servlet在访问jsp -->
						<li><a href="#">我的订单</a></li>
						<li><a href="cart.htm">购物车</a></li>
						<li><a href="${pageContext.request.contextPath}/user?method=quit">退出</a></li>
					</ol>
				</c:if>

				<c:if test="${empty sessionScope.user}">
					<ol class="list-inline">
						<li><a href="${pageContext.request.contextPath}/user?method=loginUI">登录</a></li>
						<!-- 先访问servlet 通过servlet在转发给web-inf下 -->
						<!-- 以后最好不要jsp访问jsp了 要先访问servlet 通过servlet在访问jsp -->
						<li><a href="${pageContext.request.contextPath}/user?method=registerUI">注册</a></li>
						<li><a href="cart.htm">购物车</a></li>
					</ol>
				</c:if>
			</div>
		</div>
		<!--
            时间：2015-12-30
            描述：导航条
        -->
		<div class="container-fluid">
			<nav class="navbar navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">首页</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul id="menu" class="nav navbar-nav">
							<!-- 分类信息由异步加载 -->
							<%--<li class="active"><a href="product_list.htm">手机数码<span class="sr-only">(current)</span></a></li>
							<li><a href="#">电脑办公</a></li>
							<li><a href="#">电脑办公</a></li>
							<li><a href="#">电脑办公</a></li>--%>
						</ul>
						<form class="navbar-form navbar-right" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>

					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
	</div>
	</body>

</html>