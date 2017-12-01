<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<meta http-equiv="Content-language" content="zh-CN" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="applicable-device" content="pc">
		<link rel="alternate" media="only screen and (max-width: 640px)" href="https://m.lianjia.com/hz/wenda/tiwen/">
		<meta name="mobile-agent" content="format=html5;url=https://m.lianjia.com/hz/wenda/tiwen/">

		
		<title>杭州房屋交易问题提问_杭州房产相关问题咨询(乐安居)</title>
		<meta name="description" content="杭州链家网房产问&gt;答频道杭州房屋交易相关问题提问成功，提出相关杭州房地产行业问题可以提供回答" />
		<meta name="keywords" content="杭州房产问题成功提问，杭州问题提交，杭州买房问题咨询成功" />
		<%--页面标签上的小图标--%>
		<link href="https://hz.lianjia.com/favicon.ico" type="/images/x-icon" rel=icon>
		<link href="https://hz.lianjia.com/favicon.ico" type="/images/x-icon" rel="shortcut icon">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
		<%--<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">--%>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/putquestion.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

		<jsp:include page="header1.jsp" />
		<!--<header class="lianjia-header">
		</header>-->
	</head>

	<body>
		
		<!-- 面包屑模块 -->
		<div class="intro clear" mod-id="lj-common-bread">
			<div class="container">
				<div class="fl l-txt"><i class="icon"></i>&nbsp;
					<a href="#">乐安居杭州站</a><span class="stp">&nbsp;&gt;&nbsp;</span>
					<a href="${pageContext.request.contextPath}/wenda/rs/pg1/">杭州房产问答</a><span class="stp">&nbsp;&gt;&nbsp;</span><span>杭州房产问答提问</span>
					<h1 class="index_h1">杭州房产问答提问</h1></div>
				<div class="fr r-txt"></div>
			</div>
		</div>
		<!-- NAV -->
		<div class="wrap-global">
			<div class="tiwen-panel clear">
				<div class="tiwen-box shadow" data-url="">
					<form method="post" id="form1" action="${pageContext.request.contextPath}/wenda/tiwen/success">
						<p class="title">发布提问</p>
						<div class="title-line"></div>
						<p class="title-small">一句话描述您的疑问<span class="title-note">（必填）</span></p>
						<div class="ques-word">
							<input id="question" maxlength="30" placeholder="" name="quesTitle"><span class="word-num" ></span>
						</div>
						<div class="m-sug" id="tpl-r-sug"></div>
						<p class="title-small">问题描述<span class="title-note">（选填）</span></p>
						<textarea class="ques-detail" placeholder="描述尽量详细，以便于顾问能够回答的更精准～" name="quesContent"></textarea>
						<%--<p class="duanxin"><span id="right" class="right-btn"></span>当有新回复时，我们将会通过您绑定的手机号进行短信提醒</p>--%>
						<!--当前登录的用户的id-->
						<input name="id" type="text" value="${sessionScope.ajUser.id}" hidden="hidden">

						<a style="display:block" class="commit-btn " id="putQuestion">提交</a>
					</form>
				</div>
				<div class="tips shadow">
					<p class="title">如何更有效的提出问题</p>
					<div class="title-line"></div>
					<ul>
						<li class="ll"><i class="one"></i><span>描述现象</span></li>
						<li class="lr"><i class="two"></i><span>不要加工</span></li>
						<li class="ll"><i class="three"></i><span>言简意赅</span></li>
						<li class="lr"><i class="four"></i><span>说明目的</span></li>
					</ul>
				</div>
			</div>
		</div>

		<jsp:include page="footer.jsp" />
		<%--<div class="footer">...</div>--%>
<script>
    $("#putQuestion").click(function () {
        //先判断必填项是否已经填写
        if($('#question').val()==''||$('#question').val()==null){
            alert("请输入您的问题！");
            return false;
		}
		//要判断用户是否登录，若登录了才能提交,否则进行登录
		if(${sessionScope.ajUser != null}){
        	//提交表单
        	$("#form1").submit();
        }else{
		    alert('请在首页登录');
            location.href='http://localhost:8081/ajhouse';
		}

    });
</script>