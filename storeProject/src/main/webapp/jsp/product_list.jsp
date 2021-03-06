<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>产品列表</title>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
			}
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>
		<!-- 静态包含 -->
		<%@include file="head.jsp"%>
		<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
					<li><a href="#">首页</a></li>
				</ol>
			</div>

			<c:if test="${not empty page.data}">
				<c:forEach items="${page.data}" var="product">
					<div class="col-md-2">
						<a href="${pageContext.request.contextPath}/product?method=findByPid&pid=${product.pid}">
							<img src="${pageContext.request.contextPath}/${product.pimage}" width="170" height="170" style="display: inline-block;">
						</a>
						<p><a href="${pageContext.request.contextPath}/product?method=findByPid&pid=${product.pid}" style='color:green'>${product.pname}</a></p>
						<p><font color="#FF0000">商城价：&yen;${product.shop_price}</font></p>
					</div>
				</c:forEach>
			</c:if>

		</div>

		<!--分页 -->
		<div style="width:380px;margin:0 auto;margin-top:50px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
				<!-- class="disabled" -->
					<!-- 对上一页按钮进行判断如果当前是第一页则不允许上翻 -->
					<c:if test="${page.pageNumber==1}">
						<li class="disabled">
							<a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>
					<!-- 非第一页允许上翻 -->
					<c:if test="${page.pageNumber!=1}">
						<li>
							<a href="${pageContext.request.contextPath}/product?method=findProsByCid&pageNum=${page.pageNumber - 1}&cid=${cid}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
					</c:if>

				<c:forEach begin="1" end="${page.totalPage}" var="pg">
					<c:if test="${pg==page.pageNumber}">
						<li class="active"><a href="#">${pg}</a></li>
					</c:if>

					<c:if test="${pg!=page.pageNumber}">
						<li>
							<a href="${pageContext.request.contextPath}/product?method=findProsByCid&pageNum=${pg}&cid=${cid}">${pg}</a>
						</li>
					</c:if>

				</c:forEach>

				<!-- 对下一页按钮进行判断如果当前页等于总页数则不允许下翻 -->
				<c:if test="${page.pageNumber==page.totalPage}">
					<li class="disabled">
						<a href="#" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>
				<!-- 允许下翻 -->
				<c:if test="${page.pageNumber!=page.totalPage}">
					<li>
						<a href="${pageContext.request.contextPath}/product?method=findProsByCid&pageNum=${page.pageNumber + 1}&cid=${cid}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</c:if>

			</ul>
		</div>
		<!-- 分页结束=======================        -->

		<!--
       		商品浏览记录:
        -->
		<div style="width:1210px;margin:0 auto; padding: 0 9px;border: 1px solid #ddd;border-top: 2px solid #999;height: 246px;">

			<h4 style="width: 50%;float: left;font: 14px/30px " 微软雅黑 ";">浏览记录</h4>
			<div style="width: 50%;float: right;text-align: right;"><a href="">more</a></div>
			<div style="clear: both;"></div>

			<div style="overflow: hidden;">

				<ul style="list-style: none;">
					<li style="width: 150px;height: 216;float: left;margin: 0 8px 0 0;padding: 0 18px 15px;text-align: center;"><img src="${pageContext.request.contextPath}/products/1/cs10001.jpg" width="130px" height="130px" /></li>
				</ul>

			</div>
		</div>
		<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/image/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a>关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 传智商城 版权所有
		</div>

	</body>

</html>