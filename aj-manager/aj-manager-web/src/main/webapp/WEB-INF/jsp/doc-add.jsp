<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="itemForm" id="itemAddForm" name="itemAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">菜单列表：</td>
                <td>
                    <input id="menuLeafid" name="menuLeafid" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">菜单标题：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="doCtitle" name="doCtitle"
                           data-options="required:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td class="label">文档内容：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="docContent" name="docContent"
                           data-options="validType:'length[0,150]',multiline:true" style="width:100%;height:60px;">
                </td>
            </tr>
        </table>
    </form>
</div>