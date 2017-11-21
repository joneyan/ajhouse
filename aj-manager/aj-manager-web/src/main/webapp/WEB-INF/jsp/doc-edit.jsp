<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="docForm" id="docEditForm" name="docEditForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">菜单列表：</td>
                <td>
                    <input type="hidden" name="id" value="${ajdocs.id}">
                    <input type="hidden" id="himenuLeafid" name="himenuLeafid" value="${ajdocs.menuLeafid}">
                    <input type="hidden" name="menuname" id="menuname" value="${ajdocs.menuname}" disabled="disabled">
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
                    <input type="hidden"  id="doccontent" value='${ajdocs.docContent}' disabled="disabled">
                    <!-- 加载编辑器的容器 -->
                    <script id="container" name="docContent" type="text/plain">

                    </script>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="submitEditForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="clearEditForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
    </form>
</div>

<script>
    var menuname = $('#menuname').val();
    debugger;
    //提交表单
    function submitEditForm() {
        alert(menuname);

        var menuLeafidcontent=$('#menuLeafid').val();
        //获取隐藏的传过来的菜单id
        var hmenuLeafidcontent=$('#himenuLeafid').val();
        alert(menuLeafidcontent);
        alert(hmenuLeafidcontent);
        if(menuname==menuLeafidcontent){
            $('#menuLeafid').val(hmenuLeafidcontent);
        }
        alert($('#menuLeafid').val());
        $('#docEditForm').form('submit', {
            url: 'doc/update',
            //在表单提交之前触发
            onSubmit: function () {
                return $(this).form('validate');
            },
            //在表单提交之后
            success: function (data) {

                if(data>0){
                    $.messager.alert('温馨提示', '恭喜!修改文档成功!');
                    ajhouse.closeTabs('查看文档');
                    ajhouse.addTabs('查看文档', 'doc-list');
                    ajhouse.closeTabs('新增文档');
                }else{
                    $.messager.alert("失败","!!!!!!!!!!!!");
                }

            }
        });
    }
    //初始化之前实例删除原有的容器
    UE.delEditor('container');
    var ue=UE.getEditor('container',{
        initialFrameWidth: '100%',
        initialFrameHeight: '300',
        serverUrl:'file/upload'
    });

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


           var doccontent= $('#doccontent').val();
            $('#menuLeafid').combotree('setValues',menuname);
            ue.addListener('ready',function () {
                ue.setContent(doccontent);
            })
        }
        });
</script>