<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
</head>
<body>
<button id="btn1">js-ajax-get</button><br>
<button id="btn2" >js-ajax-post</button><br>
<button id="btn3" >js-ajax</button><br>
</body>
<!-- 使用jquery中的ajax -->
<script type="text/javascript">
    $("#btn1").click(function(){
        $.get("${pageContext.request.contextPath}/ajaxjquerydemo1","userName=张三",function(obj){
            alert(obj);
        });
    });

    $("#btn2").click(function(){
        $.post("${pageContext.request.contextPath}/ajaxjquerydemo1","userName=张三",function(obj){
            alert(obj);
        })
    });

    $("#btn3").click(function(){
        $.ajax({
            url:"${pageContext.request.contextPath}/ajaxjquerydemo1",
            type:"post",
            data:"userName=张三",
            success:function(obj){
                alert(obj);
            },
            error:function(e){
                alert(e);
            }
        });
    });
</script>

</html>