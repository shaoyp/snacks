<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginName = request.getRemoteUser();
%>
<div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb span4"> <a href="javascript:void(0);" onclick="dataHandle.js.mergeData(this);"> <i class="icon-dashboard"></i>合并外卖数据（fandiandata） </a> </li>
        <li class="bg_lg span4"> <a href="javascript:void(0);" onclick="dataHandle.js.mergeFandian(this);"> <i class="icon-signal"></i>合并饭店数据（fandian）</a> </li>
        <li class="bg_ly span4"> <a href="javascript:void(0);" onclick="dataHandle.js.mergeZuobiao(this);"> <i class="icon-inbox"></i>合并坐标点（fandian）</a> </li>
        <li class="bg_lo span4"> <a href="javascript:void(0);" onclick="dataHandle.js.mergeCaipin(this);"> <i class="icon-inbox"></i>导出菜品 （caipin）</a> </li>
        <!-- <li class="bg_lo"> <a href="tables.html"> <i class="icon-th"></i> Tables</a> </li>
        <li class="bg_ls"> <a href="grid.html"> <i class="icon-fullscreen"></i> Full width</a> </li>
        <li class="bg_lo span3"> <a href="form-common.html"> <i class="icon-th-list"></i> Forms</a> </li>
        <li class="bg_ls"> <a href="buttons.html"> <i class="icon-tint"></i> Buttons</a> </li>
        <li class="bg_lb"> <a href="interface.html"> <i class="icon-pencil"></i><span class="label label-important">20</span>Elements</a> </li>
        <li class="bg_lg"> <a href="calendar.html"> <i class="icon-calendar"></i> <span class="label label-success">101</span>Calendar</a> </li>
        <li class="bg_lr"> <a href="error404.html"> <i class="icon-info-sign"></i> Error</a> </li> -->

      </ul>
	</div>
</div>
<script src="<%=request.getContextPath()%>/com/snacks/dataHandle/js/dataHandle.js"></script>
