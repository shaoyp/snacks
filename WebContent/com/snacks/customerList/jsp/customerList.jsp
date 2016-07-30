<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div id="content-header">
    <div id="breadcrumb"> <span class="tip-bottom"><i class="glyphicon glyphicon-zoom-in"></i>&nbsp;</span></div>
</div>
<!--End-breadcrumbs-->

<!--Action boxes-->
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="widget-box">
                <div class="widget-title"> <span class="icon"> <i class="icon-list"></i> </span>
                    <h5>搜索项<s:property value="username" /> </h5>
                </div>
                <div class="widget-content"> Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. </div>
            </div>
        </div>
    </div>

    <div class="row-fluid">
        <div class="span12">
            <div class="widget-box">
                <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
                    <h5>客户信息</h5>
                </div>
                <div class="widget-content nopadding">

                    <ul class="recent-posts">
                        <li>
                            <%--<div class="dataArea">--%>
                                <div class="user-thumb"> <img width="40" height="40" src="img/demo/av1.jpg" alt="User"> </div>
                                <div class="buttonArea">
                                    <select class="form-control" style="width:120px;">
                                        <option>-- 销售状态 --</option>
                                        <option>不需要</option>
                                        <option>没打通</option>
                                        <option>想了解</option>
                                        <option>未来需要</option>
                                        <option>特别需要</option>
                                        <option>客户</option>
                                    </select>
                                    <input style="width:120px;" type="text" data-date="2013-02-01" data-date-format="yyyy-mm-dd" value="2013-02-01" class="datepicker span11">
                                </div>
                                <div class="article-post"> <span class="user-info"><h5>土老帽黄焖鸡</h5></span>
                                    <p>电话:<a href="#">13838389438</a>&nbsp;&nbsp;&nbsp;地址:黄河北大街27号 </p>
                                </div>

                            <%--</div>--%>
                        </li>
                        <li>
                            <div class="user-thumb"> <img width="40" height="40" src="img/demo/av2.jpg" alt="User"> </div>
                            <div class="article-post"> <span class="user-info"> By: john Deo / Date: 2 Aug 2012 / Time:09:27 AM </span>
                                <p>电话:<a href="#">13838389438</a></p>
                            </div>
                        </li>
                        <li>
                            <div class="user-thumb"> <img width="40" height="40" src="img/demo/av4.jpg" alt="User"> </div>
                            <div class="article-post"> <span class="user-info"> By: john Deo / Date: 2 Aug 2012 / Time:09:27 AM </span>
                                <p><a href="#">This is a much longer one that will go on for a few lines.Itaffle to pad out the comment.</a> </p>
                            </div>
                        </li>
                    </ul>

                </div>
            </div>

        </div>
    </div>

</div>

<script src="<%=request.getContextPath()%>/com/snacks/customerList/js/customerList.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/com/snacks/customerList/css/customerList.css" />