
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml" lang="gb2312">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta name="robots" content="noindex,nofollow">
    <link rel="stylesheet" rev="stylesheet" href="${pageContext.request.contextPath}/css/Member_Web_User_Message.css"
          type="text/css">
    <title>用户中心</title>
</head>
<body>
<div class="header-mod">
    <div class="header clearfix">
        <div class="logo">

            <i class="split-icon"></i>
            <a class="sub-logo" href="/ajhouse">首页</a>
        </div>
        <a href="" class="quit">
            <i class="iconfont quitIcon"></i>
            <span>注销</span>
        </a>
    </div>
</div>
<div class="headerSub-mod">
    <div class="headerSub clearfix">
        <img src="${sessionScope.ajUser.photo}" class="user-photo" alt="头像">
        <div class="user-info">
            <div class="info-sup clearfix">
        <span class="hello">
                    <span id="time" class="now-time"></span>好，
                    <span class="name">
                    <c:if test="${sessionScope.ajUser!=null}">
                        <c:if test="${sessionScope.ajUser.nickname==null}">
                            <span class="btn-register">${sessionScope.ajUser.tel}</span>
                        </c:if>
                        <c:if test="${sessionScope.ajUser.nickname!=null}">
                            <span class="btn-register">${sessionScope.ajUser.nickname}</span>
                        </c:if>
                    </c:if>
                    </span>
         </span>
                <ul class="log-way">
                    <li>
                        <i class="iconfont phoneIcon"></i>
                        <div class="dialog">
                            <div class="text">您已通过<span id="userTel">${sessionScope.ajUser.tel}</span>认证</div>
            <div class="corner"></div>
            <div class="border"></div>
            <div class="masker"></div>
        </div>
        </li>

        </ul>
            </div>
            <div class="info-sub clearfix">
                <ul>
                    <li class="user-account">
                        账户名：<span>${sessionScope.ajUser.tel}</span>
                    </li>
                    <i class="split-icon"></i>
                    <li class="user-type">
                        <span>用户</span>
                    </li>
                    <i class="split-icon"></i>
                    <li class="last-time">
                        上次登录：<span class="day"><fmt:formatDate type="both"
                                                               value="${sessionScope.lastloginTime}"/> </span>
                    </li>
                </ul>
            </div>
        </div>
        <a class="info-modify" href="/ajhouse/userX/${sessionScope.ajUser.tel}"<%--id=11--%>>
            <button>修改资料&gt;</button>
        </a>
    </div>
</div>
<div class="container">
    <div class="content clearfix">
        <!-- 侧边栏 -->
        <div class="side-menu">
            <ul class="menu-list">
                <li>
                    <a href="/ajhouse/messages/${sessionScope.ajUser.tel}"<%--id=11--%> class=""><i
                            class="iconfont"></i>系统消息</a>
                </li>

                <li>
                    <a href="/ajhouse/questMessages/${sessionScope.ajUser.tel}"<%--id=11--%> class=""><i class="iconfont"></i>我的提问</a>
                </li>

                <!-- <li>
                    <a href="http://user.anjuke.com/member/loan/55171663/"><i class="iconfont">&#xE141;</i>贷款</a>
                </li>
                <li> -->
                <a href="/ajhouse/questionAns/${sessionScope.ajUser.tel}"<%--id=11--%> <%--target="_blank"--%>><i class="iconfont"></i>我的回答</a>

                <li>
                    <a href="/ajhouse/userX/${sessionScope.ajUser.tel}"<%--id=11--%> class="cur"><i class="iconfont"></i>个人资料</a>
                </li>

            </ul>


        </div>


        <div class="right-content">
            <div class="right-cont">
                <ul class="tab-list clearfix">
                    <li><a href="#" class="cur">修改资料</a></li>
                </ul>

                <div class="">
	<span class="no-msg-content">


    <form id="form1" <%--action="/ajhouse/updataUser" method="post"--%>>

        昵　　称:<input name="nickname" id="nickname" type="text" value="${user.nickname}"><br>
    <input name="tal" id="tal" type="hidden" value="${sessionScope.ajUser.tel}">
        邮　　箱:<input name="email" id="email" type="text" value="${user.email}"><br>
        身份证　:<input name="idcard" id="idcard" type="text" value="${user.idcard}"><br>
        自我介绍: <textarea name="introduce" id="introduce" cols="30" rows="10">${user.introduce}</textarea><br>
         <input type="button"  onclick="updataUser()" value="提交" >
    </form>
<span id="error1" ></span>


	</span>

                </div>
            </div>
            <div class="recommend-house">
                <!-- 推荐 -->
                <div class="rh-area">
                    <p class="rh-title">您可能感兴趣的房源</p>
                    <ul class="rh-items">
                        <li class="rh-item">
                            <a href="#" class="rh-item-content">
                                <img src="./用户中心－看房记录_files/240x180c.jpg" width="182" height="135">
                                <span class="community-area"></span>
                                <span class="community-text">碧桂园</span>
                                <p class="item-title">首付3成，精装统一交付，带产权车位，小区内人车分流，配套齐全</p>
                                <p class="item-info"><span class="item-price">95万</span><span class="item-info-sub">2室3厅，89平米</span>
                                </p>
                            </a>
                        </li>
                        <li class="rh-item">
                            <a href="#" class="rh-item-content">
                                <img src="./用户中心－看房记录_files/240x180c(1).jpg" width="182" height="135">
                                <span class="community-area"></span>
                                <span class="community-text">圣鑫苑(三期)</span>
                                <p class="item-title">看房有钥匙 送大花园 景观房！南北通大一房改两房，产权清晰，</p>
                                <p class="item-info"><span class="item-price">280万</span><span class="item-info-sub">2室2厅，78平米</span>
                                </p>
                            </a>
                        </li>
                        <li class="rh-item">
                            <a href="#" class="rh-item-content">
                                <img src="./用户中心－看房记录_files/240x180c(2).jpg" width="182" height="135">
                                <span class="community-area"></span>
                                <span class="community-text">圣鑫苑(三期)</span>
                                <p class="item-title">看房随时！有钥匙 咫尺大润发 南北通户型 傅雷学校房 景观房</p>
                                <p class="item-info"><span class="item-price">300万</span><span class="item-info-sub">2室2厅，78平米</span>
                                </p>
                            </a>
                        </li>
                        <li class="rh-item">
                            <a href="#" class="rh-item-content">
                                <img src="./用户中心－看房记录_files/240x180c(3).jpg" width="182" height="135">
                                <span class="community-area"></span>
                                <span class="community-text">永德小区</span>
                                <p class="item-title">永德小区 31平米130万 房东忍痛割肉 你还在等什么？</p>
                                <p class="item-info"><span class="item-price">130万</span><span class="item-info-sub">1室1厅，31平米</span>
                                </p>
                            </a>
                        </li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="footer" class="footer">
    <ul class="links">
        <li><a rel="nofollow" href="#">关于安居客</a></li>
        <!--        <li><a rel="nofollow" href="http://biz.anjuke.com/">渠道招商</a></li>-->
        <li><a rel="nofollow" href="#">联系我们</a></li>
        <li><a rel="nofollow" href="#">用户协议</a></li>
        <!-- <li><a rel="nofollow" href="https://hangzhou.anjuke.com/help">使用帮助</a></li> -->
        <li><a rel="nofollow" href="#">友情链接</a></li>
        <li><a href="javascript:void(0);" data-target="map_link">网站地图</a></li>
        <li><a rel="nofollow" href="javascript:;" data-target="other_city">其它城市</a></li>
        <li><a href="javascript:void(0);" data-target="house_link">最新房源</a></li>
        <li><a href="javascript:void(0);" data-target="community_link">小区大全</a></li>
        <li><a href="#">最新问答</a></li>
        <li><a href="#">房贷计算器</a></li>
        <li><a rel="nofollow" target="" href="#">放心搜</a></li>
        <li><a rel="nofollow" target="" href="#">推广服务</a></li>
    </ul>
    <p>
        <a href="#" target="">客户服务中心</a>&nbsp;&nbsp;&nbsp;&nbsp;
        客服电话： 672092(宁波ＸＸ学院短号)
        邮箱：<a href="#" target="" rel="nofollow">qjk123@126.com</a>&nbsp;&nbsp;&nbsp;
        Copyright © 2007-2017 www.anjuke.com All Rights Reserved <a href="#" rel="nofollow">ICP号：沪&nbsp;B2-20090008</a>
    </p>
</div>

<div class="dialog">
    <!-- 退出登录对话框 -->
    <div class="quit-content">
        是否要退出安居客帐号？
    </div>
    <div class="dialog-btn quit-btn">
        <a onclick="checkLogout()"><button class="sure">确定
        </button></a><button class="cancel">取消</button>
    </div>

    <div class="dialog-btn modify-name-btn">
        <button class="sure">确定</button>
        <button class="cancel">取消</button>
    </div>
</div>
</body>
</html>

<script type="text/javascript" src="/ajhouse/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/ajhouse/js/bbv10.js"></script>

<script type="text/javascript" src="/ajhouse/js/jquery-underscore.min.js"></script>
<script type="text/javascript" src="/ajhouse/js/Member_Web_User_Message.js"></script>
<script type="text/javascript">

    function checkLogout() {
        $.post(
            '${pageContext.request.contextPath}/portalLogout',
            function (data) {
                if (data == "success") {
                    location.href = "/ajhouse";
                }
            }
        );
    };

 //   $("#form1").submit(function()  {
    function updataUser() {
          var nickname = $("#nickname").val();
          var email = $("#email").val();
          var idcard = $("#idcard").val();
          var introduce = $("#introduce").val();
          var tal = $("#tal").val();
          var flag=true;
          if(nickname.length==0){
              $("#error1").html("昵称不能为空");
              flag=false;
          }
         if(email.length==0){
              $("#error1").html("邮箱不能为空");
              flag=false;
          }
          if(idcard.length==0){
              $("#error1").html("身份证不能为空");
              flag=false;
          }
          if(introduce.length==0){
              $("#error1").html("介绍不能为空")
              flag=false;
          }


        var reg=/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        if(!reg.test(email))
        {
            $("#error1").html("请输入有效的邮箱！");
            flag=false;
        }

        if(flag){
            $("#error1").html("")

        }

        if(flag){
          $("#error1").html(123);
          $.ajax({
              url: '${pageContext.request.contextPath}/updataUser',
              data:{"nickname":nickname,"email":email,"idcard":idcard,"introduce":introduce,"tal":tal},
              type: 'post',
              success: function (e) {
                 if(e==1){
                     location.href="${pageContext.request.contextPath}/toUserCenter";
                 }else if(e==2){
                      alert("请输入正确的数据");
                 }else {
                     alert("修改失败");
                 }
              },
              error:function() {
                alert("服务错误");
              }
          });
        }
    }
 //  });


    $(function () {
        var tal=${sessionScope.ajUser.tel}+"";
        if((tal)==null || tal==""){
            alert("亲，请先登入哟");
            location.href="/ajhouse";
        }
        var time_1 = new Date();
        var hour = time_1.getHours();

        if (6 > parseInt(hour)) {
            $("#time").html("凌晨")
        }
        else if (9 > hour) {
            $("#time").html("早上")
        }
        else if (12 > hour) {
            $("#time").html("上午")
        }
        else if (14 > hour) {
            $("#time").html("中午")
        }
        else if (17 > hour) {
            $("#time").html("下午")
        }
        else if (19 > hour) {
            $("#time").html("傍晚")
        }
        else if (22 > hour) {
            $("#time").html("晚上")
        }
        else {
            $("#time").html("夜里")
        }
    })


</script>