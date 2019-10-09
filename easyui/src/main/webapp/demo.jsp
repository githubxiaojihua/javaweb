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
<body>

    <!-- 使用easyUI的模版，根据课程，首先导入相关css，js文件夹，然后
         按照以上顺序分别导入easyui.css,icon.css,jquery.min.js,jquery.easyui.min.js

         如何使用easyui？
	导入项目需要的css文件(两个，注意：css文件里面有图片的相对路径地址,需要把图片文件夹和当前的css放到同级别下)
	导入项目需要的js文件(两个，注意：导包的时候注意顺序，easyui依赖于jquery.js)

	easyui语法：
		组件的使用
			静态的方式：css
				使用类选择器加载对应的组件即可
				class="easyui-组件名称"
			动态的方式：js
				使用jquery获取对象.组件名称()

		组件属性的使用：
			静态的方式：
				data-options="属性名:属性值，属性名:属性值......."
			动态的方式：
				jquery获取对象.组件名称({
					属性名:属性值,
					属性名1：属性值1
				})
		组件事件的使用：
			动态的方式：
				jquery对象.组件名称({
					事件名:function(){

					}
				})
		组件方法的使用：
			动态的方式：
				jquery对象.组件名称("方法名",{如果是单值的可以不用写大括号，多值的需要写大括号})
     -->
</body>
</html>