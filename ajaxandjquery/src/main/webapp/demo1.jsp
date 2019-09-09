<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<button id="btn1" onclick="getAjax()">js-ajax-get</button><br>
<button id="btn2" onclick="postAjax()">js-ajax-post</button><br>
<form action="" method="post" enctype="application/x-www-form-urlencoded">

</form>
</body>
<!-- 原生的ajax -->
<script type="text/javascript">
    /**
     * 向服务器发送get请求
     */
    function getAjax(){
        var xmlhttp;
        //获取xmlhttprequest对象
        if(window.XMLHttpRequest){
            xmlhttp = new XMLHttpRequest();
        }else{
            //IE5,IE6
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        //确定请求方法和请求路径
        xmlhttp.open("get","${pageContext.request.contextPath}/ajaxjquerydemo1?userName=张三");
        //发送请求
        xmlhttp.send();
        //接收结果（回调函数）
        //注意onreadystatechange是小写
        xmlhttp.onreadystatechange = function(){
            if(xmlhttp.readyState==4 && xmlhttp.status==200){
                alert(xmlhttp.responseText);
            }
        };
    }

    /**
     * 向服务器发送post请求
     */
    function postAjax(){
        var xmlHttp;
        //获取XMLHttpRequest对象
        if(window.XMLHttpRequest){
            xmlHttp = new XMLHttpRequest();
        }else{
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //确定请求方法和路径
        xmlHttp.open("post","${pageContext.request.contextPath}/ajaxjquerydemo1");
        //发送请求
        xmlHttp.setRequestHeader("content-type","application/x-www-form-urlencoded");
        xmlHttp.send("userName=张三&pass=123");
        //接收结果(回调函数)
        xmlHttp.onreadystatechange = function(){
            //alert(111111);
            if(xmlHttp.readyState==4 && xmlHttp.status==200){
                alert(xmlHttp.responseText);
            }
        }
    }
</script>

</html>