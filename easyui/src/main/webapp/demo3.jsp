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
    //使用动态属性操作，为树指定数据
    $(function(){
        $("#tt1").tree({
            url:"${pageContext.request.contextPath}/json.json"
        });
    });
</script>
<body>
    <!-- 手工写一个tree -->
    <ul id="tt" class="easyui-tree">
        <li>
            <span>Folder</span>
            <ul>
                <li>
                    <span>Sub Folder 1</span>
                    <ul>
                        <li>
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
        <!-- 新增加一个自定义部分 -->
        <li>
            <span>自定义菜单</span>
            <ul>
                <li>
                    <span>自定义儿子菜单</span>
                    <ul>
                        <li>
                            <span>自定义孙子菜单</span>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>

    </ul>
    <hr/>
    <!-- 使用自定义json数据创建树，使用url属性，使用动态属性操作-->
    <ul id="tt1" class="easyui-tree">


    </ul>

</body>
</html>