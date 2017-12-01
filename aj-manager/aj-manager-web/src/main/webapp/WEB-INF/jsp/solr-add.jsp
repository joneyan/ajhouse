<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div style="padding:5px;" >
    <a id="solradd" class="easyui-linkbutton" >一键导入商品数据到索引库</a>
    <span id="msg"></span>
</div>
<script>
    $(function () {
       $("#solradd").click(function () {
           $("#solradd").linkbutton('disable');
           $('msg').html('导入中请稍后...')
           $.post(
               'solradd',
               function (data) {
                   console.log(data);
                   if(data.success){
                       $.messager.alert('提示', data.message);
                   } else {
                       $.messager.alert('提示','导入索引库失败！');
                   }
                   $('#msg').html('');
               }
           )
       }) ;
    });
</script>