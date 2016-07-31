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

                    <ul class="recent-posts" id="grid_ul">
                        <script id="grid_template" type="text/html">
                            {{each result as record i}}
                            <li>
                                <div class="row-fluid"  style="margin-top:0px;">

                                    <div class="span8">
                                        <div class="user-thumb"> <img width="40" height="40" src="img/demo/av1.jpg" alt="User"> </div>
                                        <div class="article-post"> <span class="user-info"><h5>{{record.title}}</h5></span>
                                            <p>电话:<a href="#">{{record.phone}}</a>&nbsp;&nbsp;&nbsp;地址:{{record.address}} </p>
                                        </div>
                                    </div>
                                    <div class="span4 buttonArea row-fluid">
                                        <div class="controls controls-row top-button-box">

                                                <select name="status" class="span4" onchange="customerList.js.state(this,'{{record.resource_id}}')">
                                                    <option>-- 销售状态 --</option>
                                                    <option value="1">不需要</option>
                                                    <option value="2">没打通</option>
                                                    <option value="3">想了解</option>
                                                    <option value="4">未来需要</option>
                                                    <option value="5">特别需要</option>
                                                    <option value="6">客户</option>
                                                </select>
                                                <input type="text" data-date="2013-02-01" data-date-format="yyyy-mm-dd" value="2013-02-01" class="datepicker span4">
                                                <input type="text" placeholder="微信号" class="span4">
                                        </div>
                                        <div class="controls controls-row">
                                            <div class="m-wrap">
                                            <input type="text" placeholder="备注" class="span12">
                                                </div>
                                        </div>
                                    </div>
                                </div>

                            </li>
                            {{/each}}
                        </script>
                    </ul>

                </div>
            </div>

        </div>
    </div>

</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/com/snacks/customerList/js/customerList.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/com/snacks/customerList/css/customerList.css" />