<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="city_toolbar">
    <div style="padding: 10px; background-color: #fff;">
        <label>城市名：</label>
        <input class="easyui-textbox" style="font-size: 9pt" type="text" id="search_city_name">
        <button onclick="cityListSearchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="cityListAdd()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="cityListEdit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="cityListRemove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
    </div>
</div>
<table id="city_dg"></table>
<script>




    //区域名称的模糊查询
    function cityListSearchForm(){
        $('#city_dg').datagrid('load',{
            name:$('#search_city_name').val()
        });
    }


    function cityListAdd() {
        ajhouse.addTabs('新增城市', 'city-add');
    }

    function cityListEdit() {
        ajhouse.closeTabs('编辑城市');

        var selections = $('#city_dg').datagrid('getSelections');
        if (selections.length != 1) {
            //客户没有选择记录或选择多条记录
            $.messager.alert('提示', '请选中一条记录！');
            return;
        }
        $.messager.confirm('确认', '您确认想要编辑记录吗？', function (r) {
            if (r) {
                //存放id
                var id = selections[0].id;
                //把id异步提交到后台
                $.post(
                    'city/editor',
                    {'id': id},
                    //callback:后台处理成功的回调函数，相当于success，function类型
                    function (data) {
                        //$('#city_dg').datagrid('reload');
                        //console.log('数据:'+data);
                        //ajhouse.addTabs('编辑城市', 'city-editor');
                    },
                    //dataType:返回的数据类型，如：json，String类型
                    'json'
                );
                ajhouse.addTabs('编辑城市', 'city-editor');

            }
        });

    }

    function cityListRemove() {
        //console.log('remove');
         var selections = $('#city_dg').datagrid('getSelections');
         if (selections.length == 0) {
             //客户没有选择记录
             $.messager.alert('提示', '请至少选中一条记录！');
             return;
         }
         //至少选中了一条记录
         //确认框
         $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
             if (r) {
                 //存放id的集合
                 var ids = [];
                 //遍历选中的记录，将记录的id存放到js数组中
                 for (var i = 0; i < selections.length; i++) {
                     ids.push(selections[i].id);
                 }
                 //把ids异步提交到后台
                 $.post(
                     //url:请求后台的哪个地址来进行处理，相当于url,String类型
                     'cities/batch',
                     //data:从前台提交哪些数据给后台处理，相当于data，Object类型
                     {'ids[]': ids},
                     //callback:后台处理成功的回调函数，相当于success，function类型
                     function (data) {
                         $('#city_dg').datagrid('reload');
                     },
                     //dataType:返回的数据类型，如：json，String类型
                     'json'
                 );
                 //如果标签存在，先关闭再打开 if()
                 ajhouse.closeTabs('查看区域');
                 //ajhouse.addTabs('查看区域');
             }
         });
    }


    //初始化数据表格
    $('#city_dg').datagrid({
        //允许多列排序
        //multiSort: true,

        //将工具栏添加到数据表格中
        toolbar: '#city_toolbar',
        //请求远程服务器上的URL http://localhost:8080/ajhouse/cities
        url: 'cities',
        //隔行变色，斑马线效果
        striped: true,
        //添加分页工具栏
        pagination: true,
        //每行的前面显示行号
        rownumbers: true,
        //使得数据表格自适应填充父容器
        fit: true,
        //默认显示10条
        pageSize: 10,
        //分页列表
        pageList: [10,20, 50, 100],
        //列属性
        columns: [[
            //field title width列属性
            {field: 'ck', checkbox: true},
            {field: 'id', title: '城市编号', width: 100, sortable: true},
            {field: 'name', title: '城市名称', width: 100, sortable: true},
        ]]
    });


</script>
