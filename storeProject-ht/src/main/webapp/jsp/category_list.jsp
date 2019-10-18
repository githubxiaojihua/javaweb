<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 子页面不需要 html head body 而且如果存在以上元素，如果script文件如果写在head或者非body区域中时候是不会执行 -->
<!-- 要开始展示类别信息了....(和数据库进行一步交互) -->
<table id="category_list"></table>

<!-- 用于在类目页展示不同子窗口的div，应用的是dialog样式 -->
<div id="category_dialog"></div>

<script type="text/javascript">
    $(function(){
        //应用easyUI表格样式
        $('#category_list').datagrid({
            url:"${pageContext.request.contextPath}/categoryht?method=findCategory",
            columns:[[
                {field:'cid',title:'类目编码',width:100},
                {field:'cname',title:'类目名称',width:100},
                {field:'****',title:'操作',width:100,
                    formatter:function(value,row,index){
                        return "<a href='javascript:void(0);' onclick=deleteByCid('" + row.cid + "')>删除</a>" +
                               "--" +
                               "<a href='javascript:void(0);' onclick=updateByCid('" + row.cid + "','" + row.cname + "')>修改</a>";
                    }
                }
            ]],
            // /*列自适应*/
            //fitColumns:true,
            /*填充满父容器*/
            fit:true,
            /*分页*/
            pagination:true,
            pageList:[5,10,15,20,25,30],
            pageSize:5,
            /* 工具栏 */
            toolbar:
                [
                    {   //增加按钮实现
                        iconCls: 'icon-add',
                        handler: function()
                        {
                            // 把一个html渲染成dialog
                            $("#category_dialog").dialog(
                                {
                                    width:300,
                                    height:200,
                                    title:"添加",
                                    href:"category_add.jsp"
                                }
                            );
                        }
                    },'-',
                    {
                        iconCls: 'icon-help',
                        handler: function()
                        {
                            alert('帮助按钮')
                        }
                    }]
        });
    });

    /**
     * 根据cid删除
     * @param cid
     */
    function deleteByCid(cid){
        //构造请求的URL
        var url = "${pageContext.request.contextPath}/categoryht";
        //构造请求的参数(使用json对象的格式）
        var data = {
            method:"deleteByCid",
            cid:cid
        };
        //使用ajax方式异步请求。
        $.ajax({
            url:url,
            type:"post",
            data:data,
            success:function(obj){
                /**
                 * 如果后台输出的时候写的是println那么这里怎么比较都是有问题的
                 * 因为obj后面还包含\r\n
                 */
                if("ok"==obj){
                    // 删除成功 右下角做提示
                    $.messager.show({
                        title:'分类删除消息',
                        msg:'恭喜你,删除分类成功!!!',
                        timeout:5000,
                        showType:'fade'
                    });

                    // 刷新表格的最新数据
                    $("#category_list").datagrid("reload",true);
                }else{
                    alert("删除错误！");
                }
            },
            error:function(e){
                alert(e);
            }
            //dataType参数不指定的话默认返回类型为String
        });
    }

    /**
     * 打开修改页面
     * @param cid
     * @param cname
     */
    function updateByCid(cid,cname){
         $("#category_dialog").dialog({
            width:300,
            height:200,
            title:"修改",
            //通过请求参数的形式传递cid和cname
            href:"category_update.jsp?cid="+cid + "&cname=" + cname
         });
    }

</script>
