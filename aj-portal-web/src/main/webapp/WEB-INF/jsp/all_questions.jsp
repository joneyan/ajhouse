<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

	<head>
		<style>
			* {
				padding: 0;
				margin: 0;
			}
			/*
			 	外面盒子样式---自己定义
			 	分页插件的样式
			 */
			.page_div {
				margin-top: 20px;
				margin-bottom: 20px;
				font-size: 15px;
				font-family: "microsoft yahei";
				color: #666666;
				margin-right: 10px;
				padding-left: 20px;
				box-sizing: border-box;
			}
			/*
			 * 页数按钮样式
			 */

			.page_div a {
				min-width: 30px;
				height: 28px;
				border: 1px solid #dce0e0!important;
				text-align: center;
				margin: 0 4px;
				cursor: pointer;
				line-height: 28px;
				color: #666666;
				font-size: 13px;
				display: inline-block;
			}

			#firstPage,
			#lastPage {
				width: 50px;
				color: #0073A9;
				border: 1px solid #0073A9!important;
			}

			#prePage,
			#nextPage {
				width: 70px;
				color: #0073A9;
				border: 1px solid #0073A9!important;
			}

			.page_div .current {
				background-color: #0073A9;
				border-color: #0073A9;
				color: #FFFFFF;
			}

			.totalPages {
				margin: 0 10px;
			}

			.totalPages span,
			.totalSize span {
				color: #0073A9;
				margin: 0 5px;
			}
		</style>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<meta http-equiv="Content-language" content="zh-CN" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="applicable-device" content="pc">
		<link rel="alternate" media="only screen and (max-width: 640px)" href="">
		<meta name="mobile-agent" content="format=html5;url=">
		
		<title>杭州相关问题搜索_杭州问题解答(乐安居)</title>
		<%--<meta name="description" content="杭州链家网房产相关问题搜索结果，展示与相关的房地产行业相关问题与回答的信息" />
		<meta name="keywords" content="杭州相关问题，杭州问题搜索" />--%>
		<%--页面标签上的小图标--%>
		<link href="https://hz.lianjia.com/favicon.ico" type="/images/x-icon" rel=icon>
		<link href="https://hz.lianjia.com/favicon.ico" type="/images/x-icon" rel="shortcut icon">

		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/allquestions.css">

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/paging.js"></script>

	</head>

	<body>

		<jsp:include page="header1.jsp" />
		<%--<header class="lianjia-header">
		</header>--%>

		<!-- 面包屑模块 -->
		<div class="intro clear" mod-id="lj-common-bread">
			<div class="container">
				<div class="fl l-txt"><i class="icon"></i>&nbsp;
					<a href="#">乐安居杭州站</a><span class="stp">&nbsp;&gt;&nbsp;</span>
					<a href="${pageContext.request.contextPath}/wenda/rs/pg1/">杭州房产问答</a>
					<h1 class="index_h1">杭州全部问题</h1>
				</div>
				<div class="fr r-txt"></div>
			</div>
		</div>
		<!-- NAV头部搜索模块 -->
		<div class="wrapper">

			<div class="fl" style="width:745px;">
				<div class="search">
					<div class="tex">
							<input type="text" placeholder="房产知识有疑问？来搜搜吧~" id="tex" name="quesTitle" value="${requestScope.quesTitle}" >
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
				<div class="searchpage">
					<div class="titile">
						<div>搜索内容：
							<span class="key">${requestScope.quesTitle}</span>
							<span class="ristyle fr">为您找到<span class="key">${requestScope.pageBean.totalCount}</span>个问题</span>
						</div>
					</div>
					<div class="list">
						<ul>
							<c:forEach items="${pageBean.list}" var="question" >
								<li>
									<div class="leftlist fl">
										<a href="${pageContext.request.contextPath}/wenda/xiangqing/${question.id}.html" target="_blank;">
											<p class="question">${question.quesTitle}</p>
										</a>
										<!-- <p class="answer" title="您好，链家易荣平很高兴为您服务！您在杭州限购查档范围内无其他住房的情况下购房仍然算首套房，但是由于您在江苏还有一套房贷款在还，所以您首付需要6成以上。感谢您的提问，望采纳！">您好，链家易荣平很高兴为您服务！您在杭州限购查档范围内无其他住房的情况下购房仍然算首套房，但是由于您在江苏还有一套房贷款在还，所以您首...</p> -->
										<%--<p class="answer" title="您好，链家易荣平很高兴为您服务！您在杭州限购查档范围内无其他住房的情况下购房仍然算首套房，但是由于您在江苏还有一套房贷款在还，所以您首...">您好，链家易荣平很高兴为您服务！您在杭州限购查档范围内无其他住房的情况下购房仍然算首套房，但是由于您在江苏还有一套...</p>--%>
										<div class="mintips"><span><fmt:formatDate value="${question.createtime}" pattern="yyyy-MM-dd"/></span></div>

									</div>
									<div class="rightlist fr">
										<div class="roundright">
											<div style="padding:12px;">
												<p class="striking">${question.answersNum}</p>
												<p class="text">个回答</p>
											</div>
										</div>
									</div>
									<div class="clear"></div>
								</li>
							</c:forEach>

						</ul>
						<%--<div class="page-box ans-lst-page-box" comp-module="page" page-url="/wenda/rs/pg{page}" page-data="{&quot;totalPage&quot;:139,&quot;curPage&quot;:1}">
							<a class="on" href="https://hz.lianjia.com/wenda/rs/" data-page="1">1</a>
							<a href="https://hz.lianjia.com/wenda/rs/pg2" data-page="2">2</a>
							<a href="https://hz.lianjia.com/wenda/rs/pg3" data-page="3">3</a>
							<span>...</span>
							<a href="https://hz.lianjia.com/wenda/rs/pg139" data-page="139">139</a>
							<a href="https://hz.lianjia.com/wenda/rs/pg2" data-page="2">下一页</a>
						</div>--%>
						<div id="page" class="page_div"></div>
					</div>
				</div>
			</div>

			<div class="fr">
				<!-- 相关顾问 -->
				<div class="column">
					<div class="title">相关顾问推荐</div>
					<ul>
						<li>
							<div class="agentInfo">
								<a href="http://dianpu.lianjia.com/1000000020138966/">
									<img src="${pageContext.request.contextPath}/picture/wenda/e4444d72-ea31-4553-b073-6328d59596c6.jpg.100x100.jpg" alt="">
								</a>
								<div class="change">
									<a class="askto" href="/wenda/tiwen?special_for=1000000020138966" data-name="吴曙东" target="_blank">向TA提问</a>
									<span class="jingjiren-name">吴曙东</span>
								</div>

								<p title="姓名：吴曙东 职业：房地产经纪人  年龄：23  本人经历：本人今年加入链家房地产经纪公司从事二手房经纪工作.主要负责下沙沿江南、沿江北的房源与全杭州的新房楼盘。从业期间一直秉持专业、快速、诚信的服务理念，熟悉杭州下沙每个角落，挖掘优质的房源和谈判是我的强项。如果您有买卖房需求，请您联系我，我会用热忱的服务、真诚的心，为您筑造温暖、幸福的家！我将尽全力为您提供购房建议，解答二手房交易相关问题.">姓名：吴曙东 职业：房地产经纪人 年龄：23 本人经历：本人今年加入链家房地产经纪公司从事二手房经纪工作.主要负责下沙沿江南、沿江北的房源与全杭州的新房楼盘。从业期间一直秉持专业、快速、诚信的服务理念，熟悉杭州下沙每个角落，挖掘优质的房源和谈判是我的强项。如果您有买卖房需求，请您联系我，我会用热忱的服务、真诚的心，为您筑造温暖、幸福的家！我将尽全力为您提供购房建议，解答二手房交易相关问题.</p>
								<p class="info">已回答109个问题</p>
								<p>
									<span class="tag">擅长买房</span>
									<span class="tag">擅长交易</span>
								</p>
							</div>
						</li>
						<li>
							<div class="agentInfo">
								<a href="http://dianpu.lianjia.com/1000000020187526/">
									<img src="${pageContext.request.contextPath}/picture/wenda/548ca761-3672-49d4-b74a-0b84752dd36b.jpg.100x100.jpg" alt="">
								</a>
								<div class="change">
									<a class="askto" href="/wenda/tiwen?special_for=1000000020187526" data-name="龙亮星" target="_blank">向TA提问</a>
									<span class="jingjiren-name">龙亮星</span>
								</div>

								<p title="很荣幸在迷茫的时候踏入了链家这个平台，虽然步入行业时间不长，但我会用100%真心对待每一个顾客，一定会竭尽全力为客户寻找一个温馨的家,让您找到舒适满意的房子！本人所负责的区域主要是竟舟、古荡这一块，古荡新村、雅仕苑及周边的楼盘本人都熟悉，像嘉绿苑，文新，古墩等那边的房子都熟悉，也负责杭州大部分的一手楼盘，如有需要也可以联系我，我一定耐心的为您解答，诚恳热情、工作认真是我服务宗旨。真房源，如你所见！">很荣幸在迷茫的时候踏入了链家这个平台，虽然步入行业时间不长，但我会用100%真心对待每一个顾客，一定会竭尽全力为客户寻找一个温馨的家,让您找到舒适满意的房子！本人所负责的区域主要是竟舟、古荡这一块，古荡新村、雅仕苑及周边的楼盘本人都熟悉，像嘉绿苑，文新，古墩等那边的房子都熟悉，也负责杭州大部分的一手楼盘，如有需要也可以联系我，我一定耐心的为您解答，诚恳热情、工作认真是我服务宗旨。真房源，如你所见！</p>
								<p class="info">已回答74个问题</p>
								<p>
									<span class="tag">擅长买房</span>
									<span class="tag">擅长交易</span>
								</p>
							</div>
						</li>
						<li>
							<div class="agentInfo">
								<a href="http://dianpu.lianjia.com/1000000020144458/">
									<img src="${pageContext.request.contextPath}/picture/wenda/b297fb86-1022-4d3a-b74f-01c125dde032.jpg.100x100.jpg" alt="">
								</a>
								<div class="change">
									<a class="askto" href="/wenda/tiwen?special_for=1000000020144458" data-name="周美媛" target="_blank">向TA提问</a>
									<span class="jingjiren-name">周美媛</span>
								</div>

								<p title="本人从事二手房行业已经八年多了，期间为几百个客户找到了属于自己的温馨港湾，对房屋交易流程、贷款购房政策等了如指掌，期间公司的博学考试也获得了三等奖。希望我的专业能够对你有所帮助！">本人从事二手房行业已经八年多了，期间为几百个客户找到了属于自己的温馨港湾，对房屋交易流程、贷款购房政策等了如指掌，期间公司的博学考试也获得了三等奖。希望我的专业能够对你有所帮助！</p>
								<p class="info">已回答37个问题</p>
								<p>
									<span class="tag">擅长买房</span>
									<span class="tag">擅长交易</span>
								</p>
							</div>
						</li>
						<li>
							<div class="agentInfo">
								<a href="http://dianpu.lianjia.com/1000000020095631/">
									<img src="${pageContext.request.contextPath}/picture/wenda/3a415712-b970-4a9d-b72f-e52afd30ab91.jpg.100x100.jpg" alt="">
								</a>
								<div class="change">
									<a class="askto" href="/wenda/tiwen?special_for=1000000020095631" data-name="华传玲" target="_blank">向TA提问</a>
									<span class="jingjiren-name">华传玲</span>
								</div>

								<p title="我是一名90后，大学本科毕业后即进入该行业，目前从事二手房买卖事宜近3年，对生活和工作充满热情。现在主做二手房买卖和新楼盘代理的工作。我只希望服务好每一位客户，以朋友的关系相处。把我的专业知识传达给每一位客户。现在主营红石板、米市巷、文一街、文三街、学军、行知十三中。">我是一名90后，大学本科毕业后即进入该行业，目前从事二手房买卖事宜近3年，对生活和工作充满热情。现在主做二手房买卖和新楼盘代理的工作。我只希望服务好每一位客户，以朋友的关系相处。把我的专业知识传达给每一位客户。现在主营红石板、米市巷、文一街、文三街、学军、行知十三中。</p>
								<p class="info">已回答119个问题</p>
								<p>
									<span class="tag">擅长买房</span>
									<span class="tag">擅长交易</span>
								</p>
							</div>
						</li>
						<li>
							<div class="agentInfo">
								<a href="http://dianpu.lianjia.com/1000000020063069/">
									<img src="${pageContext.request.contextPath}/picture/wenda/4da56152-6541-4b3d-a5b5-1afde9f32983.jpg.100x100.jpg" alt="">
								</a>
								<div class="change">
									<a class="askto" href="/wenda/tiwen?special_for=1000000020063069" data-name="钱梦潮" target="_blank">向TA提问</a>
									<span class="jingjiren-name">钱梦潮</span>
								</div>

								<p title="本人在链家做了一年的租赁和三年的买卖，现在是一名店经理，专业性强，对于房产知识、税费计算、流程、按揭贷款、相关法律知识等问题基本上是可以解答的，我专业，期待能帮更多业主客户解惑！">本人在链家做了一年的租赁和三年的买卖，现在是一名店经理，专业性强，对于房产知识、税费计算、流程、按揭贷款、相关法律知识等问题基本上是可以解答的，我专业，期待能帮更多业主客户解惑！</p>
								<p class="info">已回答85个问题</p>
								<p>
									<span class="tag">擅长买房</span>
									<span class="tag">擅长卖房</span>
								</p>
							</div>
						</li>
					</ul>
				</div>
			</div>

			<div class="clear"></div>

		</div>
	</body>
	<footer>
		<jsp:include page="footer.jsp" />
		<%--<div class="footer">...</div>--%>
	</footer>


	<script>
        var num = ${requestScope.pageBean.currentPage}+"";
        //var pg = 1;
        if(num == ""||num == null){
            num = 1;
        }

        //分页
        $("#page").paging({
            pageNo:num,
            totalPage: ${requestScope.pageBean.totalPage},
            totalSize: ${requestScope.pageBean.totalCount},
            callback: function(n) {
                //var tex = $("#tex").val();
                window.location.href="${pageContext.request.contextPath}/wenda/rs${requestScope.quesTitle}/pg"+n+"/";
            }
        })
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
</html>




