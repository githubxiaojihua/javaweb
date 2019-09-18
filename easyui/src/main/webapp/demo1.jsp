<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">

    $(function(){
        //通过动态的方式应用按钮样式
        $("#btn1").linkbutton();
        //通过动态的方式使用组件属性
        $("#btn2").linkbutton({
            iconCls:'icon-save',
            disabled:true
        });

        //通过动态的方式使用组件的事件，点击btn3禁用btn4
        $("#btn3").linkbutton({
            onClick:function(){
                $("#btn4").linkbutton({
                    disabled:true
                })
            }
        });

        //通过动态的方式使用组件的方法
        $("#btn5").linkbutton("disable");
    });




</script>
<body>

<!-- 使用easyUI的模版，根据课程，首先导入相关css，js文件夹，然后
     按照以上顺序分别导入easyui.css,icon.css,jquery.min.js,jquery.easyui.min.js
 -->
    <button class="easyui-linkbutton">静态方式应用按钮样式</button><br/>
    <input type="button" class="easyui-linkbutton" value="input按钮"/><br/>
    <button id="btn1">动态方式应用按钮样式</button>

    <hr/>
    <!-- 属性的使用 -->
    <button class="easyui-linkbutton" data-options="iconCls:'icon-search'">组件属性的使用(静态)</button><br/>
    <a id="btn2">组件属性的使用(动态)</a>
    <hr/>
    <!-- 时间的使用 -->
    <button id="btn3" class="easyui-linkbutton">点击我</button>
    <button id="btn4" class="easyui-linkbutton">禁用我</button>
    <hr/>

    <button id="btn5" class="easyui-linkbutton">组件方法的使用</button>

</body>
</html>