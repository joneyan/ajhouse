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
                <td colspan="2">
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="docContent" type="text/plain">文档内容</script>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="submitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="clearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    $('menuLeafid').combotree({
        url:'docsmenu?parentid=0',
        required:true,
        onBeforeExpand:function(node){
          var $currentTree =$('#menuLeafid').combotree('tree');
          var option =$currentTree.tree('options');
          option.url ='docsmenu?parentid='+node.id;
        },
        onBeforeSelect:function (node) {
            var isLeaf=$('#cid').tree('isLeaf',node.target);
            if(!isLeaf){
                $.messager.alert('警告', '请选中最终的类别！', 'warning');
                return false;
            }
        }
    });
</script>