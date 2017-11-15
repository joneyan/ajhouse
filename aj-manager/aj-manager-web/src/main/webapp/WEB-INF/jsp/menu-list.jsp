<%--
  Created by IntelliJ IDEA.
  User: hao
  Date: 2017/11/13
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>菜单标题：</label>
        <input class="easyui-textbox" type="text" id="title">
        <label>菜单所属类：</label>
        <input id="menuId" name="id"  style="width:150px;">
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>

        <button onclick="clearForm()" type="button" class="easyui-linkbutton">清空</button>

    <%--<a onclick="searchForm()" class="easyui-linkbutton">搜索</a>--%>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
    </div>
</div>
<table id="dg"></table>
<script>

    //清空
    function clearForm() {
        $('#title').textbox({
           value:''
        });
        $('#menuId').combotree('clear');
    }


    //模糊查询
    function searchForm(){
        $('#dg').datagrid('load',{
            title:$('#title').val(),
            status:$('#menuId').combotree('getValue')
        });
    }


    function add() {
        ajhouse.addTabs('新增菜单', 'menu-add');
    }

    function edit() {
        console.log('edit');
        var selections = $('#dg').datagrid('getSelections');
        console.log(selections);
        if (selections.length != 1) {
            $.messager.alert('提示', '请选中一条记录！');
            return;
        }
        $.messager.confirm('确认', '您确认想要修改该记录吗？', function (r) {
            if (r) {
                var id = selections[0].id;
                ajhouse.addTabs("修改菜单","menusUpdate/"+id);
            }
        });
    }

    function remove() {
        var selections = $('#dg').datagrid('getSelections');
        console.log(selections);
        if (selections.length == 0) {
            //客户没有选择记录
            $.messager.alert('提示', '请至少选中一条记录！');
            return;
        }
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
                    'menus/batch',
                    //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                    {'ids[]': ids},
                    //callback:后台处理成功的回调函数，相当于success，function类型
                    function (data) {
                        $.messager.alert('温馨提示', data+'条记录删除成功！');
                        $('#dg').datagrid('reload');
                    },
                    //dataType:返回的数据类型，如：json，String类型
                    'json'
                );

            }
        });
    }

    //初始化数据表格
    $('#dg').datagrid({
        //允许多列排序
        multiSort: true,
        //将工具栏添加到数据表格中
        toolbar: '#toolbar',
        //请求远程服务器上的URL http://localhost:8080/ddshop/items
        url: 'menus',
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条，这样的话就显示20条
        pageSize: 20,
        //分页列表
        pageList: [20, 50, 100],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},
            {field: 'name', title: '菜单名称', width: 100},
            {field: 'createtime', title: '创建时间', width: 100,formatter: function (value, row, index) {
                return moment(value).format('LL');
            }},
            {field: 'updatetime', title: '最后修改时间', width: 100,formatter: function (value, row, index) {
                return moment(value).format('LL');
            }},
            {field: 'parentName', title: '所属模块', width: 100,sortable: true},
            {field: 'operatorid', title: '操作者', width: 100}
        ]]
    });


    //查询下拉框父标题
    $('#menuId').combotree({
        url: 'menus/parent'
    });


    //查询下拉框父标题
    /*$('#status').combobox({
        url:'menus/parent',
        valueField:'id',
        textField:'name'
    });*/
</script>

