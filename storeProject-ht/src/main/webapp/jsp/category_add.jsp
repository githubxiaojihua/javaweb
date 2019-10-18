<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<!-- 子页面不需要 html head body 而且如果存在以上元素，如果script文件如果写在head或者非body区域中时候是不会执行 -->
<div style="padding:10px">
    <form id="category_add" method="post" >
        <%--<input type="hidden" name="method" value="saveCategory">--%>
        <table cellpadding="5">
            <tr>
                <td>Name:</td>
                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
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
        $('#category_add').form('submit',{
            url:"${pageContext.request.contextPath}/categoryht",
            //在触发提交之前执行，可以扩展参数，以及阻止提交，返回false即可
            onSubmit:function(param){
                param.method="saveCategory";
            },
            success:function(obj){
                //1、判断成功与否，成功后弹出提示框，并刷新列表

                if(obj=="ok"){
                    // 隐藏对话框，由于最终只有一个页面因此在本子页面也可以访问父页面的id元素
                    $("#category_dialog").dialog("close",true);

                    //在底部显示信息
                    $.messager.show({
                        title:'添加分类消息',
                        msg:'恭喜您添加成功。',
                        timeout:5000,
                        showType:'slide'
                    });
                    // 刷新表格数据
                    $("#category_list").datagrid("reload",true);
                }
            }
        });
    }
    function clearForm(){
        $('#category_add').form('clear');
    }
</script>