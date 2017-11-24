<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="houseForm" id="houseForm" name="houseForm" method="post" enctype="multipart/form-data">
        <table style="width:100%;">
            <tr>
                <td class="label">房屋类型：</td>
                <td>
                    <input id="houseCatId" name="houseCatId" style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">房屋销售标题：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="title" name="title"
                           data-options="required:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td class="label">房屋卖点：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="sellPoint" name="sellPoint"
                           data-options="validType:'length[0,150]',multiline:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td class="label">房屋地址：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="address" name="address"
                           data-options="required:true" style="width:100%">
                </td>
            </tr>
            <tr>
                <td class="label">房屋价格 (万元)：</td>
                <td>
                    <input class="easyui-numberbox" type="text" id="price" name="price"
                           data-options="required:true,min:0">
                </td>
            </tr>
            <tr>
                <td class="label">房屋图片：</td>
                <td>
                    <input class="easyui-filebox" name="images[]" multiple="true"  style="width:300px">
                </td>
            </tr>

            <tr class="houseparamsShow" style="display:none;">
                <td class="label">房屋规格：</td>
                <td>

                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="houseSubmitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="houseClearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
            <input name="paramData" id="paramData" style="display:none;">
        </table>
    </form>
</div>

<script>
    //提交表单
    function houseSubmitForm() {
        $('#houseForm').form('submit', {
            url: 'house',
            //在表单提交之前触发
            onSubmit: function () {
                var paramsJson = [];
                var $liList = $('#houseForm .houseparamsShow li');
                $liList.each(function (i, e) {
                    $group = $(e).find('.group');
                    var groupName = $group.text();

                    var params = [];
                    var $trParams = $(e).find('tr').has('td.param');
                    $trParams.each(function (_i, _e) {
                        var $oneDataTr = $(_e);
                        var $keyTd = $oneDataTr.find('.param');
                        var $valueInput = $keyTd.next('td').find('input');
                        var key = $keyTd.text();
                        var value = $valueInput.val();

                        var _o = {
                            k: key,
                            v: value
                        };
                        params.push(_o);
                    });
                    var o = {};
                    o.group = groupName;
                    o.params = params;
                    paramsJson.push(o);
                });
                paramsJson = JSON.stringify(paramsJson);
                $('#paramData').val(paramsJson);
                //做表单校验，表单上所有字段全部校验通过才能返回true，才会提交表单，
                //如果有任意一个字段没有校验通过，返回false，不会提交表单
                return $(this).form('validate');
            },
            //在表单提交之后
            success: function (data) {
                if(data>0) {
                    $.messager.alert('温馨提示', '恭喜!房源发布成功!');
                    ajhouse.closeTabs('查看房源');
                    ajhouse.addTabs('查看房源', 'house-list');
                    ajhouse.closeTabs('发布房源');
                }

            }
        });
    }

    $('#houseCatId').combotree({
        url:'housecat',
        required:true,
        onBeforeSelect: function (node) {
                console.log(node);
                //如果是叶子节点就发送ajax请求，请求查询tb_item_param
                $.get(
                    //url
                    'houseParam/query/'+node.id,
                    //success
                    function(data){
                        //console.log(typeof(data));
                        var $outerTd = $('#houseForm .houseparamsShow td').eq(1);
                        var $ul = $('<ul>');
                        $outerTd.empty().append($ul);
                        if (data) {
                            var paramData = data.paramData;
                            paramData = JSON.parse(paramData);
                            //遍历分组
                            $.each(paramData, function (i, e) {
                                var groupName = e.group;
                                var $li = $('<li>');
                                var $table = $('<table>');
                                var $tr = $('<tr>');
                                var $td = $('<td colspan="2" class="group">' + groupName + '</td>');

                                $ul.append($li);
                                $li.append($table);
                                $table.append($tr);
                                $tr.append($td);

                                //遍历分组项
                                if (e.params) {
                                    $.each(e.params, function (_i, paramName) {
                                        var _$tr = $('<tr><td class="param">' + paramName + '</td><td><input></td></tr>');
                                        $table.append(_$tr);
                                    });
                                }
                            });

                            $("#houseForm .houseparamsShow").show();
                        } else {

                            $("#houseForm .houseparamsShow").hide();
                            $("#houseForm .houseparamsShow td").eq(1).empty();//第二个td
                        }


                    }
                );


        }
    });
</script>