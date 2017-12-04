<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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
    <link rel="alternate" media="only screen and (max-width: 640px)" href="https://m.lianjia.com/hz/ershoufang/rs/">
    <meta name="mobile-agent" content="format=html5;url=https://m.lianjia.com/hz/ershoufang/rs/">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <!-- 2017.11.8 市场需求加上新的统计 -->
    <!-- 2017.7.18 开放全国 -->
    <title>【杭州二手房_杭州二手房出售_杭州二手房网】(杭州链家网)</title>
    <meta name="description" content="链家杭州二手房网,现有杭州二手房真实房源9236套.为准备买杭州二手房的用户提供杭州地图找房、通勤找房等快捷找房工具,方便您更快捷的了解和购买杭州二手房.买杭州二手房就到杭州链家网." />
    <meta name="keywords" content="杭州二手房,杭州二手房出售,杭州二手房网" />
    <link href="/favicon.ico" type="image/x-icon" rel=icon>
    <link href="/favicon.ico" type="image/x-icon" rel="shortcut icon">
    <link rel="stylesheet" href="https://s1.ljcdn.com/feroot/pc/asset/common.css?_v=20171123190132">
    <link rel="stylesheet" href="https://s1.ljcdn.com/feroot/pc/asset/ershoufang/sellList/index.css?_v=20171123190132">
    <div class="banner">
        <div class="container">
            <ul class="channelList">
                <li>
                    <a href="//www.lianjia.com/">首页</a>
                </li>
                <li class="selected">
                    <a href="https://hz.lianjia.com/ershoufang/">二手房</a>
                </li>
                <li class="">
                    <a href="https://hz.fang.lianjia.com/">新房</a>
                </li>
                <li class="">
                    <a href="https://hz.lianjia.com/zufang/">租房</a>
                </li>
                <li rel="nofollow" class="">
                    <a href="http://you.lianjia.com/">旅居</a>
                </li>
                <li class="">
                    <a href="https://us.lianjia.com">海外</a>
                </li>
                <li class="">
                    <a href="https://hz.lianjia.com/xiaoqu/">小区</a>
                </li>
                <li class="">
                    <a href="https://hz.lianjia.com/jingjiren/">经纪人</a>
                </li>
                <li class="">
                    <a href="https://hz.lianjia.com/wenda/">指南</a>
                    <div class="childList">
                        <a href="https://hz.lianjia.com/wenda/">问答</a>
                        <a href="https://news.lianjia.com/hz/baike/">百科</a>
                    </div>
                </li>
                <li class="">
                    <a href="https://hz.lianjia.com/fangjia/">房价</a>
                </li>
                <li class="">
                    <a href="https://hz.lianjia.com/tool.html" target="_blank">工具</a>
                </li>
                <li class="">
                    <a href="https://hz.lianjia.com/yezhu/" target="_blank">业主</a>
                </li>
            </ul>
            <div class="banner-right">
                <div class="login" id="userInfoContainer"><i></i>
                    <a href="https://upassport.lianjia.com/login?service=https%3A%2F%2Fwww.lianjia.com%2Fuser%2Fchecklogin%3Fredirect%3Dhttps%253A%252F%252Fhz.lianjia.com%252Fershoufang%252Frs%252F" id="loginBtn" rel="nofollow">登录</a>/
                    <a href="https://passport.lianjia.com/register/resources/lianjia/register.html?service=https%3A%2F%2Fwww.lianjia.com%2Fuser%2Fchecklogin%3Fredirect%3Dhttps%253A%252F%252Fhz.lianjia.com%252Fershoufang%252Frs%252F" id="registerBtn" rel="nofollow">注册</a>
                </div>
                <div class="phone"><i></i><span>热线电话1010-9666</span></div>
            </div>
        </div>
    </div>

    <script type="text/template" id="userInfoTpl">
        <span id="tipContainer"></span> &nbsp;&nbsp;
        <a href="">退出</a>
        <span id="pushNewsListContainer"></span>
    </script>

    <div class="header">
        <div class="menu">
            <div class="menuLeft">
                <a href="/ershoufang/" class="logo"></a>
                <ul class="typeList">
                    <li class="selected">
                        <a href="/ershoufang/" title="杭州在售二手房">在售</a>
                    </li>
                    <li>
                        <a href="/chengjiao/" title="杭州成交二手房">成交</a>
                    </li>
                    <li>
                        <a href="/xiaoqu/" title="杭州小区二手房">小区</a>
                    </li>
                    <li>
                        <a href="/fangjia/" title="杭州房价二手房">房价</a>
                    </li>
                </ul>
            </div>
            <div class="app">
                <a href="//www.lianjia.com/client/" target="_blank"><i></i>下载链家APP<span class="layer-qrcode"><span class="icon-qrcode"><img width="124" height="124" src="//ajax.api.lianjia.com/qr/getDownloadQr?location=menu_app&ljweb_channel_key=ershoufang_search" alt="下载链家app"></span><span class="txt">使用链家APP</span><span class="sub-txt">随时随地查看新上房源</span></span>
                </a>
            </div>
        </div>
        <div class="search clear">
            <div class="box">
                <div class="clear searchBox">
                    <input class="text left txt searchVal" name="keyword" autocomplete="off" value="${query}" id="keyword-box">
                    <input class="btn home-ico ico-search left" id="findHouse" type="button" value="开始找房" daty-id="330100" onclick="search()">
                </div>
            </div>
        </div>
    </div>
    <div class="m-filter">
        <div class="position">
            <dl>
                <h2><dt title="杭州在售位置">位置</dt></h2>
                <dd>
                    <a href="/ershoufang/" id="areaTab" class="selected" title="杭州二手房">
                        区域<span class="arrow"></span>
                    </a>
                    <a href="/ditiefang/" id="subwayTab" title="杭州地铁找房">
                        地铁线<span class="arrow"></span>
                    </a>
                </dd>
            </dl>
            <dl>
                <dt></dt>
                <dd>
                    <!-- 区域 -->
                    <div data-role="ershoufang">
                        <div>
                            <a href="/ershoufang/xihu/" title="杭州西湖在售二手房 ">西湖</a>
                            <a href="/ershoufang/xiacheng/" title="杭州下城在售二手房 ">下城</a>
                            <a href="/ershoufang/jianggan/" title="杭州江干在售二手房 ">江干</a>
                            <a href="/ershoufang/gongshu/" title="杭州拱墅在售二手房 ">拱墅</a>
                            <a href="/ershoufang/shangcheng/" title="杭州上城在售二手房 ">上城</a>
                            <a href="/ershoufang/binjiang/" title="杭州滨江在售二手房 ">滨江</a>
                            <a href="/ershoufang/yuhang/" title="杭州余杭在售二手房 ">余杭</a>
                            <a href="/ershoufang/xiaoshan/" title="杭州萧山在售二手房 ">萧山</a>
                            <a href="/ershoufang/xiasha/" title="杭州下沙在售二手房 ">下沙</a>
                        </div>
                    </div>
                    <!-- 地铁 -->
                    <div data-role="ditiefang" style="display:none;">
                        <div>
                            <a href="/ditiefang/li110460707/" title="杭州1号线在售二手房 ">1号线</a>
                            <a href="/ditiefang/li189500791680395/" title="杭州2号线在售二手房 ">2号线</a>
                            <a href="/ditiefang/li189503468170337/" title="杭州4号线在售二手房 ">4号线</a>
                        </div>
                    </div>
                    <!-- 学区 -->
                </dd>
            </dl>
        </div>

        <div class="list-more">
            <dl class=" hasmore">
                <h2><dt title="杭州售价在售二手房">售价</dt></h2>
                <dd>
                    <a href="/ershoufang/p1/" class="" rel="nofollow" >
                        <span class="checkbox "></span>
                        <span class="name">100万以下</span>
                    </a>
                    <a href="/ershoufang/p2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">100-150万</span>
                    </a>
                    <a href="/ershoufang/p3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">150-200万</span>
                    </a>
                    <a href="/ershoufang/p4/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">200-300万</span>
                    </a>
                    <a href="/ershoufang/p5/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">300-500万</span>
                    </a>
                    <a href="/ershoufang/p6/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">500万以上</span>
                    </a>
                    <span class="customFilter mt" data-role="price">
                <input type="text" role="minValue" value="">
                <span>-</span>
						<input type="text" role="maxValue" value="">&nbsp;
						<span>万</span>
						<button class="btn-range hide" data-url="/ershoufang/bp{min}ep{max}/">确定</button>
						</span>
                    <span class="btn-showmore">+ 更多及自定义</span>
                </dd>
            </dl>
            <dl class=" hasmore">
                <h2><dt title="杭州面积在售二手房">面积</dt></h2>
                <dd>
                    <a href="/ershoufang/a1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">50平以下</span>
                        <span class="cnt">(952)</span>
                    </a>
                    <a href="/ershoufang/a2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">50-70平</span>
                        <span class="cnt">(1516)</span>
                    </a>
                    <a href="/ershoufang/a3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">70-90平</span>
                        <span class="cnt">(2435)</span>
                    </a>
                    <a href="/ershoufang/a4/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">90-120平</span>
                        <span class="cnt">(1335)</span>
                    </a>
                    <a href="/ershoufang/a5/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">120-140平</span>
                        <span class="cnt">(1362)</span>
                    </a>
                    <a href="/ershoufang/a6/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">140-160平</span>
                        <span class="cnt">(525)</span>
                    </a>
                    <a href="/ershoufang/a7/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">160-200平</span>
                        <span class="cnt">(596)</span>
                    </a>
                    <a href="/ershoufang/a8/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">200平以上</span>
                        <span class="cnt">(515)</span>
                    </a>
                    <span class="customFilter mt" data-role="area">
                <input type="text" role="minValue" value="">
                <span>-</span>
						<input type="text" role="maxValue" value="">&nbsp;
						<span>平</span>
						<button class="btn-range hide" data-url="/ershoufang/ba{min}ea{max}/">确定</button>
						</span>
                    <span class="btn-showmore">+ 更多及自定义</span>
                </dd>
            </dl>
            <dl class=" ">
                <h2><dt title="杭州房型在售二手房">房型</dt></h2>
                <dd>
                    <a href="/ershoufang/l1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">一室</span>
                        <span class="cnt">(1114)</span>
                    </a>
                    <a href="/ershoufang/l2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">二室</span>
                        <span class="cnt">(2872)</span>
                    </a>
                    <a href="/ershoufang/l3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">三室</span>
                        <span class="cnt">(3650)</span>
                    </a>
                    <a href="/ershoufang/l4/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">四室</span>
                        <span class="cnt">(1109)</span>
                    </a>
                    <a href="/ershoufang/l5/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">四室以上</span>
                        <span class="cnt">(490)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide " data-role="hide-row">
                <h2><dt title="杭州用途在售二手房">用途</dt></h2>
                <dd>
                    <a href="/ershoufang/sf1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">普通住宅</span>
                        <span class="cnt">(8232)</span>
                    </a>
                    <a href="/ershoufang/sf2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">商业类</span>
                        <span class="cnt">(816)</span>
                    </a>
                    <a href="/ershoufang/sf3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">别墅</span>
                        <span class="cnt">(184)</span>
                    </a>
                    <a href="javascript:;" class="nolink" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">四合院</span>
                    </a>
                    <a href="/ershoufang/sf5/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">其他</span>
                        <span class="cnt">(4)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide " data-role="hide-row">
                <h2><dt title="杭州权属在售二手房">权属</dt></h2>
                <dd>
                    <a href="/ershoufang/dp1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">商品房</span>
                        <span class="cnt">(8077)</span>
                    </a>
                    <a href="/ershoufang/dp2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">公房</span>
                        <span class="cnt">(944)</span>
                    </a>
                    <a href="/ershoufang/dp3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">经适房</span>
                        <span class="cnt">(196)</span>
                    </a>
                    <a href="/ershoufang/dp4/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">其他</span>
                        <span class="cnt">(19)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide " data-role="hide-row">
                <h2><dt title="杭州楼层在售二手房">楼层</dt></h2>
                <dd>
                    <a href="/ershoufang/lc1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">低楼层</span>
                        <span class="cnt">(2906)</span>
                    </a>
                    <a href="/ershoufang/lc2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">中楼层</span>
                        <span class="cnt">(3124)</span>
                    </a>
                    <a href="/ershoufang/lc3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">高楼层</span>
                        <span class="cnt">(3206)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide " data-role="hide-row">
                <h2><dt title="杭州朝向在售二手房">朝向</dt></h2>
                <dd>
                    <a href="/ershoufang/f1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">朝东</span>
                        <span class="cnt">(606)</span>
                    </a>
                    <a href="/ershoufang/f2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">朝南</span>
                        <span class="cnt">(8594)</span>
                    </a>
                    <a href="/ershoufang/f3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">朝西</span>
                        <span class="cnt">(486)</span>
                    </a>
                    <a href="/ershoufang/f4/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">朝北</span>
                        <span class="cnt">(3004)</span>
                    </a>
                    <a href="/ershoufang/f5/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">南北</span>
                        <span class="cnt">(2676)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide " data-role="hide-row">
                <h2><dt title="杭州楼龄在售二手房">楼龄</dt></h2>
                <dd>
                    <a href="/ershoufang/y1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">5年以内</span>
                        <span class="cnt">(2219)</span>
                    </a>
                    <a href="/ershoufang/y2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">10年以内</span>
                        <span class="cnt">(4444)</span>
                    </a>
                    <a href="/ershoufang/y3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">15年以内</span>
                        <span class="cnt">(5862)</span>
                    </a>
                    <a href="/ershoufang/y4/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">20年以内</span>
                        <span class="cnt">(7296)</span>
                    </a>
                    <a href="/ershoufang/y5/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">20年以上</span>
                        <span class="cnt">(1273)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide " data-role="hide-row">
                <h2><dt title="杭州类型在售二手房">类型</dt></h2>
                <dd>
                    <a href="/ershoufang/bt1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">塔楼</span>
                        <span class="cnt">(947)</span>
                    </a>
                    <a href="/ershoufang/bt2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">板楼</span>
                        <span class="cnt">(7260)</span>
                    </a>
                    <a href="/ershoufang/bt3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">板塔结合</span>
                        <span class="cnt">(634)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide " data-role="hide-row">
                <h2><dt title="杭州电梯在售二手房">电梯</dt></h2>
                <dd>
                    <a href="/ershoufang/ie2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">有电梯</span>
                        <span class="cnt">(4189)</span>
                    </a>
                    <a href="/ershoufang/ie1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">无电梯</span>
                        <span class="cnt">(2798)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide " data-role="hide-row">
                <h2><dt title="杭州装修在售二手房">装修</dt></h2>
                <dd>
                    <a href="/ershoufang/de1/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">精装修</span>
                        <span class="cnt">(4302)</span>
                    </a>
                    <a href="/ershoufang/de2/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">普通装修</span>
                        <span class="cnt">(3165)</span>
                    </a>
                    <a href="/ershoufang/de3/" class="" rel="nofollow">
                        <span class="checkbox "></span>
                        <span class="name">毛坯房</span>
                        <span class="cnt">(1219)</span>
                    </a>
                </dd>
            </dl>
            <dl class="hide otherItem" data-role="hide-row">
                <dt class="other">其他</dt>
                <dd>
                    <form id="otherSearchForm">
                        <input class="inp-search" type="text" value="" placeholder="在结果中搜索">
                        <button type="submit" class="btn-search">确定</button>
                    </form>
                </dd>
            </dl>
        </div>
        <div class="more btn-more">更多选项<span class="arrow"></span></div>
    </div>
    <div class="content ">
        <!-- 左侧内容 -->
        <div class="leftContent">
            <div class="orderFilter">
                <div class="orderTag">
                    <ul>
                        <li class='selected'>
                            <h3><a href="/ershoufang/">默认排序</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/co32/">最新</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/co21/">总价</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/co41/">房屋单价</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/co11/">面积</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/co52/">带看较多</a></h3></li>
                    </ul>
                </div>
                <div class="filterAgain">
                    <div class="title">筛选：</div>
                    <ul>
                        <li>
                            <h3><a href="/ershoufang/ty1/"><span class="checkbox"></span>满两年</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/mw1/"><span class="checkbox"></span>满五年</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/fh1/"><span class="checkbox"></span>优选</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/tt2/"><span class="checkbox"></span>新上</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/tt4/"><span class="checkbox"></span>随时看房<div class="info"><i></i><div class="infoContent min-wid">经纪人持有该房源钥匙，您可以随时预约看房</div></div></a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/hu1/"><span class="checkbox"></span>不看商业类</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/nb1/"><span class="checkbox"></span>不看地下室</a></h3></li>
                        <li>
                            <h3><a href="/ershoufang/ng1/"><span class="checkbox"></span>不看车位</a></h3></li>
                    </ul>
                </div>
            </div>
            <div class="resultDes clear">
                <h2 class="total fl">共找到<span>${recourdCount}</span>套杭州二手房</h2>
                <div class="button fr">
                    <div class="clearBtn hide">
                        <script>
                            with(document) write('<a href="/ershoufang/"><span></span>清空条件</a>');
                        </script>
                    </div>
                </div>
            </div>
            <div id="newAddHouseContainer"></div>
            <div class="listContentLine"></div>
                <c:forEach items="${itemList}" var="list">
                    <ul class="sellListContent" log-mod="list">
                    <li class="clear">
                        <a class="img " href="http://101.132.176.163/house/${list.id}.html" target="_blank" data-log_index="1" data-el="ershoufang" data-housecode="103101712103" data-is_focus="" data-sl=""><img class="lj-lazy" src="${list.image}" data-original="https://image1.ljcdn.com/330100-inspection/5597e23d-fd32-47b5-9dea-15c8ecdacd86.jpg.280x210.jpg.232x174.jpg" alt="${list.title}"></a>
                        <div class="info clear">
                            <div class="title">
                                <a class="" href="http://101.132.176.163/house/${list.id}.html" target="_blank" data-log_index="1" data-el="ershoufang" data-housecode="103101712103" data-is_focus="" data-sl="">${list.title}</a>
                            </div>
                            <div class="address">
                                <div class="houseInfo"><span class="houseIcon"></span>
                                    <a href="https://hz.lianjia.com/xiaoqu/1811043636850/" target="_blank" data-log_index="1" data-el="region">${list.address} </a> | 3室2厅 | 87.59平米 | 南 | 毛坯 | 有电梯</div>
                            </div>
                            <div class="flood">
                                <div class="positionInfo"><span class="positionIcon"></span>低楼层(共18层)2010年建板楼 -
                                    <a href="https://hz.lianjia.com/ershoufang/qiaoxi1/" target="_blank">桥西</a>
                                </div>
                            </div>
                            <div class="followInfo"><span class="starIcon"></span>22人关注 / 共46次带看 / 2个月以前发布</div>
                            <div class="tag"><span class="taxfree">房本满五年</span><span class="haskey">随时看房</span></div>
                            <div class="priceInfo">
                                <div class="totalPrice"><span>${list.priceRange}</span></div>
                            </div>
                        </div>
                        <div class="listButtonContainer">
                            <div class="btn-follow followBtn" data-hid="103101712103"><span class="follow-text">关注</span></div>
                            <div class="compareBtn LOGCLICK" data-hid="103101712103" log-mod="103101712103" data-log_evtid="10230">加入对比</div>
                        </div>
                    </li>
                </c:forEach>

            <!-- 无搜索结果 -->
            <div id="noResultPush"></div>
            <div class="contentBottom clear">
                <div class="crumbs fl">
                    <a href="/">链家网杭州站</a><span>&nbsp;&gt;&nbsp;</span>
                    <h1><a href="/ershoufang/">杭州二手房</a></h1></div>
                <div class="page-box fr">
                    <div class="page-box house-lst-page-box" comp-module='page' page-url="/ershoufang/pg{page}/" page-data='{"totalPage":100,"curPage":1}'></div>

                </div>
            </div>
        </div>
        <!-- 右侧sidebar -->
        <div class="rightLayout">
            <div class="rightContent">
                <div class="download">
                    <div class="title">下载链家APP</div>
                    <div class="qr-code"><img width="94" height="94" src="/images/getDownloadQr.png" alt="下载链家app">
                        <div class="text">
                            <p>扫描上方二维码</p>
                            <p>随时查看新房源</p>
                            <p class="get-more">
                                <a href="//www.lianjia.com/client">了解更多<img width="9" height="9" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgBAMAAACBVGfHAAAAGFBMVEUAAACcn6Gfn5+an5+bnqCbnqGfn5+cn6EV6DbuAAAAB3RSTlMA0BAw8LAgvf5k9AAAAEdJREFUKM9jIBOkBqMJhBcqoAmUC6EKmJSjKWEWR1eiiK6ECZsSA3QlzuhKSihRghDA0EJ/BWIoCgzh4YMIZALRYBrMQAkAAF5bGMBkrwzqAAAAAElFTkSuQmCC"></a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="clear:both"></div>
    </div>
    <div class="footer">
        <div class="wrapper">
            <div class="f-title">
                <div class="fl">
                    <ul>
                        <li>
                            <a href="https://www.lianjia.com/zhuanti/home/" rel="nofollow" target="_blank">了解链家</a>
                        </li>
                        <li>
                            <a href="https://hz.lianjia.com/about/aboutlianjia/" rel="nofollow" target="_blank">关于链家</a>
                        </li>
                        <li>
                            <a href="https://hz.lianjia.com/about/contactus/" rel="nofollow" target="_blank">联系我们</a>
                        </li>
                        <li>
                            <a href="https://join.lianjia.com/" rel="nofollow" target="_blank">加入我们</a>
                        </li>
                        <li>
                            <a href="https://www.lianjia.com/privacy/" rel="nofollow" target="_blank">隐私声明</a>
                        </li>
                        <li>
                            <a href="https://hz.lianjia.com/sitemap/" target="_blank">网站地图</a>
                        </li>
                        <li>
                            <a href="https://www.lianjia.com/notice/7.html" rel="nofollow" target="_blank">友情链接</a>
                        </li>
                        <li>
                            <a href="https://agent.lianjia.com/" rel="nofollow" target="_blank">经纪人登录</a>
                        </li>
                    </ul>
                </div>
                <div class="fr">官方客服 1010 9666</div>
            </div>
            <div class="lianjia-link-box">
                <div class="fl">
                    <div class="tab"><span class="hover">城市二手房</span><span>房产资讯</span><span>城区二手房</span><span>城区租房</span><span>城区小区</span><span>热门小区</span><span>热门问答</span><span>热门百科</span></div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="bottom">
                <div class="copyright fl">链家网（北京）科技有限公司 | 网络经营许可证 京ICP备16057509号-2 | © Copyright©2010-2017 链家网Lianjia.com版权所有</div>
                <div style="width:300px;color: #888c8e;font-size: 12px;line-height: 20px;">
                    <a target="_blank" href="http://www.beian.gov.cn/portal/registerSystemInfo?recordcode=11010802024019" style="display:inline-block;text-decoration:none;height:20px;line-height:20px;"><img src="/images/beian.png" style="float:left;"><p style="float:left;height:20px;line-height:20px;margin: 0px 0px 0px 5px;color: #888c8e; ">京公网安备 11010802024019号</p></a></div></div></div></div>


</html>
<script>
    function search() {

        var keyword = $("#keyword-box").val();
        location.href="/ajhouse/searchHouse/rs"+keyword+"/pg1";
    }

    $("#keyword-box").keydown(function (e) {
        var theEvent = window.event || e;
        var code = theEvent.keyCode || theEvent.which;
        if (code==13) {  //回车键的键值为13
            var keyword = $("#keyword-box").val();
            location.href="/ajhouse/searchHouse/rs"+keyword+"/pg1";
        }

    });
</script>