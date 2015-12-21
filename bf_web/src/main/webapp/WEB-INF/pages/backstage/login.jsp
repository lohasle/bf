<%--
  Created by IntelliJ IDEA.
  User: lohas
  Date: 2015/3/3
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/include/includeTag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>后台登录</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */
    .en-markup-crop-options {
        top: 18px !important;
        left: 50% !important;
        margin-left: -100px !important;
        width: 200px !important;
        border: 2px rgba(255, 255, 255, .38) solid !important;
        border-radius: 4px !important;
    }

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0px !important;
    }
    </style>
    <style type="text/css">
        .fancybox-margin {
            margin-right: 0px;
        }

        body {
            background: url(<%=contextPath%>/static/images/bg-login.jpg) !important;
        }

        #wrapper {
            position: relative;
            margin-bottom: 20px;
            padding-top: 100px;
        }
        .login-box {
            width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 0 5px rgba(0,0,0,.15);
        }
        .login-head{
            text-align: center;
            margin-top: 20px;
            color: #999999;
        }
        .login-head h1,p{
            margin-bottom: 0px;
        }
        .login-body {
            width: 390px;
            margin: 0 auto;
            padding: 30px;
        }
        .login-bot{
            text-align: center;
            color: #ffffff;
            margin-top: 10px;
        }
    </style>
    <link rel="stylesheet" href="<%=contextPath%>/static/amaze/css/amazeui.min.css"/>
</head>
<body data-gclp-initialized="true" data-gistbox-initialized="true">
<div id="wrapper">
    <div class="login-box">
        <div class="login-head">
            <h1 class="am-badge am-badge-warning am-text-xl am-round">JAVA基础开发平台&nbsp;V1.0</h1>

            <p>Login System | 登录系统</p>
        </div>
        <div class="login-body">
            <form onsubmit="return false" method="post" class="am-form" id="loginForm">
                <div class="am-input-group ">
                    <span class="am-input-group-label"><span class="am-icon-user am-icon-fw"></span></span>
                    <input name="username" id="userName" type="text" class="am-form-field" placeholder="用户名">
                </div>

                <div class="am-input-group am-margin-top-sm">
                    <span class="am-input-group-label"><span class="am-icon-lock am-icon-fw"></span></span>
                    <input name="password" id="password" type="password" class="am-form-field" placeholder="密　码">
                </div>
                <div class="am-input-group am-margin-top-sm">
                    <span class="am-input-group-label"><span class="am-icon-minus-circle am-icon-fw"></span></span>
                    <input name="verify" id="verify" type="text" class="am-form-field" placeholder="验证码">
                        <span class="am-input-group-label am-padding-0 am-text-middle" style="line-height: 34px">
                            <img style="height: 34px;width: 120px" class="verifyimg reloadverify" src="<%=contextPath%>/captcha" alt="">
                            <!-- 验证码 -->
                        </span>
                </div>

                <div class="am-margin-top-sm">
                    <button type="submit" id="submit_btn" class="am-btn am-btn-primary am-btn-block login-btn">登 陆</button>
                    <div class="am-alert am-alert-warning am-margin-bottom-0" id="check-tips" style="display: none"
                         data-am-alert="">
                        提示信息
                    </div>
                </div>
            </form>
        </div>
    </div>
<%--
    <div class="am-g login-bot">copyright</div>
--%>
</div>
<script src="<%=contextPath%>/static/js/jquery-1.10.2.min.js"></script>
<!--[if lt IE 9]>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="<%=contextPath%>/static/amazeui/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script type="text/javascript" src="<%=contextPath%>/static/amaze/js/amazeui.min.js"></script>
<script type="text/javascript">
    jQuery(function ($) {

        $("#submit_btn").click(function () {
            /*if ($("#loginForm").find(".am-form-error").length == 0) {
                $.ajax({
                    url: "<%=contextPath%>/backstage/dologin.json",
                    type: "post",
                    data: {"userName": $("#userName").val(), "password": $("#password").val()},
                    dataType: 'json',
                    success: function (rep) {
                        if (rep && rep.success == 'true') {
                            location.href = "index";
                        } else {
                            alert(rep.data);
                        }
                    }
                });
            }*/
            location.href = "<%=contextPath%>/backstage/";
        });
    });
</script>
<form id="gclp-frame-form" target="gclp-frame" method="post" style="display: none;"></form>
</body>
</html>