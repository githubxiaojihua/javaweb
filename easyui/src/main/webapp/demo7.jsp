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
<!--
    对话框的使用
-->
<script type="text/javascript">
    $(function(){
        $("#btn1").linkbutton({
            onClick:function(){
                //调用对话框的open方法
                $("#dd").dialog("open");
            }
        });
    })
</script>
<body>

    <button id="btn1" class="easyui-linkedbutton">打开面板</button>
    <!-- 对话框的关键属性，resizable是否可变大小，modal蒙版是否开启，closed是否关闭,draggable是否可拖拽 -->
    <div id="dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
         data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,draggable:false">
        Dialog Content.
    </div>

</body>
</html>