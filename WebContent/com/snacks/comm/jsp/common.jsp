<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String loginName = request.getRemoteUser();
%>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<%--<script src="<%=path %>/com/snacks/plugin/jQuery/jquery-3.1.0.min.js"></script>--%>
<%--<link rel="stylesheet" href="<%=path %>/com/snacks/plugin/bootstrap-3.3.5-dist/css/bootstrap.min.css" />--%>
<link rel="stylesheet" href="<%=path %>/com/snacks/box/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=path %>/com/snacks/box/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="<%=path %>/com/snacks/box/css/fullcalendar.css" />
<link rel="stylesheet" href="<%=path %>/com/snacks/box/css/matrix-style.css" />
<link rel="stylesheet" href="<%=path %>/com/snacks/box/css/matrix-media.css" />
<link rel="stylesheet" href="<%=path %>/com/snacks/box/font-awesome/css/font-awesome.css" />
<link rel="stylesheet" href="<%=path %>/com/snacks/box/css/jquery.gritter.css" />
<%--<script src="<%=path %>/com/snacks/plugin/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>--%>
<script src="<%=path %>/com/snacks/box/js/jquery.min.js"></script>


<script type="text/javascript" src="<%=path %>/com/snacks/plugin/artTemplate/template.js"></script>
<script type="text/javascript" src="<%=path %>/com/snacks/plugin/hashchange/jquery.ba-hashchange.min.js"></script>

<%--<script src="<%=path %>/com/snacks/box/js/excanvas.min.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.ui.custom.js"></script>--%>
<script src="<%=path %>/com/snacks/box/js/bootstrap.min.js"></script>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.flot.min.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.flot.resize.min.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.peity.min.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/fullcalendar.min.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/matrix.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/matrix.dashboard.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.gritter.min.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/matrix.interface.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/matrix.chat.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.validate.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/matrix.form_validation.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.wizard.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.uniform.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/select2.min.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/matrix.popover.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="<%=path %>/com/snacks/box/js/matrix.tables.js"></script>--%>

<%--<script src="<%=path %>/comm/js/common.js"></script>--%>

<script type="text/javascript">
    var path = "<%=path %>";

    jQuery.namespace = function(){
        var a=arguments, o=null, i, j, d, rt;
        for (i=0; i<a.length; ++i) {
            d=a[i].split(".");
            rt = d[0];
            eval('if (typeof ' + rt + ' == "undefined"){' + rt + ' = {};} o = ' + rt + ';');
            for (j=1; j<d.length; ++j) {
                o[d[j]]=o[d[j]] || {};
                o=o[d[j]];
            }
        }
    }
</script>

<script type="text/javascript" src="<%=path %>/com/snacks/comm/js/common.js"></script>