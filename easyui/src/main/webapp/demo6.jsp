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
    //页面布局组件的使用，以及通过布局组件组合分组、树、表格等控件
    //点击tree节点的时候增加相应的标签页
    $(function(){
        $("#tt").tree({
            onClick:function(node){
                var flag = $("#xx").tabs('exists',node.text);
                if(flag){
                    $("#xx").tabs("select",node.text);
                }else{
                    $("#xx").tabs("add",{
                        //node.text获得点击节点的文本
                       title:node.text,
                        //通过iframe来将数据表格嵌套到新建的标签页中
                        content:"<iframe width='100%' height='100%' src='${pageContext.request.contextPath}/demo5.jsp'/>"
                    });
                }
            }
        });
    });
</script>
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
    <div data-options="region:'west',title:'West',split:true" style="width:170px;">
        <div id="aa" class="easyui-accordion" style="width:300px;height:200px;" data-options="fit:true">
            <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
                <h3 style="color:#0099FF;">Accordion for jQuery</h3>
                <p>Accordion is a part of easyui framework for jQuery.
                    It lets you define your accordion component on web page more easily.</p>
            </div>
            <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
                <ul id="tt" class="easyui-tree">
                    <li>
                        <span>Folder</span>
                        <ul>
                            <li>
                                <span>Sub Folder 1</span>
                                <ul>
                                    <li>
                                        <!-- 由于这里是超链接，因此没有办法通过名称来判断是否已经存在
                                             相同的标签页
                                         -->
                                        <span><a href="#">File 11</a></span>
                                    </li>
                                    <li>
                                        <span>File 12</span>
                                    </li>
                                    <li>
                                        <span>File 13</span>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <span>File 2</span>
                            </li>
                            <li>
                                <span>File 3</span>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <span>File21</span>
                    </li>
                </ul>

            </div>
            <div title="Title3">
                content3
            </div>
        </div>
    </div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
        <div id="xx" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">

        </div>
    </div>
</body>
</html>