<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="easyui-panel" title="商品规格参数模板详情" data-options="fit:true">
    <form class="form" id="itemParamAddForm" name="itemParamAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">商品类目：</td>
                <td>
                    <input id="houseCatId" name="houseCatId" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">规格参数：</td>
                <td>
                    <button class="easyui-linkbutton" onclick="addGroup()" type="button" data-options="iconCls:'icon-add'">添加分组</button>
                    <ul id="house-param-group">

                    </ul>
                    <ul id="house-param-group-template" style="display:none;">
                        <li>
                            <input name="group">
                            <button title="添加参数" class="easyui-linkbutton" onclick="addParam(this)" type="button" data-options="iconCls:'icon-add'"></button>
                            <button title="删除分组" class="easyui-linkbutton" onclick="delGroup(this)" type="button" data-options="iconCls:'icon-cancel'"></button>
                            <ul class="house-param">
                                <li>
                                    <input name="param">
                                    <button title="删除参数" class="easyui-linkbutton" onclick="delParam(this)" type="button" data-options="iconCls:'icon-cancel'"></button>
                                </li>
                            </ul>
                        </li>
                    </ul>
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
    //删除分组
    function delGroup(ele){
        $(ele).parent()._remove();
    }
    //删除参数
    function delParam(ele){
        $(ele).parent().remove();
    }
    //添加参数
    function addParam(ele){
        var $paramli=$('#house-param-group-template .house-param li').eq(0).clone();
        $(ele).parent().find('.house-param').append($paramli);
    }
    //添加分组
    function addGroup(){
        var $li=$('#house-param-group-template li').eq(0).clone();
        $('#house-param-group').append($li);
    }
    //加载分类框
    $('#houseCatId').combotree({
        url:'housecat',
        required:true,
    });
    //保存
    function submitForm(){

        var groupValues = [];

        //遍历分组
        var $groups = $('#house-param-group [name=group]');
        $groups.each(function(index, ele){

            //遍历分组项
            var paramValues = [];
            var $params = $(ele).parent().find('.house-param [name=param]')
            $params.each(function(_index, _ele){

                var _val = $(_ele).val();
                if($.trim(_val).length > 0){
                    paramValues.push(_val);
                }

            });

            var val = $(ele).val();
            var o = {};
            o.group = val;
            o.params = paramValues;

            if($.trim(val).length > 0 && paramValues.length > 0){
                groupValues.push(o);
            }

        });

        //得到规格参数模板json串
        console.log(groupValues);

        var houseCatId = $('#houseCatId').combotree('getValue');
        var url = 'house/param/save/' + houseCatId;
        var jsonStr = JSON.stringify(groupValues);
        console.log(jsonStr);
        $.post(url, {paramData: jsonStr}, function(data){
            $.messager.alert('温馨提示','恭喜！添加参数成功！');
            $('#tab').tabs('close','房屋规格参数管理');
           // ajhouse.addTabs('规格参数','item-param-list');
        });
    }
</script>