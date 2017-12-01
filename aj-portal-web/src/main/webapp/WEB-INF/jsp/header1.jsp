<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div id="header1">
    	<div class="lianjia-header">
			<div class="nav-wrap">
				<div class="wrapper ">
					<div class="fl">
						<a class="logo" href="http://localhost:8081/ajhouse" title="链家房产网">
							<!-- <img src="picture/logo.png"> --></a>
					</div>
					<div class="fr nav  ">
						<div class="fl">
							<ul>
								<li>
									<a class="" href="https://hz.lianjia.com/ershoufang/">二手房</a>
								</li>
								<li>
									<a class="" href="https://hz.fang.lianjia.com/">新房</a>
								</li>
								<li>
									<a class="" href="https://hz.lianjia.com/zufang/">租房</a>
								</li>
								<li>
									<a class="" href="https://us.lianjia.com">海外</a>
								</li>
								<li>
									<a class="" href="https://hz.lianjia.com/xiaoqu/">小区</a>
								</li>
								<li>
									<a class="" href="https://hz.lianjia.com/jingjiren/">经纪人</a>
								</li>
								<li class="hover">
									<a class="" href="${pageContext.request.contextPath}/wenda/rs/pg1/">
										问答
									</a>
								</li>
								<li>
									<a class="" href="https://hz.lianjia.com/fangjia/">房价</a>
								</li>
								<li>
									<a class="" href="https://hz.lianjia.com/tool.html" target="_blank">工具</a>
								</li>
								<li>
									<a class="" href="https://hz.lianjia.com/yezhu/" target="_blank">业主</a>
								</li>
							</ul>
						</div>
						<div class="fr login">
							<c:if test="${sessionScope.ajUser==null}">
								<a style="cursor: pointer" onclick="createCode()" class="btn-login bounceIn actLoginBtn" data-toggle="modal" data-target="#myLogin1">
									<span class="reg">登录</span></a>
								<a style="cursor: pointer" onclick="createCode()" class="btn-register" data-toggle="modal" data-target="#myRegester">
									<span class="log">立即注册</span></a>
							</c:if>
							<c:if test="${sessionScope.ajUser!=null}">
								<c:if test="${sessionScope.ajUser.nickname==null}">
									<a href="toUserCenter" class="btn-register">${sessionScope.ajUser.tel}</a>
									<a style="cursor: pointer" class="btn-register" onclick="checkLogout()" >注销</a>
								</c:if>
								<c:if test="${sessionScope.ajUser.nickname!=null}">
									<a href="toUserCenter" class="btn-register">${sessionScope.ajUser.nickname}</a>
									<a style="cursor: pointer" class="btn-register" onclick="checkLogout()" >注销</a>
								</c:if>
							</c:if>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<script>

    //用户注销
    function checkLogout() {
        $.post(
            '${pageContext.request.contextPath}/portalLogout',
            function (data) {
                if(data=="success"){
                    location.href="http://localhost:8081/ajhouse/";
                }
            }
        );
    }
</script>