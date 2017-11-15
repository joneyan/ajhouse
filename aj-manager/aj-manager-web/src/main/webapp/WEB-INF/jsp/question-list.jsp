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
        <%--<div style="padding: 5px; background-color: #fff;">
            <label>菜单标题：</label>
            <input class="easyui-textbox" type="text" id="title">
            <label>菜单所属类：</label>

            <select id="status" class="easyui-combobox" style="width: 110px">

            </select>

            </select>
            <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
            <!--注意：要加上type="button",默认行为是submit-->
            <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
            &lt;%&ndash;<a onclick="searchForm()" class="easyui-linkbutton">搜索</a>&ndash;%&gt;
        </div>
        <div>
            <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
            <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
            <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        </div>--%>
</div>

    <table id="table"></table>
<script>
    $('#table').datagrid({
        url:'questions',
//        //允许多列排序
//        multiSort: true,
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
        pageSize: 2,
        //分页列表
        pageList: [2,5,10,20, 50, 100],
        //列属性
    columns:[[
//    {field:'id',title:'新闻ID'},
    {field:'quesTitle',title:'问题标题'},
    {field:'quesContent',title:'问题内容'},
    {field:'createtime',title:'问题创建日期'},
    {field:'solvetime',title:'解决日期'},
    {field:'userid',title:'问题所属用户id'},
    {field:'status',title:'问题状态'}
    ]]
    });

</script>

