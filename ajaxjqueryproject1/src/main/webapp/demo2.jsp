<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#tid").keyup(function(){
			//发送ajax
			$.post("${pageContext.request.contextPath}/kw","kwname="+$("#tid").val(),function(obj){
				$("#did").html("");
				//alert(obj);
				//遍历obj
				if(obj!=""){
					$(obj).each(function(){
						//this
						//alert(this);
						$("#did").append("<div onmouseover='over(this)' onmouseout='out(this)'>"+this+"</div>");
						$("#did").show();
					})
				}else{
					//alert("1111");
					$("#did").hide();
				}
				
			},"json");
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<center>
		<div>
			<h1>黑马搜索</h1>
			<div>
				<input name="kw" id="tid"><input type="button" value="黑马一下">
			</div>
			<div id="did" style="border: 1px solid red;width: 171px;position:relative;left:-34px;display:none"></div>
		</div> 
	</center>
</body>
<script type="text/javascript">
	function over(obj){
		$(obj).css("background-color","gray");
	}
	
	function out(obj){
		$(obj).css("background-color","white");
	}
</script>
</html>