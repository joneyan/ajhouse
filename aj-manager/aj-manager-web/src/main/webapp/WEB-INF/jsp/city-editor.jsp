<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="编辑城市" data-options="fit:true">
    <form class="cityForm" id="cityEditorForm" name="cityEditorForm" method="post">
        <table style="width:100%;">

            <tr>
                <td class="label">城市编号：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="cityId" name="id"
                           readonly="readonly" style="width:200px" value="${ajCity.id}">
                </td>
            </tr>
            <tr>
                <td class="label">城市名称：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="cityName2" name="name"
                           data-options="required:true" style="width:200px" value="${ajCity.name}">
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="cityEditorSubmitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">修改
                    </button>
                    <button onclick="cityEditorClearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>

        </table>
        <!--<input name="paramData" id="paramData" style="display:none;">-->
    </form>
</div>
<script>


    //重置
    function cityEditorClearForm() {
        /*ajhouse.closeTabs('编辑城市');
        ajhouse.addTabs('编辑城市','city-editor');*/
        ajhouse.refreshTab('编辑城市');
    }

    //提交表单
    function cityEditorSubmitForm(){
        $('#cityEditorForm').form('submit',{
            url: 'city/editor',
            onSubmit:function () {
                return $(this).form('validate');

            },
            //后台处理成功之后的回调函数
            success:function(data){
                if(data > 0) {
                    $.messager.alert('温馨提示','恭喜！编辑城市成功！');
                    ajhouse.closeTabs('编辑城市');

                    //重置会受到影响的选项卡

                    if($('#tab').tabs('exists','编辑区域')) {
                        /*ajhouse.closeTabs('编辑区域');
                        ajhouse.addTabs('编辑区域', 'regin-editor');*/
                        ajhouse.refreshTab('编辑区域');
                    }
                    if($('#tab').tabs('exists','查看城市')) {
                        /*ajhouse.closeTabs('查看城市');
                        ajhouse.addTabs('查看城市', 'city-list');*/
                        ajhouse.refreshTab('查看城市');
                    }
                    if($('#tab').tabs('exists','查看区域')) {
                        /*ajhouse.closeTabs('查看区域');
                        ajhouse.addTabs('查看区域', 'regin-list');*/
                        ajhouse.refreshTab('查看区域');
                    }
                    if($('#tab').tabs('exists','新增区域')) {
                        ajhouse.refreshTab('新增区域');
                    }

                }else{
                    $.messager.alert('警告','编辑城市失败！');
                }
            }
        });
    }
</script>
