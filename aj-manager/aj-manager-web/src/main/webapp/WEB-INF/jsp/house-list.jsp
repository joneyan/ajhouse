<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="housetoolbar">
    <div>

    </div>
    <div>
        <button onclick="houseadd()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">发布房源</button>
        <button onclick="housestop()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">禁止</button>
    </div>
</div>
<div id="housedg"></div>
<script>
    //禁止房源
    function housestop(){
        var selections = $('#housedg').datagrid('getSelections');
        console.log(selections);
        if(selections.length==0){
            $.messager.alert('提示','请至少选中一条记录');
            return;
        }
        $.messager.confirm('确认','你确认要禁止选中房源吗？',function (r) {
            if(r){
                var ids=[];
                for(var i=0;i<selections.length;i++){
                    ids.push(selections[i].id);
                }
                $.post(
                    'house/batchstop',
                    {'ids[]':ids},
                    function (data) {
                       $('#housedg').datagrid('reload');
                    },
                    'json'

                );
            }
        })
    }
    //发布房源方法
    function houseadd(){
        ajhouse.addTabs('发布房源','house-add');
    }
    //文档列表数据表格
    $('#housedg').datagrid({
        multiSort: true,
        toolbar:'#housetoolbar',
        url:'houses',
        striped:true,
        pagination:true,
        rownumbers:true,
        fit:true,
        pageSize:20,
        pageList:[20,50,100],
        columns:[[
            {field:'ck',checkbox:true,width: 100},
            {field:'id',title:'房屋编号',width: 100},
            {field:'title',title:'房屋标题',width: 100,formatter:function (value,row,index) {
                return row.title;
            }},
            {field:'address',title:'房屋地址',width: 100},
            {field:'price',title:'房屋价格',width: 100, formatter:function (value,row,index) {
                return row.price+"万元";
            }},
            {field:'sellPoint',title:'房屋卖点',width: 100},
            {field:'createtime',title:'创建日期',width: 100,formatter:function (value,row,index) {
                return moment(value).format('LL');

            }},
            {field:'updatetime',title:'修改日期',width: 100,formatter:function (value,row,index) {
                return moment(value).format('LL');

            }}
        ]]
    });
</script>

