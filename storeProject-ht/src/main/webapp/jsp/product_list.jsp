<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 子页面不需要 html head body 而且如果存在以上元素，如果script文件如果写在head或者非body区域中时候是不会执行 -->
<!-- 要开始展示产品信息了....(和数据库进行一步交互) -->
<table id="product_list"></table>

<!-- 用于在类目页展示不同子窗口的div，应用的是dialog样式 -->
<div id="product_dialog"></div>


<script type="text/javascript">
    $(function(){
        $('#product_list').datagrid({
            url:'${pageContext.request.contextPath}/productht?method=findProduct',
            columns:[[
                {field:'pimage',title:'商品图片',width:100,
                    formatter:function (value,row,index) {
                        return "<img width='50' src=${pageContext.request.contextPath}/"+ value +" />";
                    }
                },
                {field:'pid',title:'商品编号',width:100},
                {field:'pname',title:'商品名称',width:100},
                {field:'shop_price',title:'商品价格',width:100},
                {field:'pdate',title:'商品日期',width:100},
                {field:'is_hot',title:'是否热门',width:100,
                    formatter: function(value,row,index)
                    {
                        return value==0?"热门":"不热门";
                    }
                },
                {field:'category',title:'所属分类',width:100,
                    formatter:function (value,row,index) {
                        return value.cname;
                    }
                },
            ]],
            pagination:true,
            pageList:[5,10,15,20,25,30],
            pageSize:5,
            fit:true,
            /* 工具栏 */
            toolbar: [{
                iconCls: 'icon-add',
                handler: function()
                {
                    // 只要点击,就将普通的html标签渲染成dialog组件
                    $("#product_dialog").dialog
                    (
                        {
                            width:400,
                            height:400,
                            title:"商品添加",
                            href:"product_add.jsp"
                        }
                    );
                }
            },'-',{
                iconCls: 'icon-help',
                handler: function(){alert('帮助按钮')}
            }]
        });
    });
</script>
