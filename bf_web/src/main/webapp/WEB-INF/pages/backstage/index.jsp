<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/include/includeTag.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>控制台 - 后台管理</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <!-- bootstrap -->
    <link href="<%=contextPath%>/static/css/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet"/>
    <link href="<%=contextPath%>/static/css/bootstrap-3.3.5-dist/css/bootstrap-theme.css" rel="stylesheet"/>

    <!-- font-awesome -->
    <link rel="stylesheet" href="<%=contextPath%>/static/css/font-awesome.min.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="<%=contextPath%>/static/css/ace.min.css"/>
    <link rel="stylesheet" href="<%=contextPath%>/static/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="<%=contextPath%>/static/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="<%=contextPath%>/static/css/theme/default/main.css" type="text/css"/>
    <link rel="stylesheet" href="<%=contextPath%>/static/css/backstage-common.css">


    <script src="<%=contextPath%>/static/js/jquery-1.10.2.min.js"></script>
    <!-- ace settings handler -->
    <script src="<%=contextPath%>/static/js/ace/ace-extra.min.js"></script>

    <!--[if lt IE 9]>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="<%=contextPath%>/static/js/iefix/html5shiv.min.js"></script>
    <script src="<%=contextPath%>/static/js/iefix/ie9.js"></script>
    <script src="<%=contextPath%>/static/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div class="navbar navbar-default" id="navbar" style="height: 45px">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <%--
                                        <i class="icon-leaf"></i>
                    --%>
                    JAVA基础开发平台
                </small>
            </a><!-- /.brand -->
        </div>
        <!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <%--  <li class="grey">
                      <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                          <i class="icon-tasks"></i>
                          <span class="badge badge-grey">4</span>
                      </a>

                      <ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                          <li class="dropdown-header">
                              <i class="icon-ok"></i>
                              还有4个任务完成
                          </li>

                          <li>
                              <a href="#">
                                  <div class="clearfix">
                                      <span class="pull-left">软件更新</span>
                                      <span class="pull-right">65%</span>
                                  </div>

                                  <div class="progress progress-mini ">
                                      <div style="width:65%" class="progress-bar "></div>
                                  </div>
                              </a>
                          </li>

                          <li>
                              <a href="#">
                                  <div class="clearfix">
                                      <span class="pull-left">硬件更新</span>
                                      <span class="pull-right">35%</span>
                                  </div>

                                  <div class="progress progress-mini ">
                                      <div style="width:35%" class="progress-bar progress-bar-danger"></div>
                                  </div>
                              </a>
                          </li>

                          <li>
                              <a href="#">
                                  <div class="clearfix">
                                      <span class="pull-left">单元测试</span>
                                      <span class="pull-right">15%</span>
                                  </div>

                                  <div class="progress progress-mini ">
                                      <div style="width:15%" class="progress-bar progress-bar-warning"></div>
                                  </div>
                              </a>
                          </li>

                          <li>
                              <a href="#">
                                  <div class="clearfix">
                                      <span class="pull-left">错误修复</span>
                                      <span class="pull-right">90%</span>
                                  </div>

                                  <div class="progress progress-mini progress-striped active">
                                      <div style="width:90%" class="progress-bar progress-bar-success"></div>
                                  </div>
                              </a>
                          </li>

                          <li>
                              <a href="#">
                                  查看任务详情
                                  <i class="icon-arrow-right"></i>
                              </a>
                          </li>
                      </ul>
                  </li>
                  <li class="purple">
                      <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                          <i class="icon-bell-alt icon-animated-bell"></i>
                          <span class="badge badge-important">8</span>
                      </a>

                      <ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
                          <li class="dropdown-header">
                              <i class="icon-warning-sign"></i>
                              8条通知
                          </li>

                          <li>
                              <a href="#">
                                  <div class="clearfix">
                                              <span class="pull-left">
                                                  <i class="btn btn-xs no-hover btn-pink icon-comment"></i>
                                                  新闻评论
                                              </span>
                                      <span class="pull-right badge badge-info">+12</span>
                                  </div>
                              </a>
                          </li>

                          <li>
                              <a href="#">
                                  <i class="btn btn-xs btn-primary icon-user"></i>
                                  切换为编辑登录..
                              </a>
                          </li>

                          <li>
                              <a href="#">
                                  <div class="clearfix">
                                              <span class="pull-left">
                                                  <i class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
                                                  新订单
                                              </span>
                                      <span class="pull-right badge badge-success">+8</span>
                                  </div>
                              </a>
                          </li>

                          <li>
                              <a href="#">
                                  <div class="clearfix">
                                              <span class="pull-left">
                                                  <i class="btn btn-xs no-hover btn-info icon-twitter"></i>
                                                  粉丝
                                              </span>
                                      <span class="pull-right badge badge-info">+11</span>
                                  </div>
                              </a>
                          </li>

                          <li>
                              <a href="#">
                                  查看所有通知
                                  <i class="icon-arrow-right"></i>
                              </a>
                          </li>
                      </ul>
                  </li>--%>
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <%-- 头像
                                                <img class="nav-user-photo" src="" alt="lohasle"/>
                        --%>
                        <span class="user-info">
                            <small>欢迎光临,</small>
                            admin
                            ${sessionScope.BACKSTAGE_USER.userName}
                        </span>
                        <i class="icon-caret-down"></i>
                    </a>


                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <%-- <li>
                             <a href="#">
                                 <i class="icon-cog"></i>
                                 设置
                             </a>
                         </li>

                         <li>
                             <a href="#">
                                 <i class="icon-user"></i>
                                 个人资料
                             </a>
                         </li>--%>

                        <li class="divider"></li>

                        <li>
                            <a href="<%=contextPath%>/cms/backstage/login_out">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>

                </li>
            </ul>
            <!-- /.ace-nav -->
        </div>
        <!-- /.navbar-header -->
    </div>
    <!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'fixed')
                } catch (e) {
                }
            </script>


            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <%--<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-success">
                        <i class="icon-signal"></i>
                    </button>

                    <button class="btn btn-info">
                        <i class="icon-pencil"></i>
                    </button>

                    <button class="btn btn-warning">
                        <i class="icon-group"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="icon-cogs"></i>
                    </button>
                </div>--%>

                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>

                    <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span>

                    <span class="btn btn-danger"></span>
                </div>
            </div>
            <!-- #sidebar-shortcuts -->

            <ul class="nav nav-list" id="nav-list">
                <li class="active">
                    <a href="#">
                        <i class="icon-dashboard"></i>
                        <%--<span class="menu-text"> 控制台 </span>--%>
                    </a>
                </li>
                <!-- 菜单 start -->
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-user"></i>
                         <span class="menu-text">
                        用户管理
                        <span class="badge badge-primary "></span>
                        </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">

                        <li>
                            <a href="javascript:;" data-href="<%=contextPath%>/backstage/user/list">
                                <i class="icon-file-alt"></i>
                                <span class="menu-text"> 用户管理</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-user"></i>
                         <span class="menu-text">
                        登录页面
                        <span class="badge badge-primary "></span>
                        </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">

                        <li>
                            <a href="javascript:;" data-href="<%=contextPath%>/backstage/login">
                                <i class="icon-file-alt"></i>
                                <span class="menu-text"> 登录</span>
                            </a>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-home"></i>
                         <span class="menu-text">
                        系统监控
                        <span class="badge badge-primary ">2</span>
                        </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="javascript:;" data-href="<%=contextPath%>/backstage/logging/list">
                                <i class="icon-file-alt"></i>
                                <span class="menu-text"> 日志查询 </span>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:;" data-href="<%=contextPath%>/backstage/druid/index.html">
                                <i class="icon-file-alt"></i>
                                <span class="menu-text"> 数据库状态 </span>
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- end -->


            </ul>
            <!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
                   data-icon2="icon-double-angle-right"></i>
            </div>

            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'collapsed')
                } catch (e) {
                }
            </script>
        </div>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                </script>

                <!-- 面包屑 头部 -->
                <ul class="breadcrumb" id="breadcrumb" style="margin-top: 8px;">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">首页</a>
                    </li>
                    <li class="active">控制台</li>
                </ul>
                <!-- .breadcrumb -->

                <%--  <div class="nav-search" id="nav-search">
                      <form class="form-search">
                                  <span class="input-icon">
                                      <input type="text" placeholder="Search ..." class="nav-search-input"
                                             id="nav-search-input" autocomplete="off"/>
                                      <i class="icon-search nav-search-icon"></i>
                                  </span>
                      </form>
                  </div>--%>
                <!-- #nav-search -->
            </div>

            <div class="page-content" id="page-content">
                <!-- 控制台头部 -->
                <%-- <div class="page-header">
                     <h1>
                         控制台
                         <small>
                             <i class="icon-double-angle-right"></i>
                             查看
                         </small>
                     </h1>
                 </div>--%>
                <!-- 头部 -->
                <%--
                                <h1>内容区</h1>
                --%>

            </div>
            <!-- /.page-content -->
        </div>
        <!-- /.main-content -->


        <div class="ace-settings-container" id="ace-settings-container">
            <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                <i class="icon-cog bigger-150"></i>
            </div>

            <div class="ace-settings-box" id="ace-settings-box">
                <div>
                    <div class="pull-left">
                        <select id="skin-colorpicker" class="hide">
                            <option data-skin="default" value="#438EB9">#438EB9</option>
                            <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                            <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                            <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                        </select>
                    </div>
                    <span>&nbsp; 选择皮肤</span>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar"/>
                    <label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar"/>
                    <label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs"/>
                    <label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl"/>
                    <label class="lbl" for="ace-settings-rtl">切换到左边</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container"/>
                    <label class="lbl" for="ace-settings-add-container">
                        切换窄屏
                        <b></b>
                    </label>
                </div>
            </div>
        </div>

        <!-- /#ace-settings-container -->
    </div>
    <!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div>
<!-- /.main-container -->

<script src="<%=contextPath%>/static/css/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='<%=contextPath%>/static/js/jquery.mobile.custom.min.js'>" + "<" + "script>");
</script>
<script src="<%=contextPath%>/static/js/lib/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="<%=contextPath%>/static/js/jqueryui/jquery-ui-1.10.3.custom.min.js"></script>
<script src="<%=contextPath%>/static/js/jqueryui/jquery.ui.touch-punch.min.js"></script>
<script src="<%=contextPath%>/static/js/lib/jquery.slimscroll.min.js"></script>
<!-- ace scripts -->

<script src="<%=contextPath%>/static/js/ace/ace-elements.min.js"></script>
<script src="<%=contextPath%>/static/js/ace/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript" src="<%=contextPath%>/static/js/app/admin/index.js"></script>
<script type="text/javascript">
    jQuery(function ($) {
        var indexUrl = "<%=contextPath%>/backstage/druid/index.html";
        var f_width = $("body").outerWidth() - $("#nav-list").outerWidth() - 30;
        var f_height = $("body").outerHeight() - $("#breadcrumbs").outerHeight() - $("#navbar").outerHeight() - 40;
        $("#page-content").append('<iframe id="contentFrame" name="contentFrame" style="width:100%;height:' + f_height + 'px;border: 0px;"  src="'+indexUrl+'"></iframe>');
        $("#ace-settings-breadcrumbs").trigger('click');
    });
</script>
</body>
</html>
