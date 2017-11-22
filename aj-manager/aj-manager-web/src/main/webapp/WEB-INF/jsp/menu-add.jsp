<%--
  Created by IntelliJ IDEA.
  User: hao
  Date: 2017/11/14
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-panel" title="添加菜单" data-options="fit:true">
    <form class="form" id="menuAddForm" name="itemParamAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">所属模块：</td>
                <td>
                    <input id="menuBox" class="easyui-combotree"  data-options="required:true" name="parentid" style="width:200px;">
                </td>
                <td>
                    <input type="hidden" name="operatorid" value="${sessionScope.admin.id}">
                </td>
            </tr>
            <tr>
                <td class="label">功能菜单：</td>
                <td>
                <input class="easyui-textbox" type="text" id="name" name="name"
                       data-options="required:true"   >
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button class="easyui-linkbutton" onclick="submitForm()" type="button" data-options="iconCls:'icon-ok'">保存</button>
                    <button class="easyui-linkbutton" onclick="clearForm()" type="button" data-options="iconCls:'icon-undo'">重置</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>


    $('#menuBox').combotree({
        url: 'menus/parent'
    });

    function clearForm() {
        $('#menuAddForm').form('reset');
    }

    function submitForm() {
        $('#menuAddForm').form('submit',{
            url:'menus/addmenu',
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (data) {
                if (data > 0) {
                    $.messager.alert('温馨提示', '恭喜！添加菜单成功！');
                    ajhouse.addTabs('查看菜单', 'menu-list');
                    $('#dgmenu').datagrid('reload');
                    ajhouse.closeTabs('新增菜单');
                }
            }
        });
    }


</script>