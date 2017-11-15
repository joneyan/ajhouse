<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="doctoolbar">
    <div>

    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
    </div>
</div>
<div id="docdg"></div>
<script>
    $('#docdg').datagrid({
        multiSort: true,
        toolbar:'doctoolbar',
        url:'docs',
        striped:true,
        pagination:true,
        rownumbers:true,
        fit:true,
        pageSize:20,
        pageList:[10,20,50,100],
        columns:[[
            {field:'ck',checkbox:true,width: 100},
            {field:'id',title:'商品编号',width: 100},
            {field:'do_ctitle',title:'文章标题',width: 100, sortable: true,formatter:function (value,row,index) {
                return row.doCtitle;
            }},
            {field:'menu_leafid',title:'所属菜单',width: 100, sortable: true,formatter:function (value,row,index) {
                return row.menuname;
            }},
            {field:'docContent',title:'文章内容',width: 100},
            {field:'creatTime',title:'创建日期',width: 100},
            {field:'updateTime',title:'修改日期',width: 100},
        ]]
    });
</script>

