<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/common.css">
	<link rel="stylesheet" href="css/lianjiaim.css">
	<link rel="stylesheet" href="css/main.css">

	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 手机快捷登录模态框（Modal） -->
<div class="modal fade" id="myLogin1" style="margin-top: 10%;overflow: hidden" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" style="width: 380px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h1 style="font-size:20px;font-weight:900;margin-left:5%" class="modal-title" style="margin-left:5% ">
					手机快捷登录
				</h1>
				<br>
				<h6 style="margin-left: 5%;">别担心，无账号自动注册不会导致手机号被泄露</h6>
			</div>
			<div class="modal-body">
				<form id="myForm1">

					<input type="text" id="tel1" class="form-control" style="margin-left: 5%; margin-top: 5%; width: 300px;  height:50px " placeholder="请输入手机号">

					<input type="text" id="code1" class="form-control" style="margin-left: 5%;  display:inline-block; margin-top: 5%; width: 180px;  height:50px " placeholder="请输入验证码">

					<input type="text" id="messageCode1" class="form-control" style="margin-left: 5%; display:inline-block; margin-top: 5%; width: 180px;  height:50px " placeholder="请输入短信验证码">

					<a style="float: right;margin: 10% 40px 0 0;cursor: pointer" class="getMessageCode">获取验证码</a>

					<p id="span1" style="margin-left: 5%;  margin-top: 5%;"></p>

					<input type="submit" class="btn btn-primary btn-lg" style="margin-left: 20%;  margin-top: 5%; width: 200px" value="登录">

				</form>
				<a href=""  style="margin-left: 5%;" data-toggle="modal" data-dismiss="modal" data-target="#myLogin2">账号密码登录</a>

			</div>


		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>



<!-- 账号登录模态框（Modal） -->
<div class="modal fade" id="myLogin2" style="margin-top: 10%" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 380px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h1 style="font-size:20px;font-weight:900;margin-left:5%" class="modal-title" style="margin-left:5% ">
					账号登录
				</h1>
				<br>
			</div>
			<div class="modal-body">
				<form id="myForm2">

					<input type="text" class="form-control" style="margin-left: 5%; margin-top: 5%; width: 300px;  height:50px " placeholder="请输入手机号">

					<input type="text" class="form-control" style="margin-left: 5%;  margin-top: 5%; width: 300px;  height:50px " placeholder="请输入验证码">

					<input type="text" class="form-control" style="margin-left: 5%;  margin-top: 5%; width: 300px;  height:50px " placeholder="请输入短信验证码">

					<button class="btn btn-primary btn-lg" style="margin-left: 20%;  margin-top: 5%; width: 200px" data-toggle="modal" data-target="#myModal">
						登录
					</button>
				</form>
				<a href=""  style="margin-left: 5%;" data-toggle="modal" data-dismiss="modal" data-target="#myLogin1">手机快捷登录</a>
			</div>


		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>


<!-- 注册模态框（Modal） -->
<div class="modal fade" id="myRegester" style="margin-top: 10%" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 380px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h1 style="font-size:20px;font-weight:900;margin-left:5%" class="modal-title" style="margin-left:5% ">
					手机号码注册
				</h1>
			</div>
			<div class="modal-body">
				<form id="myForm3">

					<input type="text" id="tel3" class="form-control" style="margin-left: 5%; margin-top: 5%; width: 300px;  height:50px " placeholder="请输入手机号">

					<input type="text" id="code3" class="form-control" style="margin-left: 5%;  display:inline-block; margin-top: 5%; width: 180px;  height:50px " placeholder="请输入验证码">

					<input type="text" id="messageCode3" class="form-control" style="margin-left: 5%; display:inline-block; margin-top: 5%; width: 180px;  height:50px " placeholder="请输入短信验证码">

					<div id="ms" style="float: right;margin: 10% 40px 0 0;cursor: pointer">
						<a  class="getMessageCode">获取验证码</a>
					</div>

					<input type="password" id="password3" class="form-control" style="margin-left: 5%;  margin-top: 5%; width: 300px;  height:50px " placeholder="请输入密码(最少8位,数字+字母)">

					<p id="span3" style="margin-left: 5%;margin-top: 5%;"></p>

					<button class="btn btn-primary btn-lg" style="margin-left: 20%;  margin-top: 5%; width: 200px" data-toggle="modal" data-target="#myModal">
						注册
					</button>
				</form>
				<a href=""  style="margin-left: 5%;" data-toggle="modal" data-dismiss="modal" data-target="#myLogin1">已有账号？点我登录</a>
			</div>


		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>



		<title>杭州二手房_杭州房产网_杭州房价_租房（杭州链家网）</title>

		<div class="header" data-stellar-background-ratio="0.07">
			<div class="wrapper">
				<div class="fl">
					<a href="#" title="链家网" class="logo" target="_self">
						<h1 class="index_h1">链家网</h1></a><span class="exchange"><i></i>杭州</span></div>
				<div class="fr">
					<div class="nav typeUserInfo">
						<div class="ti-hover">
							<div class="typeShowUser "><i></i>
								<span class="welcome">
									<c:if test="${sessionScope.ajUser==null}">
										<a style="cursor: pointer" class="btn-login bounceIn actLoginBtn" data-toggle="modal" data-target="#myLogin1">
										<span class="reg">登录</span></a>
										<a style="cursor: pointer" class="btn-register" data-toggle="modal" data-target="#myRegester">
										<span class="log">立即注册</span></a>
									</c:if>
									<c:if test="${sessionScope.ajUser!=null}">
										<c:if test="${sessionScope.ajUser.nickname==null}">
											<a href="toUserCenter" class="btn-register">${sessionScope.ajUser.tel}</a>
										</c:if>
										<c:if test="${sessionScope.ajUser.nickname!=null}">
											<a href="toUserCenter" class="btn-register">${sessionScope.ajUser.nickname}</a>
											<a style="cursor: pointer" class="btn-register" onclick="checkLogout()" >退出</a>
										</c:if>
									</c:if>
								</span>
							</div>
						</div>
						<ul>
							<li>
								<a class="" href="#">二手房</a>
							</li>
							<li>
								<a class="" href="#">新房</a>
							</li>
							<li>
								<a class="" href="#">租房</a>
							</li>
							<li><img class="icon-lvju" src="picture/lvju.png">
								<a rel="nofollow" class="" href="#">旅居</a>
							</li>
							<li>
								<a class="" href="#">海外</a>
							</li>
							<li>
								<a class="" href="#">小区</a>
							</li>
							<li>
								<a class="" href="#">经纪人</a>
							</li>
							<li class="hover">
								<a class="" href="#">指南</a>
								<div class="nav-list">
									<dd><i></i>
										<dl>
											<a href="#">问答</a>
										</dl>
										<dl>
											<a href="#">百科</a>
										</dl>
									</dd>
								</div>
							</li>
							<li>
								<a class="" href="#">房价</a>
							</li>
							<li>
								<a class="" href="#" target="_blank">工具</a>
							</li>
							<li class="real"><i></i>
								<a class="" href="#" target="_blank">业主</a>
							</li>
						</ul>
					</div>
				</div>
				
				<div class="clear"></div>
				<div class="header-wrap">
					<div class="wrap-ico"></div>
					<div class="house-num">
						<ul>
							<li>杭州链家真实在售二手房 8938 套</li>
							<li>杭州链家真实租房 5437 套</li>
							<li>杭州链家在售新房楼盘 420 个</li>
						</ul>
					</div>
					<div class="search-box-wrap" log-mod="search">
						<div class="search-box-con">
							<div class="menu">
								<ul>
									<li class="tab check" actData="channel=ershoufang" data-type="试试输入地铁线/站在地铁附近找房，如 1号线" formact="/ershoufang/rs"><span>找二手房</span></li>
									<li class="tab " actData="channel=xinfang" data-type="请输入楼盘名称开始找房" formact="/loupan/rs"><span>找新房</span></li>
									<li class="tab " actData="channel=zufang" data-type="请输入区域、商圈或小区名开始找房" formact="/zufang/rs"><span>找租房</span></li>
									<li class="tab " actData="channel=xiaoqu" data-type="请输入小区名开始查找小区" formact="/xiaoqu/rs"><span>找小区</span></li>
									<li class="tab " actData="channel=wenda" data-type="房产知识有疑问？来搜搜吧~" formact="/wenda/rs"><span>搜问答</span></li>
								</ul><i></i></div>
							
							<!--全文检索 -->
							<div class="search clear">
								<div class="box">
									<div class="clear searchBox" data-action='/ershoufang/rs'>
									<input class="text left txt searchVal" name="keyword" autocomplete="off" placeholder="试试输入地铁线/站在地铁附近找房，如 1号线" id="keyword-box">
									<input class="btn home-ico ico-search left" id="findHouse" type="button" value="开始找房" daty-id="330100">
									</div>
								</div>	
							</div>
						</div>
					</div>
				</div>
				<div class="wrap-video">
					<div class="pen">
						<a href="#" rel="nofollow"><img src="picture/php3x11mp.png">关于仿冒我公司进行不正当竞争行为的郑重声明</a>
					</div>
					<div class="pen">
						<a href="#" rel="nofollow"><img src="picture/phpapdvem.png">房地产中介诚信服务承诺及保证书</a>
					</div>
				</div>
			</div>
		</div>
		<div class="home-nav">
			<ul class="count-4">
				<li class="hvr-bob">
					<a href="/ershoufang/"><img src="picture/phpe022we.png"><b>找二手房</b>
						<p>真实二手房源，链家承诺真实在售所见即真</p>
					</a>
				</li>
				<li class="hvr-bob">
					<a href="/xinfang/"><img src="picture/php6ifmls.png"><b>找新房</b>
						<p>全新房屋，全新生活，给您满意的优质新盘</p>
					</a>
				</li>
				<li class="hvr-bob">
					<a href="/ditu/"><img src="picture/php4ttmto.png"><b>地图找房</b>
						<p>为您精准定位，位置周边配套设施一览无余</p>
					</a>
				</li>
				<li class="hvr-bob">
					<a href="/ditiefang/"><img src="picture/phpdvthdc1456382078.png"><b>找地铁房</b>
						<p>房源紧邻地铁站，交通出行更方便说走就走</p>
					</a>
				</li>
			</ul>
		</div>
		<div class="hand-lianjia">
			<div class="wrapper">
				<div class="fl">
					<div class="titles"></div>
					<p>集二手、新房、租房功能于一体，随时随地任性找房。IM匿名咨询让您放心，消息动态推送让您省心，服务承诺让您安心，数据百科锦囊让您感受贴心漫漫找房路，我们努力为您想更多。</p>
					<div class="download">
						<div class="hand-app">
							<a href="#" class="ios" target="_blank" rel="nofollow"></a>
							<a href="#" class="android" rel="nofollow"></a>
						</div>
						<div class="erweima" style="background: none;"><img style="width: 100%;" src="picture/6b52260606554942add756f1c0664877.gif"></div>
						<div class="video-img-btn" style="display:none;">
							<div class="video-img-btn-bg"></div>
							<div class="video-btn-normal"></div>
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="fr phone"></div>
			</div>
		</div>
		
		
		
		
		<div class="new-house">
			<div class="wrapper">
				<div class="fl">
					<div class="name"></div>
					<p>真实信息准确同步，楼盘动态一手掌握
						<a href="#" target="_blank">更多杭州新房</a>
					</p>
				</div>
				
				<div class="newhose-list">
	                <ul>
                                            <li>
                            <a href="#">
                                <img src="https://image1.ljcdn.com/xf-resblock/b55bdafb-5351-45b4-b12e-ee9c338f56e6.jpg.510x300.jpg" alt="正黄金域世家">
                                <div class="bg"></div>
                                                                <div class="price">
                                    <div>
                                        <span>全款9.5折  贷款9.8折</span>
                                    </div>
                                </div>
                                                               <div class="title">
                                    正黄金域世家
                                    <span>
                                                                            <label>12500</label>元/平
                                                                        </span>
                                </div>
                               <div class="title01"><span title="硖仲路499号">硖仲路499号</span>
                                / 94平米-120平米</div> </a>
                        </li>
                                            <li>
                            <a href="#">
                                <img src="https://image1.ljcdn.com/xf-resblock/d606757e-eebb-453f-b1bc-5861245afb63.jpg.510x300.jpg" alt="蓝钻天成">
                                <div class="bg"></div>
                                                                <div class="title">
                                    蓝钻天成
                                    <span>
                                                                            <label>35000</label>元/平
                                                                        </span>
                                </div>
                               <div class="title01"><span title="莫干山路969号">莫干山路969号</span>
                                / 78平米-78平米</div> </a>
                        </li>
                                            <li>
                            <a href="#">
                                <img src="https://image1.ljcdn.com/xf-resblock/3776b625-4d82-43c9-baae-fb6728b76e6e.JPG.510x300.jpg" alt="阳光郡">
                                <div class="bg"></div>
                                                                <div class="title">
                                    阳光郡
                                    <span>
                                                                            <label>29000</label>元/平
                                                                        </span>
                                </div>
                               <div class="title01"><span title="拱墅莫干山路与长青路（广业街）交界处">拱墅莫干山路与长青路（广业街）交界处</span>
                                / 178平米-178平米</div> </a>
                        </li>
                                    </ul>

				</div>
			</div>
		</div>

		<div class="footer">
			<div class="wrapper">
				<div class="f-title">
					<div class="fl">
						<ul>
							<li>
								<a href="#" rel="nofollow" target="_blank">了解链家</a>
							</li>
							<li>
								<a href="#" rel="nofollow" target="_blank">关于链家</a>
							</li>
							<li>
								<a href="#" rel="nofollow" target="_blank">联系我们</a>
							</li>
							<li>
								<a href="#" rel="nofollow" target="_blank">加入我们</a>
							</li>
							<li>
								<a href="#" rel="nofollow" target="_blank">隐私声明</a>
							</li>
							<li>
								<a href="#" target="_blank">网站地图</a>
							</li>
							<li>
								<a href="#" rel="nofollow" target="_blank">友情链接</a>
							</li>
							<li>
								<a href="#" rel="nofollow" target="_blank">经纪人登录</a>
							</li>
						</ul>
					</div>
					<div class="fr">官方客服 1010 9666</div>
				</div>
				<div class="lianjia-link-box">
					<div class="fl">
					<div class="tab">
						<span class="hover">城市二手房</span>
						<span>商圈二手房</span>
						<span>商圈租房</span>
						<span>商圈小区</span>
						<span>热门小区</span>
						<span>小区二手房</span>
						<span>小区租房</span>
						<span>新房</span>
						<span>百科</span>
						<span>租房</span>
						<span>小区</span>
						<span>问答</span>
						<span>房产专题</span>
						<span>合作与友情链接</span>
					</div>			
					</div>
					<div class="clear"></div>
				</div>

				<div class="bottom">
					<div class="copyright fl">链家网（北京）科技有限公司 | 网络经营许可证 京ICP备16057509号-2 | © Copyright©2010-2017 链家网Lianjia.com版权所有</div>
					<div style="width:300px;color: #888c8e;font-size: 12px;line-height: 20px;">
						<a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010802024019" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;">
							<img src="picture/beian.png"  style="float:left;">
							<p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px;color: #888c8e; ">京公网安备 11010802024019号</p>
						</a>
					</div>
				</div>
			</div>
		</div>
</body>
</html>

<script>

    var pattern = /^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/;
    var pwd_reg = /^[0-9a-zA-Z]{8,12}$/;
	//发送短信之前校验手机号
	$(".getMessageCode").click(function () {
        var tel = $("#tel1").val();
		if(pattern.test(tel)){
		    $.post(
                "getMessageCode/"+tel,
				function (data) {
					if(data=="success"){
					    alert("短信发送成功");
					}
                }
            )
		}else{
            $("#span1").html("请输入有效的手机号!").css("color","red");
            $("#tel1").focus();
		}
    });




	//手机快捷登录校验
    $("#myForm1").submit(function(a){
        var tel = $("#tel1").val();
        var code1 = $("#code1").val();
        var messageCode = $("#messageCode1").val();
        var flag = false;
        if(!pattern.test(tel)){
            $("#span1").html("请输入有效的手机号!").css("color","red");
            $("#tel1").focus();
        }else if(code1==""||code1.length!=4){
            $("#span1").html("请输入有效的验证码!").css("color","red");
            $("#code1").focus();
        }else if(messageCode==""||messageCode.length!=6){
            $("#span1").html("请输入有效的短信验证码!").css("color","red");
            $("#messageCode1").focus();
		}else{
            flag=true;
            $("#span1").html("");
		}
        a.preventDefault();
        if(flag){
            $.ajax({
                url:"portalLogin",
                data:{"tel":tel,"code":code1,"messageCode":messageCode},
                datatype:"json",
                type:"post",
                cache:false,
                success:function(data){
                    if(data=="1"){
                        $("#span1").html("验证码输入错误!").css("color","red");
                    }else if(data=="2"){
                        $("#span1").html("短信验证码输入错误!").css("color","red");
                    }else if(data=="0"){
                        alert("登录成功");
                        location.reload();
                    }
                },
                error:function(){
                    alert("服务器内部出现未知错误");
                }
            });
        }
    });





    //发送短信之前校验手机号
    $("#ms").click(function () {
        var tel = $("#tel3").val();
        if(pattern.test(tel)){
            $.post(
                "getMessageCode/"+tel,
                function (data) {
                    if(data=="success"){
                        alert("短信发送成功");
                    }
                }
            )
        }else{
            $("#span3").html("请输入有效的手机号!").css("color","red");
            $("#tel3").focus();
        }
    });


	//手机注册校验
    $("#myForm3").submit(function(c){
        var tel = $("#tel3").val();
        var pwd = $("#password3").val();
        var code = $("#code3").val();
        var messageCode = $("#messageCode3").val();
        var flag = false;
        if(!pattern.test(tel)){
            $("#span3").html("请输入有效的手机号!").css("color","red");
            $("#tel3").focus();
        }else if(code==""||code==null||code.length!=4){
            $("#span3").html("请输入有效验证码").css("color","red");
            $("#code3").focus();
        }else if(messageCode==""||messageCode==null||messageCode.length!=6){
            $("#span3").html("请输入有效短信验证码").css("color","red");
            $("#messageCode3").focus();
        }else if(!pwd_reg.test(pwd)){
            $("#span3").html("请输入正确格式密码").css("color","red");
            $("#password3").focus();
        }else {
            flag = true;
            $("#span3").html("");
        }
        c.preventDefault();
        if(flag){
            $.ajax({
                url:"portalLogin",
                data:{"tel":tel,"password":pwd,"code":code,"messageCode":messageCode},
                datatype:"json",
                type:"post",
                cache:false,
                success:function(data){
                    if(data=="1"){
                        $("#span3").html("验证码输入错误!").css("color","red");
                    }else if(data=="2"){
                        $("#span3").html("短信验证码输入错误!").css("color","red");
                    }else if(data=="0"){
                        alert("注册成功,直接登录");
                        location.reload();
                    }
                },
                error:function(){
                    alert("服务器内部出现未知错误");
                }
            });
		}
    });

    function checkLogout() {
        $.post(
            'portalLogout',
			function (data) {
				if(data=="success"){
				    location.reload();
				}
            }
        );
    }

</script>







