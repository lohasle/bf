<%--
  Created by IntelliJ IDEA.
  User: lohas
  Date: 2015/3/3
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="/include/includeTag.jsp" %>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <%@include file="/include/datatables.jsp" %>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->


<div class="am-cf admin-main">

    <!-- content start -->
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户管理</strong> /
                <a href="javascript:openBankWin();"><small>系统用户管理</small></a>
            </div>
        </div>
        <div class="am-cf">
            <form id="searchForm" class="am-form-inline align-center hide" role="form">
                <div class="am-form-group">
                    <label class="search-label">日志名称</label>
                    <input  name="loggerName" class="search-input" type="text" placeholder="日志名称">
                </div>
                <div class="am-form-group">
                    <label class="search-label">日志内容</label>
                    <input  name="content" class="search-input" type="text" placeholder="日志内容">
                </div>
                <div class="am-form-group">
                    <label class="search-label">日志类型</label>
                    <select name="level" class="search-select">
                        <option value="">--请选择--</option>
                        <option value="DEBUG">DEBUG</option>
                        <option value="INFO">INFO</option>
                        <option value="WARN">WARN</option>
                        <option value="ERROR">ERROR</option>
                    </select>
                </div>
                <div class="am-form-group">
                    <label class="search-label">开始时间</label>
                    <div class="am-input-group date datetimepicker" id="startDate" data-date-format="yyyy-mm-dd hh">
                        <input id="search_begin_time" type="text"  name="beginDate" class="am-form-field">
                        <span class="am-input-group-label add-on"><i class="icon-th am-icon-calendar"></i></span>
                    </div>
                </div>
                <div class="am-form-group">
                    <label class="search-label">结束时间</label>
                    <div class="am-input-group date datetimepicker" id="endDate" data-date-format="yyyy-mm-dd hh">
                        <input id="search_end_time" type="text"  name="endDate" class="am-form-field">
                        <span class="am-input-group-label add-on"><i class="icon-th am-icon-calendar"></i></span>
                    </div>
                </div>
                <div class="am-form-group search-div">
                    <button type="submit" class="am-btn am-btn-primary am-radius btn-search">
                        <i class="am-icon-search"></i>
                        搜索
                    </button>
                    <button type="button" class="am-btn am-btn-warning am-radius btn-reset">
                        <i class="am-icon-retweet"></i>
                        重置
                    </button>
                </div>
            </form>
        </div>
        <div class="am-g">
            <div class="am-u-sm-12">
                <form class="am-form" onsubmit="return false">
                    <table class="am-table am-table-striped am-table-hover table-main am-table-bordered" id="listTable">
                    </table>
                </form>
            </div>

        </div>
    </div>
    <!-- content end -->


    <!-- editTemp -->
    <script id="editTemp" type="text/html">
        <div class="am-g am-container">
            <div class="am-panel am-panel-default">
                <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-1'}">
                    日志信息
                    <span class="am-icon-chevron-down am-fr"></span>
                </div>
                <div class="am-panel-bd am-collapse am-in" id="collapse-panel-1">
                    <table class="am-table am-table-bordered am-table-radius am-table-striped">
                        <tbody>
                        <tr>
                            <td>eventId</td>
                            <td>{{eventId}}</td>
                        </tr>
                        <tr>
                            <td>日志名称</td>
                            <td>{{loggerName}}</td>
                        </tr>
                        <tr>
                            <td>线程名</td>
                            <td>{{threadName}}</td>
                        </tr>
                        <tr>
                            <td>级别</td>
                            <td>
                                {{levelString}}
                            </td>
                        </tr>
                        <tr>
                            <td>内容</td>
                            <td>{{#formattedMessage}}</td>
                        </tr>
                        <tr>
                            <td>调用文件</td>
                            <td>
                                {{callerFilename}}
                            </td>
                        </tr>
                        <tr>
                            <td>调用类</td>
                            <td>
                                {{callerClass}}
                            </td>
                        </tr>
                        <tr>
                            <td>方法</td>
                            <td>
                                {{callerMethod}}
                            </td>
                        </tr>
                        <tr>
                            <td>行号</td>
                            <td>
                                {{callerLine}}
                            </td>
                        </tr>
                        <tr>
                            <td>创建时间</td>
                            <td>
                                {{getDateOnTimestmp(timestmp)}}
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>


            {{if loggingEventPropertys&&loggingEventPropertys.length>0}}
            <div class="am-panel am-panel-default">
                <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-2'}">
                    日志详细
                    <span class="am-icon-chevron-down am-fr"></span>
                </div>
                <div class="am-panel-bd am-collapse am-in" id="collapse-panel-2">
                    <table class="am-table am-table-bordered am-table-radius am-table-striped">
                        {{each loggingEventPropertys as item i}}
                            {{if item}}
                            <tr>
                                <td>名称</td>
                                <td>
                                    {{item.mappedKey}}
                                </td>
                                <td>值</td>
                                <td style="word-break: break-all">
                                    {{item.mappedValue}}
                                </td>
                            </tr>

                            {{/if}}

                        {{/each}}
                    </table>
                </div>
            </div>
            {{/if}}

            {{if loggingEventExceptions&&loggingEventExceptions.length>0}}
            <div class="am-panel am-panel-default">
                <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-3'}">
                    异常信息
                    <span class="am-icon-chevron-down am-fr"></span>
                </div>
                <div class="am-panel-bd am-collapse am-in" id="collapse-panel-3">
                    <table class="am-table am-table-bordered am-table-radius am-table-striped">
                        {{each loggingEventExceptions as item j}}
                            {{if item}}
                            <tr>
                                <td>i</td>
                                <td>
                                    {{item.i}}
                                </td>
                                <td>line</td>
                                <td>
                                    {{item.traceLine}}
                                </td>
                            </tr>
                            {{/if}}

                        {{/each}}
                    </table>
                </div>
            </div>
            {{/if}}
        </div>
    </script>
</div>

<script type="text/javascript">

    jQuery(function ($) {


        // list view
        var dataTable = $('#listTable').DataTable({
            bProcessing: true,
            bServerSide: true,
            responsive: true,
            serverSide: true,
            searching: false,
            pagingType: "full_numbers",
            order:[0,'desc'],//默认排序
//            lengthMenu: [ [-1,10, 25, 50], ["All",10, 25, 50] ], //自定义每页数量的时候,下拉菜单的选项
            ajax: {
                url: "${ctx}/backstage/user/list.json",
                data: function (data) {
                    var searchFormData = $("#searchForm").serializeArray();
                    var resultData = {
                        dataTablesReqPar: JSON.stringify(data)
                    };
                    // 附加搜索条件
                    for (var i = 0; i < searchFormData.length; i++) {
                        var par = searchFormData[i];
                        resultData[par['name']] = par['value'];
                    }
                    return resultData;
                }
            },
            columns: [
                {data: "id", sTitle: "ID", name: 'id'},
                {data: "userName",sTitle: "名称",orderable: false},
                {data: "state",sTitle: "状态",orderable: false,
                    render: function (data, type, full, meta) {
                        if (data) {
                            return data=='1'?"启用":"禁用";
                        }
                    }
                },
                {data: "remark",sTitle: "备注",orderable: false},
                {data: "createTime",sTitle: "创建时间",orderable: false},
                {data: "modifyTime",sTitle: "修改时间", orderable: false},
            ],
            columnDefs: [
                {
                    targets: [6],
                    data: "ops",
                    className:"_ops",
                    searchable: false,
                    orderable: false,
                    render: function (data, type, full) {
                        return dataTableTools.createColumnsEditAndDel(full.eventId);
                    }
                }
            ]
        });


        //搜索
        $("#searchForm").submit(function () {
            dataTable.draw();
            return false;
        });

        //重置搜索
        $("#searchForm").on("click",".btn-reset",function(){
            $("#searchForm")[0].reset();
            dataTable.draw();
            return false;
        });

        //查看详情
        $("#listTable").on('click', '.detailBtn', function () {
            var dataId = $(this).parentsUntil(".bs-action").parent().attr("data-id");
            $.getJSON("${ctx}/backstage/sysUser/"+dataId,function(rep){
                if(rep.success==EVA.XHR_SUCCESS){
                    var data = rep.data;
                    var $html = $(template('editTemp', data));
                    AMUI.dialog.popup({
                        title: '编辑',
                        content: $html.html()
                    });
                }
            });
        });

        // 快速筛选
        $("#searchForm").on("change","select[name='level']",function(){
            dataTable.draw();
        });

    });
</script>
</body>
</html>

