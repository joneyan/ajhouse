<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="新增区域" data-options="fit:true">
    <form class="reginForm" id="reginAddForm" name="reginAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">所属城市：</td>
                <td>
                    <input id="cid" name="id" style="width:200px;"
                           data-options="required:true" >
                </td>
            </tr>
            <tr>
                <td class="label">区域名称：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="reginName" name="name"
                           data-options="required:true" style="width:200px">
                </td>
            </tr>


            <tr>
                <td colspan="2">
                    <button onclick="reginAddSubmitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="reginAddClearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>

        </table>
        <!--<input name="paramData" id="paramData" style="display:none;">-->
    </form>
</div>

<script>
    /*$(function () {
        //关闭城市页，防止bug
        /!*ajhouse.closeTabs('新增城市');
        ajhouse.closeTabs('编辑城市');
        ajhouse.closeTabs('查看城市');*!/
        //$('#tab').tabs('select','新增区域');
    });*/


    //加载城市的下拉框
    $('#cid').combotree({
        url: 'citiesCats',
        required: true
    });

    //重置
    function reginAddClearForm() {
        /*ajhouse.closeTabs('新增区域');
        ajhouse.addTabs('新增区域','regin-add');*/
        ajhouse.refreshTab('新增区域');
    }

    //提交表单
    function reginAddSubmitForm(){
        $('#reginAddForm').form('submit',{
            url: 'regin',
            //在表单提交之前触发
            onSubmit:function () {
                //alert(123);
                //如果有任意一个字段没有校验通过，返回false，不会提交表单
                return $(this).form('validate');
            },
            //后台处理成功之后的回调函数
            success:function(data){
                if(data > 0) {
                    $.messager.alert('温馨提示','恭喜！添加区域成功！');
                    //关闭页
                    ajhouse.closeTabs('新增区域');
                    //重置页
                    if($('#tab').tabs('exists','查看区域')) {
                        /*ajhouse.closeTabs('查看区域');
                        ajhouse.addTabs('查看区域', 'regin-list');*/
                        ajhouse.refreshTab('查看区域');
                    }
                    
                }else{
                    $.messager.alert('警告','新增区域失败！');
                }
            }
        });
    }

</script>
