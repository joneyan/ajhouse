<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="regin_toolbar">
    <div style="padding: 10px; background-color: #fff;">
        <label>区域名：</label>
        <input class="easyui-textbox2" style="font-size: 9pt" type="text" id="search_regin_name">
        <label>所属城市：</label>
        <input class="easyui-textbox2" style="font-size: 9pt" type="text" id="search_city_name2">
        <button onclick="reginListSearchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="reginListAdd()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="reginListEdit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="reginListRemove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
    </div>
</div>
<table id="regin_dg"></table>
<script>
    /*$(function () {
        $("#tab").tabs({
            //取消选项卡选择
            onUnselec:function(title,index){
                var currentTab = $('#tab').tabs('getSelected');

            }
        });
    })*/

    //区域名称的模糊查询
    function reginListSearchForm(){
        $('#regin_dg').datagrid('load',{
            name:$('#search_regin_name').val(),
            cityName:$('#search_city_name2').val()
        });
    }


    function reginListAdd() {
        ajhouse.addTabs('新增区域', 'regin-add');
    }

    function reginListEdit() {
        console.log('edit');
        ajhouse.closeTabs('编辑区域');
        var selections = $('#regin_dg').datagrid('getSelections');
        //console.log(selections);
        if (selections.length != 1) {
            //客户没有选择记录
            $.messager.alert('提示', '请选中一条记录！');
            return;
        }
        //至少选中了一条记录
        $.messager.confirm('确认', '您确认想要编辑记录吗？', function (r) {
            if (r) {
                //存放id
                var id = selections[0].id;
                //把id异步提交到后台
                $.post(
                    'regins/editor',
                    {'id': id},
                    //callback:后台处理成功的回调函数，相当于success，function类型
                    function (data) {
                        //$('#dg').datagrid('reload');
                        //console.log('数据:'+data);
                        //ajhouse.addTabs('编辑城市', 'city-editor');
                    },
                    //dataType:返回的数据类型，如：json，String类型
                    'json'
                );
                ajhouse.addTabs('编辑区域', 'regin-editor');

            }
        });
    }

    function reginListRemove() {
		//console.log('remove');

        var selections = $('#regin_dg').datagrid('getSelections');
        //console.log(selections);
        if (selections.length == 0) {
            //客户没有选择记录
            $.messager.alert('提示', '请至少选中一条记录！');
            return;
        }
        //至少选中了一条记录
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
                    'regin/batch',
                    {'ids[]': ids},
                    function (data) {
                        $('#regin_dg').datagrid('reload');
                    },
                    'json'
                );
            }
        });
    }


    //初始化数据表格
    $('#regin_dg').datagrid({
        //允许多列排序
        //multiSort: true,

        //将工具栏添加到数据表格中
        toolbar: '#regin_toolbar',
        //请求远程服务器上的URL http://localhost:8080/ajhouse/regins
        url: 'regins',
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
            {field: 'ck2', checkbox: true},
            {field: 'id', title: '区域编号', width: 100, sortable: true},
            {field: 'name', title: '区域名称', width: 100, sortable: true},
            {field: 'cityId', title: '所属城市编号', width: 100, sortable: true},
            {field: 'cityName', title: '所属城市', width: 100, sortable: true}
        ]]
    });

</script>

