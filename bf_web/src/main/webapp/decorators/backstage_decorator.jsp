<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%
    String contextPath = request.getContextPath();
%>
<!doctype html>
<html lang="en">
<head>
    <title><decorator:title default=""/></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <!-- font-awesome -->
    <link rel="stylesheet" href="<%=contextPath%>/static/css/font-awesome.min.css"/>

    <!-- amaze -->
    <link rel="stylesheet" href="<%=contextPath%>/static/amaze/css/amazeui.min.css"/>
    <link rel="stylesheet" href="<%=contextPath%>/static/amaze/css/admin.css">
    <link rel="stylesheet" href="<%=contextPath%>/static/amaze/css/amazeui.datetimepicker.css">


    <link rel="stylesheet" href="<%=contextPath%>/static/css/backstage-common.css">
    <script type="text/javascript">
        window.EVA = {
            VERSION: "1.1.0",
            SERV_ROOT_DIR: "<%=contextPath%>",
            XHR_SUCCESS: "true",
            XHR_ERROR: "false",
            debug: false//  is debug
        };
    </script>

    <!-- common js -->
    <!--[if (gte IE 9)|!(IE)]><!-->
    <script src="<%=contextPath%>/static/js/jquery-1.10.2.min.js"></script>
    <!--<![endif]-->

    <script src="<%=contextPath%>/static/amaze/js/amazeui.min.js"></script>
    <script src="<%=contextPath%>/static/amaze/js/amazeui.datetimepicker.js"></script>
    <script src="<%=contextPath%>/static/amaze/js/amazeui.dialog.js "></script>

    <!-- tools -->
    <script src="<%=contextPath%>/static/js/jquery.form.js"></script>
    <script src="<%=contextPath%>/static/js/template.js"></script>
    <script src="<%=contextPath%>/static/js/app/admin/common.js"></script>


    <!--[if lt IE 9]>
    <script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="/Public/talent/js/amazeui.ie8polyfill.min.js"></script>
    <script src="<%=contextPath%>/static/js/iefix/html5shiv.min.js"></script>
    <script src="<%=contextPath%>/static/js/iefix/ie9.js"></script>
    <![endif]-->

    <decorator:head/>
</head>
<body>
<decorator:body/>
</body>
</html>
