<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/product" method="post">
		<input type="hidden" name="method" value="add">
		商品名称：<input type="text" name="pname"><br>
		市场价格：<input type="text" name="market_price"><br>
		商城价格：<input type="text" name="shop_price"><br>
		商品描述：<textarea rows="5" cols="30" name="pdesc"></textarea><br>
		<input type="submit" value="添加商品">
	</form>
</body>
</html>