<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="新闻详情" data-options="fit:true">
    <form class="docForm" id="sysnewAddForm" name="sysnewAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">新闻题目：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="title" name="title"
                           data-options="required:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <!-- 加载编辑器的容器 -->
                    <script id="newsContent" name="newsContent" type="text/plain">新闻内容</script>
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
        $('#sysnewAddForm').form('submit', {
            url: 'sysnew',
            //在表单提交之前触发
            onSubmit: function () {
                return $(this).form('validate');
            },

            //在表单提交之后
           success: function (data) {
                    $.messager.alert('温馨提示', '恭喜!添加新闻成功!');
                    ajhouse.closeTabs('新增系统新闻');
                    ajhouse.addTabs('查看系统新闻', 'sysnews-list');

            }
        });
    }
    //初始化之前实例删除原有的容器
    UE.delEditor('newsContent');
    var ue=UE.getEditor('newsContent');
    $('#menuLeafid').combotree({
        url:'docsmenu?parentid=0',
        required:true,
        onBeforeExpand:function(node){
          var $currentTree =$('#menuLeafid').combotree('tree');
          var option =$currentTree.tree('options');
          option.url ='docsmenu?parentid='+node.id;
        }

    });
</script>