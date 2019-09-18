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
    //使用动态属性操作，为tabs创建一个新的选项卡，并增加内容
    //如果已经存在名称为新增选项卡的tab则不再新增而是选中
    $(function(){
        $("#btn1").linkbutton({
            onClick:function(){
                //是否已经存在
                var flag = $("#tt").tabs("exists","新增选项卡");
                //已经存在则选中
                if(flag){
                    $("#tt").tabs("select","新增选项卡");
                }else{
                    //否则新增
                    $("#tt").tabs("add",{
                       title:"新增选项卡",
                        //设置内容
                       content:"开心"
                    });
                }
            }
        });
    });
</script>
<body>
    <a id="btn1" class="easyui-linkbutton">增加选项卡</a>
    <div id="tt" class="easyui-tabs" style="width:500px;height:250px;">
        <div title="Tab1" style="padding:20px;display:none;">
            tab1
        </div>
        <div title="Tab2" data-options="closable:true" style="overflow:auto;padding:20px;display:none;">
            tab2
        </div>
        <div title="Tab3" data-options="iconCls:'icon-reload',closable:true" style="padding:20px;display:none;">
            tab3
        </div>
    </div>

</body>
</html>