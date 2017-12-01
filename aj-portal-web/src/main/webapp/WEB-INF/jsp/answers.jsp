<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
		<link rel="alternate" media="only screen and (max-width: 640px)" href="https://m.lianjia.com/hz/wenda/xiangqing/236247.html">
		<meta name="mobile-agent" content="format=html5;url=https://m.lianjia.com/hz/wenda/xiangqing/236247.html">

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>


		<title>${question.quesTitle}(乐安居)</title>
		<meta name="description" content="你好，我在江苏省有房，还贷中，在杭州买房首付咨询您好，链家常阔很高兴为您服务。因为您目前在江苏有房且在还贷中（有购房贷款记录看全国），即使您在杭州没有房子，(在您有杭州市购房的资质的前提下)您在杭州买房子被认定为二套，首付六成利率上浮10％。链接供您参考感谢您的提问，希望我的回答可以帮到您，祝您生活愉快，链家常阔。&amp;nbsp;" />
		<meta name="keywords" content="贷款,首付月供" />
		<%--页面标签上的小图标--%>
		<link href="https://hz.lianjia.com/favicon.ico" type="/images/x-icon" rel=icon>
		<link href="https://hz.lianjia.com/favicon.ico" type="/images/x-icon" rel="shortcut icon">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/answersHD.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/answersZT.css">

		<style type="text/css">
			.content {
				height: 100%;
			}
		</style>

		<style type="text/css">
			.fl-box .title {
				font-size: 18px;
				padding: 20px 0;
				border-bottom: 1px solid #e4e4e4;
				font-weight: 700
			}
			
			.fl-box .btn-more {
				position: absolute;
				top: 20px;
				right: 0;
				color: #999;
				line-height: 28px
			}
			
			.fl-box .btn-more:hover {
				text-decoration: none
			}
			
			.fl-box .box-list li {
				padding-top: 10px;
				line-height: 20px;
				border-bottom: 1px solid #eeeeee;
				padding-bottom: 13px
			}
			
			.fl-box .box-list li a {
				display: block;
				font-size: 14px;
				color: #333;
				word-wrap: break-word
			}
			
			.fl-box .box-list li a:hover {
				text-decoration: none
			}
			
			.fl-box .box-list li i {
				background: #f1f1f1;
				color: #9f9f9f;
				font-size: .65em;
				display: inline-block;
				padding: 0 6px;
				margin-top: 12px
			}
			
			.fl-box .box-list li.li-last {
				border-bottom: 0;
				padding-bottom: 0
			}
		</style>
		
	</head>

	<body>
	
		
		<jsp:include page="header1.jsp" />
		<!--<header class="lianjia-header">
			
		</header>-->
		
		<!-- 面包屑模块 -->
		<div class="intro clear" mod-id="lj-common-bread">
			<div class="container">
				<div class="fl l-txt"><i class="icon"></i>&nbsp;
					<a href="#">乐安居杭州站</a><span class="stp">&nbsp;&gt;&nbsp;</span>
					<a href="${pageContext.request.contextPath}/wenda/rs/pg1/">杭州房产问答</a><span class="stp">&nbsp;&gt;&nbsp;</span>当前问题

				<div class="fr r-txt"></div>
			</div>
		</div>
		<!-- NAV头部搜索模块 -->
		<div class="wrapper">
			<div class="fl" style="width:745px;">
				<div class="search">
					<div class="tex">
						<input type="text" placeholder="房产知识有疑问？来搜搜吧~" name="quesTitle" id="tex">
						<div class="suglist hotsug">
							<ul class="ul01">

							</ul>
						</div>
						<div class="sub" data-dianji="find_qustion" id="find_qustion">找答案</div>
						<i></i>
					</div>
					<div class="go">
						<a href="${pageContext.request.contextPath}/wenda/tiwen" target="_blank" data-dianji="find_ask"><i></i>去提问</a>
					</div>
					<div class="clear"></div>
				</div>
				<div class='l-container'>
					<div class='q-desc'>
						<span class="triangle-right"></span>
						<h1>${question.quesTitle}</h1>
						<p class='quer'><span>提问者：${question.tel}</span>&nbsp;
							<span>时间：<fmt:formatDate value="${question.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></span> &nbsp;
							<%--<span>所属分类：
                      			<a href="/wenda/liebiao/a5/">贷款</a>
             -                   <a href="/wenda/liebiao/b5002/">首付月供</a>
							</span>--%>
						</p>
						<p class='q-info'>
							<span class="triangle-up"></span>${question.quesContent}
						</p>
						<p class='q-action'>
							<a href="#"><span class='notice-focus' data-id="236247" data-status="0" data-url="/wenda/guanzhu?question_id=236247" data-dianji="find_$236247"></span></a>
							<span style="display: none">
            分享到：
            <a class="jiathis_button_qzone"><i class="kongjian"></i></a>
            <a class="jiathis_button_weixin"><i class="weixin"></i></a>
            <a class="jiathis_button_cqq"><i class="cqq"></i></a>
            <a class="jiathis_button_tqq"><i class="qq"></i></a>
            <a class="jiathis_button_tsina"><i class="xinlang"></i></a>
            <a class="jiathis_button_renren"><i class="renren"></i></a>
          </span>
							<!-- <i class="alert"></i>此为举报该问题前面的小图标 -->
							<a href="//www.lianjia.com/notice/4.html" target="_blank"><span class='tip'>免责说明</span></a>
						</p>
					</div>
					<!-- 编辑器 -->
					<div class="editwrapper">
						<!--style给定宽度可以影响编辑器的最终宽度-->
						<div class="loading ntEditorLoading">编辑器加载中...</div>
						<script type="text/plain" id="myEditor"></script>
						<div class="submitcol">
							<span class="actSubmit">提交</span>
							<span class="actClose">取消</span>
						</div>
					</div>
					<div class='solve-list'>
						<div class='top'>
							<span>共有&nbsp;<span class="num">${question.answersNum}</span>&nbsp;个回答</span>
							<p class="sort" data-type="0">
								<%--<span class='default'>默认排序</span>--%>
								<span class='newest'>采用状况</span>
							</p>
						</div>
						<ul>
							<c:forEach items="${question.answerList}" var="answer" >
							<li class="solve-listli">
								<div class='li-l'>
									<a href="${pageContext.request.contextPath}/${answer.ajUser.photo}" target="_blank;">
										<img src="${answer.ajUser.photo}">
									</a>
								</div>
								<div class='li-r'>
									<p class='solver-info'>
										<a href="#" target="_blank;">
											<span class='name'>${answer.ajUser.nickname}</span>
										</a>
										<span class='bordered'>擅长交易</span>
										<span class='bordered'>擅长卖房</span>
										<a class="lianjiaim-createtalk" title="在线咨询" data-role="lianjiaim-createtalk" data-ucid="1000000020251065"></a>
										<span class="agent-mobile"><i></i>${answer.ajUser.tel}</span>
									</p>
									<p class='attitude'>
										<a class='btn-ding' href="javascript:;" data-id="23" answer-id="232589">
											<i></i>
											<span class="ding">${answer.status}</span>
										</a>
									</p>
									<p class='time'><fmt:formatDate value="${answer.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></p>

									<div class='content lj_editor_view'>
											${answer.ansContent}
										<%--<p>您好，链家常阔很高兴为您服务。</p>
										<p>因为您目前在江苏有房且在还贷中（有购房贷款记录看全国），即使您在杭州没有房子，(在您有杭州市购房的资质的前提下)您在杭州买房子被认定为二套，首付六成利率上浮10％。</p>
										<p>感谢您的提问，希望我的回答可以帮到您，祝您生活愉快，链家常阔。&nbsp;</p>--%>
									</div>
								</div>
							</li>
							</c:forEach>

						</ul>
						<div class="page-box ans-lst-page-box" comp-module='page' page-url="/wenda/xiangqing/236247/pg{page}" page-data='{"totalPage":1,"curPage":1}'></div>
					</div>
					<div class="suggest_question">
						<p class="title">看了又看</p>
						<div>
							<ul class="clear">
								<li>
									<a href="/wenda/xiangqing/230880.html" class="question_item" data-index="1" target="_blank">
										<span class="question_title">我是宁波的，现在户口在河南了。在杭州买房需要什么条件</span>
										<span class="bottom_info clear"><em class="time">2017-05-05</em><em class="num">7个回答</em></span>
									</a>
								</li>
								<li>
									<a href="/wenda/xiangqing/232731.html" class="question_item" data-index="2" target="_blank">
										<span class="question_title">你好，外省有贷款买房，现已结清，在杭州算首套吗</span>
										<span class="bottom_info clear"><em class="time">2017-05-22</em><em class="num">5个回答</em></span>
									</a>
								</li>
								<li>
									<a href="/wenda/xiangqing/236964.html" class="question_item" data-index="3" target="_blank">
										<span class="question_title">一套未还清；二套纯商业贷款首付比例多少？如果是组合又是多少</span>
										<span class="bottom_info clear"><em class="time">2017-07-06</em><em class="num">6个回答</em></span>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="fr">
				<!-- 相关小区 -->
				<!-- 相关问答 -->
				<div class="column" style="padding-bottom:6px;">
					<div class="title">相关问题</div>
					<ul>
						<li class="secondcol">
							<div>
								<a href="/wenda/xiangqing/243581.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">
									<p title="你好，现在杭州买房首付几成">你好，现在杭州买房首付几成
									</p>
								</a>
								<div class="mintips">
									<span>2017-08-31</span>
									<span class="fr">
                  <a href="/wenda/xiangqing/243581.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">1个回答</a>
                </span>
								</div>
							</div>
						</li>
						<li class="secondcol">
							<div>
								<a href="/wenda/xiangqing/245806.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">
									<p title="你好想问杭州户口无房，单身。买二手房需要首付6成吗">你好想问杭州户口无房，单身。买二手房需要首付6成吗
									</p>
								</a>
								<div class="mintips">
									<span>2017-09-18</span>
									<span class="fr">
                  <a href="/wenda/xiangqing/245806.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">1个回答</a>
                </span>
								</div>
							</div>
						</li>
						<li class="secondcol">
							<div>
								<a href="/wenda/xiangqing/250397.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">
									<p title="你好我想咨询杭州买房，请给我电话15026875710">你好我想咨询杭州买房，请给我电话150268...
									</p>
								</a>
								<div class="mintips">
									<span>2017-11-01</span>
									<span class="fr">
                  <a href="/wenda/xiangqing/250397.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">1个回答</a>
                </span>
								</div>
							</div>
						</li>
						<li class="secondcol">
							<div>
								<a href="/wenda/xiangqing/150203.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">
									<p title="在外地有二套房贷，杭州无房，如果在杭州买房的首付是多少？">在外地有二套房贷，杭州无房，如果在杭州买房的...
									</p>
								</a>
								<div class="mintips">
									<span>2016-09-05</span>
									<span class="fr">
                  <a href="/wenda/xiangqing/150203.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">1个回答</a>
                </span>
								</div>
							</div>
						</li>
						<li class="secondcol">
							<div>
								<a href="/wenda/xiangqing/249243.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">
									<p title="杭州户籍，外地两套，咨询购房首付比例">杭州户籍，外地两套，咨询购房首付比例
									</p>
								</a>
								<div class="mintips">
									<span>2017-10-22</span>
									<span class="fr">
                  <a href="/wenda/xiangqing/249243.html" class="LOGCLICK" target="_blank;" data-log_evtid="10611" log-mod="xiangguan_wenti">1个回答</a>
                </span>
								</div>
							</div>
						</li>
					</ul>
				</div>

				<!-- 最新问题 -->
				<div class="column newQuestion">
					<div class="fl-box">
						<h2 class="title">最新问题</h2>
						<a class="btn-more" href="/wenda/liebiao/a?sort=1">查看更多</a>
						<div class="box-list">
							<ul>
								<li class="">
									<span>
					<a class="LOGVIEW LOGCLICK" data-log_id="30001" data-bl="wenda" data-log_index="0" href="/wenda/xiangqing/252501.html" target="_blank">一套房纯公积金贷款。二套房的收入证明</a>
				</span>
									<i>昨天</i>
								</li>
								<li class="">
									<span>
					<a class="LOGVIEW LOGCLICK" data-log_id="30001" data-bl="wenda" data-log_index="1" href="/wenda/xiangqing/252466.html" target="_blank">30%还是60%</a>
				</span>
									<i>昨天</i>
								</li>
								<li class="">
									<span>
					<a class="LOGVIEW LOGCLICK" data-log_id="30001" data-bl="wenda" data-log_index="2" href="/wenda/xiangqing/252257.html" target="_blank">现在杭州有什么地方可以三成首付</a>
				</span>
									<i>2017-11-19</i>
								</li>
								<li class="">
									<span>
					<a class="LOGVIEW LOGCLICK" data-log_id="30001" data-bl="wenda" data-log_index="3" href="/wenda/xiangqing/252088.html" target="_blank">杭州首套房资格问题</a>
				</span>
									<i>2017-11-17</i>
								</li>
								<li class="li-last">
									<span>
					<a class="LOGVIEW LOGCLICK" data-log_id="30001" data-bl="wenda" data-log_index="4" href="/wenda/xiangqing/251598.html" target="_blank">收入证明不够月供的两倍</a>
				</span>
									<i>2017-11-13</i>
								</li>
							</ul>
						</div>
					</div>

				</div>
			</div>

			<div style="clear:both;"></div>

		</div>

		<jsp:include page="footer.jsp" />
		<%--<div class="footer">...</div>--%>


			<script>
                //找答案
                $("#find_qustion").click(function () {
                    var tex = $("#tex").val();
                    window.location.href="${pageContext.request.contextPath}/wenda/rs" + tex + "/pg1/";
                });
                $("#tex").keydown(function (e) {
                    var theEvent = window.event || e;
                    var code = theEvent.keyCode || theEvent.which;
                    if (code==13) {  //回车键的键值为13
                        var tex = $("#tex").val();
                        window.location.href="${pageContext.request.contextPath}/wenda/rs" + tex + "/pg1/";
                    }
                });
			</script>
