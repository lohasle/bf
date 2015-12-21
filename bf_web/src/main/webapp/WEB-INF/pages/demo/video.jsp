<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/include/includeTag.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <style>
        html,body{
            height: 100%;
            width: 100%;
            overflow-x: hidden;
        }
        .warp{
            margin: 0;
        }
        .warp h1{
            text-align: center;
        }
        .warp .main{
            width: 1000px;
            margin: auto;
            text-align: center;
        }

        .warp .main .demo{
            padding: 20px;
            margin-bottom: 20px;
        }
        .warp .main .demo .content{
            padding: 10px;
        }

    </style>
</head>
<body>
<div class="warp">
    <h1>视频DEMO</h1>
    <div class="main">
        <div class="demo">
            <div class="content">
                <embed src="http://player.youku.com/player.php/sid/XMTM1NDA4NTE0NA==/v.swf" allowFullScreen="true" quality="high" width="480" height="400" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed>
            </div>
            <div class="des">优酷视屏(html播放)</div>
        </div>
        <div class="demo">
            <div class="content">
                <iframe height=400 width=480 src="http://player.youku.com/embed/XMTM1NDA4NTE0NA==" frameborder=0 allowfullscreen></iframe>
            </div>
            <div class="des">优酷视屏(iframe播放)</div>
        </div>
        <div class="demo">
            <div class="content">
                <div id="id_video_container" style="width:100%;height:288px;"></div><script src="http://qzonestyle.gtimg.cn/open/qcloud/video/h5/h5connect.js"></script>
                <script type="text/javascript">
                    (function(){
                        var option ={"auto_play":"0","file_id":"16092504232103761712","app_id":"1251013334","width":512,"height":288};
                        /*调用播放器进行播放*/
                        new qcVideo.Player(
                                /*代码中的id_video_container将会作为播放器放置的容器使用,可自行替换*/
                                "id_video_container",
                                option
                        );
                    })()
                </script>
            </div>
            <div class="des">腾讯云视屏</div>
        </div>

        <div class="demo">
            <div class="content">
                <section>
                    <video  controls src="http://200000941.vod.myqcloud.com/200000941_d99e1a6c6d8911e581af3fa6838b7347.f20.mp4">
                    </video>
                </section>
            </div>
            <div class="des">H5播放</div>
        </div>
        <div class="demo">
            <div class="content">
                <iframe src="http://play.video.qcloud.com/iplayer.html?$appid=1251013334&$fileid=16092504232103761712&$autoplay=0&$sw=512&$sh=288" frameborder="0" width="100%" height="288" scrolling="no"></iframe>	<!-- 页面内多处使用iframe代码，后面的JS代码只需要使用一次(作用是调整iframe的高度) -->	<script src="http://qzonestyle.gtimg.cn/open/qcloud/video/h5/fixifmheight.js" charset="utf-8"></script>
            </div>
            <div class="des">flash播放</div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/static/js/jquery-1.10.2.min.js"></script>
</body>
</html>