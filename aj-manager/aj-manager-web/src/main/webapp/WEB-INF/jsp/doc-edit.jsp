<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="docForm" id="docAddForm" name="docAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">菜单列表：</td>
                <td>
                    <input type="hidden" name="menuname" id="menuname" value="${sessionScope.ajdocs.menuname}">
                    <input id="menuLeafid" name="menuLeafid" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">菜单标题：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="doCtitle" value="${ajdocs.doCtitle}" name="doCtitle"
                           data-options="required:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="hidden" name="doccontent" id="doccontent" value="${ajdocs.docContent}">
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="content" type="text/plain">

                    </script>
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
    //提交表单
    function submitForm() {
        $('#docAddForm').form('submit', {
            url: 'doc',
            //在表单提交之前触发
            onSubmit: function () {
                return $(this).form('validate');
            },
            //在表单提交之后
            success: function (data) {
                $.messager.alert('温馨提示', '恭喜!添加文档成功!');
                ajhouse.addTabs('查看文档', 'doc-list');
                ajhouse.closeTabs('新增文档');


            }
        });
    }
    //初始化之前实例删除原有的容器
    UE.delEditor('container');
    var ue=UE.getEditor('container');

    $('#menuLeafid').combotree({
        url:'docsmenu?parentid=0',
        required:true,
        onBeforeExpand: function (node) {
            //获取当前被点击的tree
            var $currentTree = $('#menuLeafid').combotree('tree');
            //调用easyui tree组件的options方法
            var option = $currentTree.tree('options');
            //修改option的url属性
            option.url = 'docsmenu?parentid=' + node.id;
        },
        onBeforeSelect:function (node) {
            var isLeaf=$('#cid').tree('isLeaf',node.target);
            if(!isLeaf){
                $.messager.alert('警告', '请选中最终的类别！', 'warning');
                return false;
            }
        },
        onLoadSuccess:function (node,data) {
            var menuname = $('#menuname').val();
           var doccontent= $('#doccontent').val();
            $('#menuLeafid').combotree('setValues',menuname);
            ue.addListener('ready',function () {
                ue.setContent(doccontent);
            })
        }
        });
</script>