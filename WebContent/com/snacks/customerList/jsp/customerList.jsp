<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
                    <h5>搜索项</h5>
                </div>
                <div class="widget-content">
                    <div class="fr" style="margin-top: -15px;">
                        <a class="btn btn-primary " href="#"  onclick="customerList.js.query()"><i class="icon-search" style="margin-right: 5px;"></i>搜索</a>
                        <a class="btn btn-success" href="#" id="more_button" value="0" onclick="customerList.js.more(this)">更多</a>
                        <a class="btn btn-danger" href="#" onclick="customerList.js.clearQueryData()">清空</a>
                    </div>
                    <form class="form-horizontal">

                        <div class="row-fluid no_margin" id="query_box">
                            <div class="control-group span4">
                                <label class="control-label">饭店 :</label>
                                <div class="controls">
                                    <input id="query_fandian" type="text" placeholder="" class="span11">
                                </div>
                            </div>
                            <div class="control-group span4">
                                <label class="control-label">电话 :</label>
                                <div class="controls">
                                    <input id="query_phone" type="text" placeholder="" class="span11">
                                </div>
                            </div>
                            <div class="control-group span4">
                                <label class="control-label">销量 :</label>
                                <div class="controls">
                                    <input id="query_sales_min" type="text" placeholder="最小值" class="span5">
                                    &nbsp;~&nbsp;&nbsp;
                                    <input id="query_sales_max" type="text" placeholder="最大值" class="span5">
                                </div>
                            </div>
                            <div class="control-group span4">
                                <label class="control-label">位置 :</label>
                                <div class="controls">
                                    <input id="query_location" type="text" placeholder="" class="span11">
                                </div>
                            </div>
                            <div class="control-group span4">
                                <label class="control-label">地区 :</label>
                                <div class="controls">
                                    <select id="query_area" type="text" placeholder="" class="span11">
                                    </select>
                                </div>
                            </div>
                            <div class="control-group span4 hidden" name="more_div">
                                <label class="control-label">菜品 :</label>
                                <div class="controls">
                                    <input id="query_caipin" type="text" placeholder="" class="span11">
                                </div>
                            </div>
                            <div class="control-group span4 hidden" name="more_div">
                                <label class="control-label">价格 :</label>
                                <div class="controls">
                                    <input id="query_prince_min" type="text" placeholder="最小值" class="span5">
                                    &nbsp;~&nbsp;&nbsp;
                                    <input id="query_prince_max" type="text" placeholder="最大值" class="span5">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="row-fluid">
        <div class="span12">
            <div class="widget-box" style="margin-bottom: 0px;">
                <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
                    <h5>客户信息</h5>
                </div>
                <div class="widget-content nopadding">

                    <ul class="recent-posts" id="grid_ul">
                        <script id="grid_template" type="text/html">
                            {{if result.length == 0}}
                            <li >
                                未搜索到符合条件的数据
                            </li>
                            {{/if}}
                            {{each result as record i}}
                            <li {{if record.fuid != null }} class="called" {{/if}} >
                            <div class="row-fluid"  style="margin-top:0px;" onclick="customerList.js.openDetail('{{record.resource_id}}','{{record.title}}')">

                                <div class="span7">
                                    <div class="user-thumb"> <img width="40" height="40" src="" alt=""> </div>
                                    <div class="article-post"> <span class="user-info" ><h5>{{record.title}}</h5></span>
                                        <p>电话:<a href="#">{{record.phone}}</a>&nbsp;&nbsp;&nbsp;地址:{{record.address}} </p>
                                    </div>
                                </div>
                                <div class="span1 buttonArea">
                                    <div class="article-post">
                                        <p style="margin-bottom: 6px;">{{record.last_date}}</p>
                                        <span class="user-info">
                                            {{if record.fustate == 1}}
                                            <h6>不需要</h6>
                                            {{else if record.fustate == 2}}
                                            <h6>没打通</h6>
                                            {{else if record.fustate == 3}}
                                            <h6>想了解</h6>
                                            {{else if record.fustate == 4}}
                                            <h6>未来需要</h6>
                                            {{else if record.fustate == 5}}
                                            <h6>特别需要</h6>
                                            {{else if record.fustate == 6}}
                                            <h6>客户</h6>
                                            {{/if}}
                                        </span>
                                    </div>
                                </div>
                                <div class="span4 buttonArea row-fluid">
                                    <div class="controls controls-row top-button-box">

                                        <select name="status" class="span4" onchange="customerList.js.state(this,'{{record.resource_id}}','{{record.fuid}}')">
                                            <option>- 销售状态 -</option>
                                            <option value="1">不需要</option>
                                            <option value="2">没打通</option>
                                            <option value="3">想了解</option>
                                            <option value="4">未来需要</option>
                                            <option value="5">特别需要</option>
                                            <option value="6">客户</option>
                                        </select>
                                        <input type="text" name="recall_date_input" data-date="2013-02-01" fid="{{record.resource_id}}" fuid="{{record.fuid}}" data-date-format="yyyy-mm-dd" value="{{record.recall_date}}" onchange="customerList.js.state(this,'{{record.resource_id}}')" placeholder="预约时间" class="datepicker span4">
                                        <input type="text" placeholder="微信号" fid="{{record.resource_id}}" fuid="{{record.fuid}}" class="span4" name="wechat_input" value="{{record.wechat}}">
                                    </div>
                                    <div class="controls controls-row">
                                        <div class="m-wrap">
                                            <input type="text" name="beizhu_input" fid="{{record.resource_id}}" fuid="{{record.fuid}}" placeholder="备注" class="span12" style="margin-bottom: 0px;" value="{{record.beizhu}}">
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
            <div id="callBackPager"></div>

        </div>
    </div>

</div>

<link rel="stylesheet" href="<%=request.getContextPath() %>/com/snacks/customerList/css/customerList.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/com/snacks/customerList/js/customerList.js"></script>
