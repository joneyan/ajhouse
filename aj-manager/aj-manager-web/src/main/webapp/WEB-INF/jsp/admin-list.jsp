<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbarAdmin">
    <div style="padding: 5px; background-color: #fff;">
        <label>管理员账户：</label>
        <input class="easyui-textbox" type="text" id="title">
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
        <%--<a onclick="searchForm()" class="easyui-linkbutton">搜索</a>--%>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
    </div>
</div>
<table id="dgAdmin"></table>
<script>

    //模糊查询
    function searchForm(){
        $('#dgAdmin').datagrid('load',{
            acountnum:$('#title').val()
        });
    }


    function add() {

        ajhouse.addTabs('新增管理', 'admin-add');
    }

    function edit() {
        var selections = $('#dgAdmin').datagrid('getSelections');
        if (selections.length != 1) {
            $.messager.alert('提示', '请选中一条记录！');
            return;
        }else {
            $.messager.confirm('确认','您确认要修改信息吗?',function (r) {
                if (r){
                    var id = 0;
                    id = selections[0].id;
                    ajhouse.addTabs('修改信息', 'adminUpdate/'+id);
                }
            });
        }
    }

    function remove() {
        var selections = $('#dgAdmin').datagrid('getSelections');
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
                    'admin/batch',
                    //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                    {'ids[]': ids},
                    //callback:后台处理成功的回调函数，相当于success，function类型
                    function (data) {
                        if(data>0){
                            $.messager.alert('提示','删除成功');
                        }
                        $('#dgAdmin').datagrid('reload');
                    },
                    //dataType:返回的数据类型，如：json，String类型
                    'json'
                );

            }
        });
    }

    //初始化数据表格
    $('#dgAdmin').datagrid({
        //允许多列排序
        multiSort: true,
        //将工具栏添加到数据表格中
        toolbar: '#toolbarAdmin',
        //请求远程服务器上的URL http://localhost:8080/ajhouse/items
        url: 'admin',
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
        pageList: [2, 5, 10],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},
            {field: 'id', title: '账户编号', width: 100, sortable: true},
            {field: 'acountnum', title: '账户名', width: 100, sortable: true},
            {field: 'createTime', title: '创建日期', width: 100 ,formatter: function (value, row, index) {
                return moment(value).format('LL');
            }},
            {field: 'updateTime', title: '修改日期', width: 100 ,formatter: function (value, row, index) {
                return moment(value).format('LL');
            }},
            {field: 'operatorId', title: '上次操作的超级管理员', width: 100},
            {
                field: 'isUse', title: '状态', width: 100, formatter: function (value, row, index) {
                switch (value) {
                    case true :
                        return "已激活";
                        break;
                    case false:
                        return "锁定";
                        break;
                    default:
                        return "未知";
                        break;
                }
            }
            },
            {field: 'roleId', title: '身份', width: 100 ,formatter: function (value, row, index) {
                switch (value) {
                    case 1 :
                        return "管理员";
                        break;
                    case 2:
                        return "超级管理员";
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

