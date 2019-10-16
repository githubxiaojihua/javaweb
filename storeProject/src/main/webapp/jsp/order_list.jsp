<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>我的订单</title>

		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
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

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
						<c:if test="${not empty page.data}">
							<tbody>
							<c:forEach items="${page.data}" var="order">

								<tr class="success">
									<th colspan="4">订单编号:${order.oid} </th>
									<th colspan="1">订单状态:
										<!-- state; // 状态 0:未付款  1 未发货  2 未评价  3 已完成 -->
										<c:if test="${order.state == 0}">
											<a href="${pageContext.request.contextPath}/order?method=findOrderByOID&oid=${order.oid}" style="color:red">去付款</a>
										</c:if>
										<c:if test="${order.state == 1}">
											<a href="#" style="color:red">查看物流信息</a>
										</c:if>
										<c:if test="${order.state == 2}">
											<a href="#" style="color:red">去评价</a>
										</c:if>
									</th>
								</tr>
								<tr class="warning">
									<th>图片</th>
									<th>商品</th>
									<th>价格</th>
									<th>数量</th>
									<th>小计</th>
								</tr>
								<c:forEach items="${order.list}" var="item">
									<!-- class="active" -->
									<tr class="active">
										<td width="60" width="40%">
											<input type="hidden" name="id" value="22">
											<img src="${pageContext.request.contextPath}/${item.product.pimage}" width="70" height="60">
										</td>
										<td width="30%">
											<a target="_blank"> ${item.product.pname}</a>
										</td>
										<td width="20%">
											￥298.00
										</td>
										<td width="10%">
											5
										</td>
										<td width="15%">
											<span class="subtotal">￥${item.product.shop_price}</span>
										</td>
									</tr>
								</c:forEach>


							</c:forEach>
							</tbody>

						</c:if>


					</table>
				</div>
			</div>
			<div style="text-align: center;">
				<ul class="pagination">
					<!-- 上一页 -->
					<c:if test="${page.pageNumber==1}">
						<li class="disabled"><a href="javascript:void(0);" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>
					<c:if test="${page.pageNumber!=1}">
						<li ><a href="${pageContext.request.contextPath}/order?method=findOrder&pageNum=${page.pageNumber-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					</c:if>


					<!-- 中间页 -->
					<c:forEach begin="1" end="${page.totalPage}" var="num">
						<c:if test="${page.pageNumber!=num}">
							<li><a href="${pageContext.request.contextPath}/order?method=findOrder&pageNum=${num}">${num}</a></li>
						</c:if>
						<c:if test="${page.pageNumber==num}">
							<li class="active"><a href="javascript:void(0);">${num}</a></li>
						</c:if>
					</c:forEach>

					<!-- 下一页 -->
					<c:if test="${page.totalPage==page.pageNumber}">
						<li class="disabled">
							<a href="javascript:void(0);" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>
					<c:if test="${page.totalPage!=page.pageNumber}">
						<li>
							<a href="${pageContext.request.contextPath}/order?method=findOrder&pageNum=${page.pageNumber+1}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</c:if>





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