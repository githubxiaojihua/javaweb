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
    //使用动态属性操作，为表格设计数据
    $(function(){
        $("#dg").datagrid({
            url:"${pageContext.request.contextPath}/json1.json",
            columns:[[
                {field:'id',title:'商品编号',width:100},
                {field:'pname',title:'商品名称',width:100},
                {field:'price',title:'商品价格',width:100,align:'right'},
                {field:'image',title:'商品图片',width:100,
                    //每一列的格式化参数用于对与某一列进行自定义格式化
                    formatter:function(value,row,index){
                        //格式化图片显示样式，因为默认的话只是显示图片路径，应该使用img进行包裹
                        //return "<img width=20px height=20px src='"+ value +"'/>";
                        return "<a href='#'>修改</a>--<a href='#'>删除</a>";
                    }
                }
            ]],
            //显示斑马线
            striped:true,
            //显示分页控件
            pagination:true,
            //每页显示条数
            pageList:[2,3,4,5,6,7,8]
        });
    });
</script>
<body>
    <!-- 使用fitColumns属性可以让datagrid自适应，但是必须再th上增加width来规定个个列的占比-->
    <!-- 通过js来操作的时候可以不用使用class属性来指定是easyui -->
    <table id="dg" class="easyui-datagrid" data-options="fitColumns:true">
        <%--<thead>
        <tr>
            <th width="20px" data-options="field:'code'">编码</th>
            <th width="20px" data-options="field:'name'">名称</th>
            <th width="20px" data-options="field:'price'">价格</th>
        </tr>
        </thead>
        <tbody>

        </tbody>--%>
    </table>

</body>
</html>