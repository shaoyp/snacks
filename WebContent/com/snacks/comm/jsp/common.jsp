<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String loginName = request.getRemoteUser();
%>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="<%=path %>/com/snacks/plugin/jQuery/jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="<%=path %>/com/snacks/plugin/bootstrap-3.3.5-dist/css/bootstrap.min.css" />
<script src="<%=path %>/com/snacks/plugin/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>

<script type="text/javascript" src="<%=path %>/com/snacks/plugin/artTemplate/template.js"></script>


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