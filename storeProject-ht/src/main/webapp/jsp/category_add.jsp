<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 子页面不需要 html head body 而且如果存在以上元素，如果script文件如果写在head或者非body区域中时候是不会执行 -->
<div style="padding:10px">
    <form id="category_add" method="post">
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
            onSubmit:function(param){
                param.method="saveCategory";
            },
            success:function(obj){
                alert(obj);
            }
        });
    }
    function clearForm(){
        $('#category_add').form('clear');
    }
</script>