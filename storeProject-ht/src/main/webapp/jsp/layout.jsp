<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
</head>
<body>
<div id="cccc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'north',title:'北',split:true" style="height:230px;">
        <!-- 公司的图片logo -->
        <img src="${pageContext.request.contextPath}/image/itheima.bmp" style="height:190px;width:100%" />
    </div>
    <div data-options="region:'west',title:'西',split:true" style="width:350px;">
        <!-- 折叠窗 -->
        <div class="easyui-accordion" data-options="fit:true,border:0">
            <div title="JAVA">
                <!-- 树 -->
                <ul id="tttt" class="easyui-tree">
                    <li>
                        <span>商品分类管理</span>
                        <ul>
                            <li>
                                <span><a href="#" onclick="addTabs()">商品分类列表</a></span>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <span>商品信息管理</span>
                        <ul>
                            <li>
                                <span><a href="#">商品信息列表</a></span>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>
            <div title="UI">111</div>
            <div title="PHP">333</div>
        </div>
    </div>
    <div data-options="region:'center'">
        <!-- 选项卡 -->
        <div id="tabsss" class="easyui-tabs" data-options="fit:true,border:0">
            <div title="欢迎页面">111</div>
        </div>
    </div>
</div>


<script>
    function addTabs()
    {
        // 先判断选项卡中是否有指定的选项卡
        var flg=$("#tabsss").tabs("exists","商品类别展示");
        if(flg)
        {
            // 有---跳过去
            $("#tabsss").tabs("select","商品类别展示");
        }else
        {
            // 没有--创建
            $("#tabsss").tabs("add",
                {
                    title:"商品类别展示",
                    closable:true,
                    /* 引入页面内容 */
                    href:"category_list.jsp"
                })
        }

    }
</script>

</body>
</html>