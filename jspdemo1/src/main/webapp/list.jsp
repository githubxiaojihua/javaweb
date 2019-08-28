<%@ page import="com.xiaojihua.bean.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/28 0028
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Product> productList = (List<Product>) request.getAttribute("products");
%>

    <table border="1px" align="center">
        <tr>
            <th>商品id</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品描述</th>
        </tr>
        <%
            if(productList == null){
        %>
        <tr>
            <td colspan="4">暂无商品</td>
        </tr>

        <%
            }else{
                for(Product p : productList){
        %>
            <tr>
                <td><%=p.getId()%></td>
                <td><%=p.getPname()%></td>
                <td><%=p.getPrice()%></td>
                <td><%=p.getPdesc()%></td>
            </tr>
        <%
                }
            }
        %>
    </table>

</body>
</html>
