<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<form class="itemForm" id="itemAddForm" name="itemAddForm" method="post">
    <table style="width:100%;">
        <tr>
            <td class="label">账户名：</td>
            <td>
                <input class="easyui-textbox" id="acountnum" name="acountnum" data-options="required:true"
                       value="${ajAdmin.acountnum}" readonly="readonly" style="width:200px;">
            </td>
        </tr>
        <tr>
            <td class="label">密码：</td>
            <td>
                <input class="easyui-passwordbox" type="text" id="password" name="password" value="${ajAdmin.password}"
                       data-options="required:true" style="width:200px;" data-options="validType:'length[4,10]',multiline:true">
            </td>
        </tr>
        <tr>
            <td class="label">状态：</td>
            <td>
                <select id="isUse"  class="easyui-combobox"  data-options="required:true"
                        name="isUse" >
                    <option value="1">已激活</option>
                    <option value="0">锁定</option>
                </select>
            </td>
        </tr>
        <tr>
            <td class="label">身份：</td>
            <td>
                <select id="roleId" class="easyui-combobox" name="roleId"  data-options="required:true">
                    <option value="1">管理员</option>
                    <option value="2">超级管理员</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button onclick="submitForm()" class="easyui-linkbutton" type="button"
                        data-options="iconCls:'icon-ok'">修改
                </button>
                <button onclick="clearForm()" class="easyui-linkbutton" type="button"
                        data-options="iconCls:'icon-undo'">重置
                </button>
            </td>
        </tr>
    </table>
</form>
<script>

    $('#isUse').combobox({
        onLoadSuccess: function(){
            $('#isUse').combobox('setValue', ${ajAdmin.isUse});
        }
    });


    $('#roleId').combobox({
        onLoadSuccess: function(){
            $('#roleId').combobox('setValue', ${ajAdmin.roleId});
        }
    });

    function submitForm() {
        $('#itemAddForm').form('submit',{
            url:'updateAdmin',
            onSubmit:function ( ) {
                
                return $(this).form('validate');
            },
            success: function (data) {
                if (data>0){
                    $.messager.alert('温馨提示', '恭喜！修改信息成功！');
                    ajhouse.closeTabs('修改信息');
                    ajhouse.closeTabs('查询管理');
                    ajhouse.addTabs('查询管理', 'admin-list');
                }
            }
        });
    }

    function clearForm() {
        $('#itemAddForm').form('reset');
    }
</script>
