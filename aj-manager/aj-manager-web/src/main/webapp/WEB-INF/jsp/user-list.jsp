<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbarUser">
    <div style="padding: 5px; background-color: #fff;">
        <label>用户账户：</label>
        <input class="easyui-textbox" type="text" id="title">
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
        <%--<a onclick="searchForm()" class="easyui-linkbutton">搜索</a>--%>
    </div>
    <div>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑密码</button>
    </div>
</div>
<table id="dgUser"></table>
<script>

    //模糊查询
    function searchForm(){
        $('#dgUser').datagrid('load',{
            accountnum:$('#title').val()
        });
    }

    function edit() {
        var selections = $('#dgUser').datagrid('getSelections');
        if (selections.length != 1) {
            $.messager.alert('提示', '请选中一条记录！');
            return;
        }else {
            $.messager.confirm('确认','您确认要修改密码吗?',function (r) {
                if (r){
                    var id = 0;
                    id = selections[0].id;
                    ajhouse.addTabs('修改密码', 'userUpdate/'+id);
                }
            });
        }
    }

    //初始化数据表格
    $('#dgUser').datagrid({
        //允许多列排序
        multiSort: true,
        //将工具栏添加到数据表格中
        toolbar: '#toolbarUser',
        //请求远程服务器上的URL http://localhost:8080/ajhouse/items
        url: 'user',
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
        pageList: [2, 5, 10],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},
            {field: 'id', title: '账户编号', width: 100, sortable: true},
            {field: 'accountnum', title: '账户名', width: 100, sortable: true},
            {field: 'nickname', title: '昵称', width: 100, sortable: true},
            {field: 'tel', title: '电话', width: 100, sortable: true},
            {field: 'email', title: '电子邮件', width: 100, sortable: true},
            {field: 'createTime', title: '创建日期', width: 100 ,formatter: function (value, row, index) {
                return moment(value).format('LL');
            }},
            {field: 'updateTime', title: '上次登录日期', width: 100 ,formatter: function (value, row, index) {
                return moment(value).format('LL');
            }},
            {field: 'idcard', title: '身份证', width: 100},
            {field: 'introduce', title: '自我介绍', width: 100},
            {field: 'opratorId', title: '上次操作的管理员Id', width: 100},
            {
                field: 'status', title: '状态', width: 100, formatter: function (value, row, index) {
                switch (value) {
                    case 1 :
                        return "封禁";
                        break;
                    case 0:
                        return "未封禁";
                        break;
                    default:
                        return "未知";
                        break;
                }
            }
            },

            {field: 'role', title: '身份', width: 100 ,formatter: function (value, row, index) {
                switch (value) {
                    case 1 :
                        return "普通用户";
                        break;
                    case 0:
                        return "经纪人";
                        break;
                    default:
                        return "未知";
                        break;
                }
            }
            },
        ]]
    });
</script>