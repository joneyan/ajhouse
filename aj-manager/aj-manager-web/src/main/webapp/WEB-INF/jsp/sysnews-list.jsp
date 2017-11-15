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

</div>
    <table id="table"></table>
<script>
    $('#table').datagrid({
        url:'sysnews',
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
        pageSize: 5,
        //分页列表
        pageList: [5,10,20, 50, 100],
        //列属性
    columns:[[
//    {field:'id',title:'新闻ID'},
    {field:'title',title:'新闻题目'},
    {field:'newsContent',title:'新闻内容'},
    {field:'status',title:'新闻状态'}
    ]]
    });
</script>

