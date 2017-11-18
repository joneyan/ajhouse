<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="新增城市" data-options="fit:true">
    <form class="cityForm" id="cityAddForm" name="cityAddForm" method="post">
        <table style="width:100%;">

            <tr>
                <td class="label">城市名称：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="cityName" name="name"
                           data-options="required:true" style="width:200px">
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="cityAddSubmitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="cityAddClearForm()" class="easyui-linkbutton" type="button"
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
        //关闭区域页，防止bug
        /!*ajhouse.closeTabs('新增区域');
        ajhouse.closeTabs('编辑区域');
        ajhouse.closeTabs('查看区域');*!/
        //$('#tab').tabs('select','新增城市');
    });*/

    //重置
    function cityAddClearForm() {
        /*ajhouse.closeTabs('新增城市');
        ajhouse.addTabs('新增城市','city-add');*/
        //ajhouse.refreshTab('新增城市');
        //$('#tab').panel('refresh');
        ajhouse.refreshTab('新增城市');
    }

    //提交表单
    function cityAddSubmitForm(){
        $('#cityAddForm').form('submit',{
            //提交表单到item进行处理
            url: 'city',
            //在表单提交之前触发
            onSubmit:function () {
                //alert(123);
                //如果有任意一个字段没有校验通过，返回false，不会提交表单
                return $(this).form('validate');

            },
            //后台处理成功之后的回调函数
            success:function(data){
                if(data > 0) {
                    $.messager.alert('温馨提示','恭喜！添加城市成功！');
                    //关闭添加页
                    ajhouse.closeTabs('新增城市');
                    //重置会受到影响的选项卡
                    if($('#tab').tabs('exists','查看区域')) {
                        /*ajhouse.closeTabs('查看区域');
                        ajhouse.addTabs('查看区域', 'regin-list');*/
                        ajhouse.refreshTab('查看区域');
                    }
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

                }else{
                    $.messager.alert('警告','新增城市失败！');
                }
            }
        });
    }
</script>