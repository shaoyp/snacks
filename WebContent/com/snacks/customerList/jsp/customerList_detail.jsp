<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../../comm/jsp/common.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/com/snacks/customerList/js/customerList_detail.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/com/snacks/customerList/css/customerList_detail.css" />
<!-- 弹出添加页面 -->
<div class="" style="" id="detail_area">
    <div class="widget-content">
        <h3>玛莎拉蒂餐厅</h3>
        <hr>
        <div class="widget-box">
            <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
                <h5>菜品详单</h5>
            </div>
            <div class="widget-content nopadding">
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>菜品名称</th>
                        <th>单价</th>
                        <th>销量</th>
                    </tr>
                    </thead>
                    <tbody id="caipin_table">
                    <script id="caipin_template" type="text/html">
                        {{each result as record i}}
                        <tr class="odd gradeX">
                            <td>{{record.caipinming}}</td>
                            <td style="text-align: center;">{{record.prince}}</td>
                            <td style="text-align: center;">{{record.sales}}</td>
                        </tr>
                        {{/each}}
                    </script>
                    </tbody>
                </table>
            </div>
            <div id="detail_callBackPager"></div>
        </div>
    </div>
</div>

