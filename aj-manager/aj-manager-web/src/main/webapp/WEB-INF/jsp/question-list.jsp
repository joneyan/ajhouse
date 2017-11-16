<%--
  Created by IntelliJ IDEA.
  User: yiyun
  Date: 2017/11/14
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar">
        <div style="padding: 5px; background-color: #fff;">
           <%-- <label>菜单标题：</label>
            <input class="easyui-textbox" type="text" id="title">
            <label>菜单所属类：</label>
--%>
         <%--   <select id="status" class="easyui-combobox" style="width: 110px">

            </select>

            </select>
            <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
            <!--注意：要加上type="button",默认行为是submit-->
            <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>--%>
            <%--<a onclick="searchForm()" class="easyui-linkbutton">搜索</a>--%>
        </div>
        <div>
            <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        </div>
</div>

    <table id="tableQues"></table>
<script>
    function remove() {
        var selections = $('#tableQues').datagrid('getSelections');
        console.log(selections);
        if (selections.length == 0) {
            //客户没有选择记录
            $.messager.alert('提示', '请至少选中一条记录！');
            return;
        }
        //至少选中了一条记录
        //确认框，第一个参数为标题，第二个参数确认框的提示内容，第三参数是一个确认函数
        //function(r) 如果用户点击的是"确定"，那么r=true
        $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
            if (r) {
                //为了存放id的集合
                var ids = [];
                //遍历选中的记录，将记录的id存放到js数组中
                for (var i = 0; i < selections.length; i++) {
                    ids.push(selections[i].id);
                }
                //把ids异步提交到后台
                $.post(
                    //url:请求后台的哪个地址来进行处理，相当于url,String类型
                    'dquestion',
                    //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                    {'ids[]': ids},
                    //callback:后台处理成功的回调函数，相当于success，function类型
                    function (data) {
                        $('#tableQues').datagrid('reload');
                    },
                    //dataType:返回的数据类型，如：json，String类型
                    'json'
                );

            }
        });
    }


    $('#tableQues').datagrid({
        url:'questions',
        //允许多列排序
        multiSort: true,
        //将工具栏添加到数据表格中
        toolbar: '#toolbar',
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条，这样的话就显示20条
        pageSize:5,
        //分页列表
        pageList: [5,10,20, 50, 100],
        //列属性
    columns:[[

    {field: 'ck', checkbox: true},
//    {field:'id',title:'新闻ID'},
    {field:'quesTitle',title:'问题标题'},
    {field:'quesContent',title:'问题内容'},
    {field:'createtime',title:'问题创建日期',formatter: function (value, row, index) {    return moment(value).format('LL');  }},
    {field:'solvetime',title:'解决日期',formatter: function (value, row, index) {    return moment(value).format('LL');  }},
    {field:'userid',title:'问题所属用户'},
    {field:'status',title:'问题状态'}
    ]]
    });


</script>

