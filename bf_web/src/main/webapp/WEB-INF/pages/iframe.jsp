<%--
  Created by IntelliJ IDEA.
  User: lohas
  Date: 2015/7/16
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/include/includeTag.jsp" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link href="<%=contextPath%>/static/css/mobile/mobile-2.0.css" rel="stylesheet">
    <style>
        html, body {
            width: 100%;
            margin: 0;
            padding: 0;
            position: absolute;
            top: 0;
            bottom: 0;
            -webkit-text-size-adjust: 100%;
            -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
            overflow-x: hidden;
        }

        .scroll-wrapper {
            width: 100%;
            position: relative;
            -webkit-overflow-scrolling: touch;
            overflow: auto;
        }

        #contentFrame {
            width: 100%;
            margin: 0;
            padding: 0;
            border: 0;
            position: absolute;
            top: 0;
            bottom: 0;
            height: 100%;
        }

        .fixBottom{
            position: fixed;
            z-index: 999;
            bottom: 0;
        }
        .fixTop{
            position: fixed;
            z-index: 999;
            top: 0px;
            width: 100%;
        }
        .fixTop1{
            height: 0px;   /** IOS 窗体 头部高度 **/
            width: 100%;
            background: #19b379;
        }
    </style>
</head>
<body>
<div  class="fixTop">
    <div class="fixTop1" style="display: none"></div>
    <div id="fixTop"></div>
</div>
<div class="scroll-wrapper">
    <iframe id="contentFrame" name="contentFrame" frameborder="0" src="${ctx}/${src}"></iframe>
</div>
<div id="fixBottom" class="fixBottom"></div>
<script src="<%=contextPath%>/static/amaze/js/jquery.min.js"></script>
<script>

    window.browser = {
        versions: function () {
            var u = navigator.userAgent, app = navigator.appVersion;
            return {
                trident: u.indexOf('Trident') > -1, //IE内核
                presto: u.indexOf('Presto') > -1, //opera内核
                webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
                gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,//火狐内核
                mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
                ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或者uc浏览器
                iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
                iPad: u.indexOf('iPad') > -1, //是否iPad
                webApp: u.indexOf('Safari') == -1, //是否web应该程序，没有头部与底部
                weixin: u.indexOf('MicroMessenger') > -1, //是否微信 （2015-01-22新增）
                qq: u.match(/\sQQ/i) == " qq" //是否QQ
            };
        }(),
        language: (navigator.browserLanguage || navigator.language).toLowerCase()
    };
    function appendBottom(html){
        var $html = $(html);
        $html.find("a").each(function(){
            $(this).attr("data-href",$(this).attr("href"));
            $(this).removeAttr("href");
        });
        $("#fixBottom").html($html);
    }
    function appendTop(html){
        var $html = $(html);
        $("#fixTop").html($html);
        $html.find("a").each(function(a,b){
            var $self = $(b);
            if($self.attr("href")&&$self.attr("href")!=""&&$self.attr("href").indexOf("javascript")==-1) {
                $self.attr("href","javascript:window.parent.goTo('"+$self.attr("href")+"');");
            }
        });
    }


    function goTo(url){
        $("#contentFrame").attr("src",url);
    }


    jQuery(function($){
        $("body,.scroll-wrapper").height($(window).height());
        var eventName = (browser.versions.mobile) ? "touchstart" : "click";
        $("body").on(eventName,'.footer-menu-item',function(){
            var href = $(this).attr("data-href");
            $("#contentFrame").attr("src",href);
        });
        // 设置 app
        localStorage.setItem("app","${app}");

        if(window.browser.versions.ios){
            $(".fixTop1").show();
        }
    });
</script>
</body>
</html>
