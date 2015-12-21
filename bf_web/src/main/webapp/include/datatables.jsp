<%
    String contextPath1 = request.getContextPath();
%>
<link href="<%=contextPath1%>/static/amaze/css/amazeui.datatables.min.css" rel="stylesheet">
<style>
    .am-form .am-table td{
        word-break: break-all!important;
    }
</style>
<script src="<%=contextPath1%>/static/amaze/js/amazeui.datatables.js"></script>
<script src="<%=contextPath1%>/static/js/datatables/dataTables.responsive.js"></script>
<script>
    jQuery.extend(jQuery.fn.dataTableExt.oSort, {
        "chinese-string-asc": function (s1, s2) {
            return s1.localeCompare(s2);
        },

        "chinese-string-desc": function (s1, s2) {
            return s2.localeCompare(s1);
        }
    });
</script>