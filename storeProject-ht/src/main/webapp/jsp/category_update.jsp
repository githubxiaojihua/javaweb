<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<!-- 子页面不需要 html head body 而且如果存在以上元素，如果script文件如果写在head或者非body区域中时候是不会执行 -->
<div style="padding:10px">

    <form id="category_update" action="${pageContext.request.contextPath}/categoryht",  method="post" >
        <input type="hidden" name="method" value="updateCategory"/>
        <input type="hidden" name="cid" value="${param.cid}"/>
        <table cellpadding="5">
            <tr>
                <td>Name:</td>
                <!-- 通过使用el内置对象param来在页面接收请求参数-->
                <td><input class="easyui-textbox" value="${param.cname}" type="text" name="cname" data-options="required:true"></input></td>
            </tr>

        </table>
    </form>
    <div style="text-align:center;padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
    </div>
</div>

<script>
    //修改
    function submitForm(){
        $("#category_update").form("submit",{
            success:function (data) {
                //1、如果返回ok则隐藏对话框
                $("#category_dialog").dialog("close",true);
                // 右下角做提示
                $.messager.show({
                    title:'修改消息',
                    msg:'恭喜你,分类修改成功',
                    timeout:5000,
                    showType:'slide'
                });
                //2、刷新列表
                $("#category_list").datagrid("reload",true);
            }
        });
    }




</script>