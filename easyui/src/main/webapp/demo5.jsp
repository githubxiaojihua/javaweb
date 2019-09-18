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
        $("#dg").datagrid({
            url:"${pageContext.request.contextPath}/json1.json",
            columns:[[
                {field:'code',title:'Code',width:100},
                {field:'name',title:'Name',width:100},
                {field:'price',title:'Price',width:100,align:'right'}
            ]]
        });
    });
</script>
<body>
    <!-- 使用fitColumns属性可以让datagrid自适应，但是必须再th上增加width来规定个个列的占比-->
    <table id="dg" class="easyui-datagrid" data-options="fitColumns:true">
        <thead>
        <tr>
            <th width="20px" data-options="field:'code'">编码</th>
            <th width="20px" data-options="field:'name'">名称</th>
            <th width="20px" data-options="field:'price'">价格</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>

</body>
</html>