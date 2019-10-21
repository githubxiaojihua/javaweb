<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<!-- 子页面不需要 html head body 而且如果存在以上元素，如果script文件如果写在head或者非body区域中时候是不会执行 -->
<div style="padding:10px">
    <form id="productAdd" method="post">
        <table cellpadding="5">
            <tr>
                <td>商品名称:</td>
                <td><input class="easyui-textbox" type="text" name="pname" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>市场价格:</td>
                <td><input class="easyui-textbox" type="text" name="market_price" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>商城价格:</td>
                <td><input class="easyui-textbox" type="text" name="shop_price" data-options="required:true"></input></td>
            </tr>
            <tr>
                <td>上传:</td>
                <td><input class="easyui-filebox" name="upload" style="width:220px" data-options="buttonIcon:'icon-add',buttonText:'上传'"></input></td>
            </tr>
            <tr>
                <td>是否热门:</td>
                <td>
                    <select class="easyui-combobox" name="is_hot" data-options="panelHeight:'auto'">
                        <option value="0">热门</option>
                        <option value="1">不热门</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>所属分类:</td>
                <td><input id="ccccc" name="cid" value="---请选择---"></td>
                <script>
                    $('#ccccc').combobox(
                        {
                            url:'${pageContext.request.contextPath}/productht?method=findCategory',   //servlet的地址  返回的是json数据  		{cid:1,cname:手机数码}
                            valueField:'cid',    //  根据返回json的key  取value值 放在<option value=?></option>
                            textField:'cname',    //   根据返回json的key  取value值 放在<option>?<option>
                            panelHeight:'auto'	// <option value="1">手机数码<option>
                        });
                </script>
            </tr>
            <tr>
                <td>商品描述:</td>
                <td><input class="easyui-textbox" name="pdesc" data-options="multiline:true" style="height:60px"></input></td>
            </tr>
            </tr>
        </table>
    </form>
    <div style="text-align:center;padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
    </div>
</div>

<script>
    function submitForm(){
        $('#productAdd').form('submit',{
        });
    }
    function clearForm(){
        $('#productAdd').form('clear');
    }
</script>