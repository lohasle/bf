<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/include/includeTag.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>MiniCheckout</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/pinus.css">
    <style>
        #qrCode{
            position: fixed;
            left: 50%;
            top: 50%;
            width: 256px;
            height: 256px;
            margin-top: -128px;
            margin-left: -128px;
        }
        .closeWin{
            position: absolute;
            right: -54px;
            top: 0px;
            font-size: 27px;
            background: #000000;
            color: #ffffff;
            width: 54px;
            height: 54px;
            text-align: center;
            cursor: pointer;
        }
    </style>
</head>
<body>
<header>
    <div class="h_content">
        <span></span>
    </div>
</header>
<section class="block">
    <div class="content2">
        <div class="app">
            <span class="iphone"><img src="${ctx}/static/images/bgpic.jpg" width="100%" height="auto"></span>
            <label class="text_amount">
                <input id="amount" type="text" placeholder="金 额" value="0.01"/>
            </label>

            <div class="ch">
                <span class="up" onclick="wap_pay('wx_pub_qr')">微信扫码</span>
                <span class="up" onclick="wap_pay('upacp_wap')">银联 WAP</span>
                <span class="up" onclick="wap_pay('upacp_pc')">银联 PC</span>
                <span class="up" onclick="wap_pay('alipay_wap')">支付宝 WAP</span>
                <span class="up" onclick="wap_pay('alipay_pc_direct')">支付宝 PC</span>
            </div>
        </div>
    </div>
</section>
<div id="qrCode" style="display: none">
    <div class="content"></div>
    <div class="closeWin">X</div>
</div>
<script src="${ctx}/static/js/lib/pingpp.js" type="text/javascript"></script>
<script src="${ctx}/static/js/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="${ctx}/static/js/jquery.qrcode.min.js" type="text/javascript"></script>
<script>
    function wap_pay(channel) {
        var amount = document.getElementById('amount').value;

        if(channel=='upacp_wap'||channel=='upacp_pc'||amount=='alipay_pc_direct'){
            alert("渠道未开通，请先开通");
            return;
        }
        var pay_url = "${ctx}/demo/pay.do";
        var $qrCode = $("#qrCode");
        $qrCode.on("click",".closeWin",function(){
            $qrCode.fadeOut();
        });

        $.ajax({
            type:"post",
            dataType:"json",
            url: pay_url,
            success: function (responseText) {
                pingpp.createPayment(responseText, function (result, err) {
                    console.log(result);
                    console.log(err);
                    switch (channel){
                        case "wx_pub_qr":
                            var qrcode = responseText.credential.wx_pub_qr;
                            $qrCode.find(".content").html("").qrcode(qrcode).parent().fadeIn();
                            qryOnLine(responseText.id);
                            break;
                        case "upacp_wap":
                            break;
                        case "upacp_pc":

                            break;
                    }
                });
            },
            data: {"channel": channel, "amount": amount}
        });
    }

    function qryOnLine(id){
        $.getJSON("${ctx}/demo/qry.do?id="+id,function(data){
            if(data.paid){
                // 已经付款
                alert("付款成功!");
                location.href="${ctx}/demo/paySuccess";
            }else{
                setTimeout(function(){
                    qryOnLine(id);
                },500);
            }
        });

    }

    // app_pay 需要配合 example-webview 的 iOS 或者 Android 项目使用。
    function app_pay(channel) {
        var amount = document.getElementById('amount').value * 100;
        if (typeof PINGPP_IOS_SDK !== 'undefined') {
            PINGPP_IOS_SDK.callPay(channel, amount);
        } else if (typeof PINGPP_ANDROID_SDK !== 'undefined') {
            PINGPP_ANDROID_SDK.callPay(channel, amount);
        }
    }
</script>
</body>
</html>