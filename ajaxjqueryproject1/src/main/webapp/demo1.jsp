<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">

	$(function(){
	    //绑定失去交点事件，并且通过ajax异步检查用户名是否可用
	    $("[name=username]").blur(function(){
	        $.ajax({
				url:"${pageContext.request.contextPath}/userServlet",
				type:"post",
				//通过普通形式传递多参数，后台可以用request接收
				data:"userName=" + $("[name=username]").val() + "&pass=123",
				//以json形式传递多参，后台也可以用request接收
				/*data:{
				    userName:$("[name=username]").val(),
					pass:"111"
				},*/
				success:function(obj){
					//设置提示信息
					if(obj == 1){
                        $("#usename_msg").html("<font color=red>用户名已经存在</font>");
                        $("#sub").attr("disabled","disabled");
					}else{
					    $("#usename_msg").html("<font color=green>用户名可以使用</font>");
                        $("#sub").removeAttr("disabled");
					}

				},
				error:function(e){
				    alert(e);
				}

			})

		});
	});
</script>
</head>
<body>
	<form method="post" action="#">
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"></td>
				<td><span id="usename_msg"></span></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="password"></td>
				<td></td>
			</tr>
			<tr>
				<td colspan='3'><input type="submit" id="sub"></td>
			</tr>
		</table>
	</form>
</body>

</html>