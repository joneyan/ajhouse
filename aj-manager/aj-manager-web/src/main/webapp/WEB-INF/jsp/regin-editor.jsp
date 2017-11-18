<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="编辑区域" data-options="fit:true">
    <form class="reginForm" id="reginEditorForm" name="reginEditorForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">区域编号：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="reginsId" name="id" readonly="readonly"
                           data-options="required:true" style="width:200px" value="${reginsId}">
                </td>
            </tr>
            <tr>
                <td class="label">区域名称：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="reginName2" name="name"
                           data-options="required:true" style="width:200px" value="${reginsName}">
                </td>
            </tr>
            <tr>
                <td class="label">所属城市：</td>
                <td>
                    <input class="easyui-combotree" type="text" id="treeNode" name="cityId"
                           data-options="required:true" style="width:200px" >
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="reginEditorSubmitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="reginEditorClearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>

        </table>
        <!--<input name="paramData" id="paramData" style="display:none;">-->
    </form>
</div>

<script>
    //加载城市的下拉框
   $('#treeNode').combotree({
        url: 'citiesCats',
        required: true,
        onLoadSuccess:function () {
            $('#treeNode').combotree('setValue',${cityId});
        }
    });

    //重置
    function reginEditorClearForm() {
        /*ajhouse.closeTabs('编辑区域');
        ajhouse.addTabs('编辑区域','regin-editor');*/
        ajhouse.refreshTab('编辑区域');
    }

    //提交表单
    function reginEditorSubmitForm(){
        $('#reginEditorForm').form('submit',{
            url: 'regins/editor2',
            //在表单提交之前触发
            onSubmit:function () {
                //如果有任意一个字段没有校验通过，返回false，不会提交表单
                return $(this).form('validate');
            },
            //后台处理成功之后的回调函数
            success:function(data){
                if(data > 0) {
                    $.messager.alert('温馨提示','恭喜！编辑区域成功！');
                    //关闭页
                    ajhouse.closeTabs('编辑区域');
                    //重置页
                    if($('#tab').tabs('exists','查看区域')) {
                        /*ajhouse.closeTabs('查看区域');
                        ajhouse.addTabs('查看区域', 'regin-list');*/
                        ajhouse.refreshTab('查看区域');
                    }

                }else{
                    $.messager.alert('警告','编辑区域失败！');
                }
            }
        });
    }

</script>
