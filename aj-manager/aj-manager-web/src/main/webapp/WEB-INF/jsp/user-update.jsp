<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<form class="userForm" id="userUpdateForm" name="userUpdateForm" method="post">
    <table style="width:100%;">
        <tr hidden="hidden">
            <td class="label">账户编号：</td>
            <td>
                <input class="easyui-textbox" id="id" name="id" data-options="required:true"
                       value="${user.id}" readonly="readonly" style="width:200px;">
            </td>
        </tr>
        <tr>
            <td class="label">新密码：</td>
            <td>
                <input class="easyui-passwordbox" type="text" id="password" name="password" value=""
                       data-options="required:true" style="width:200px;" data-options="validType:'length[4,10]',multiline:true">
            </td>
        </tr>
        <tr>
            <td class="label">重复新密码：</td>
            <td>
                <input class="easyui-passwordbox" type="text" id="password1" name="password1" value=""
                       data-options="required:true" style="width:200px;" data-options="validType:'length[4,10]',multiline:true">
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
    function submitForm() {
        $('#userUpdateForm').form('submit',{
            url:'updateUser',
            onSubmit:function ( ) {
                var pwd1 = $("#password").val();
                var pwd2 = $("#password1").val();
                if(pwd1!=pwd2){
                    $.messager.alert('警告','两次密码不一致!');
                    return false;
                }
                return $(this).form('validate');
            },
            success: function (data) {
                if (data>0){
                    $.messager.alert('温馨提示', '恭喜！修改密码成功！');
                    ajhouse.closeTabs('修改密码');
                }
            }
        });
    }


    function clearForm() {
        $('#userUpdateForm').form('reset');
    }

</script>