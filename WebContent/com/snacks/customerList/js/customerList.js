/**
 * Created by jerrywang on 16/7/29.
 */
jQuery.namespace("customerList");

$(function () {

    $.post(path+"/customerList/customerList_getList.action",{
    },function (data) {

        var html = template('grid_template',{'result':data.fandianList});
        // 渲染列表
        $('#grid_ul').html(html);
        // 绑定日期组件
        $('.datepicker').datepicker().on('changeDate',function() {

            customerList.js.updateDate($(this));
            $(this).blur();
        });
        // 绑定微信文本框回车事件
        $("input[name=wechat_input]").on('keyup',function (event) {
            // 文本修改标记颜色
            $(this).addClass("not_save");

            if($(this).val() == ''){
                $(this).removeClass("not_save");
            }

            if(event.keyCode == "13"){
                // 保存微信号
                var param = {"fandianUser.wechat":$(this).val(),"fandianUser.fandianId":$(this).attr("fid"),"fandianUser.resourceId":$(this).attr("fuid")};
                customerList.js.operFandianUser(param);
                $(this).removeClass("not_save").blur();
            }
        });

        // 绑定备注文本框的回车事件
        $("input[name=beizhu_input]").on('keyup',function (event) {

            // 文本修改标记颜色
            $(this).addClass("not_save");

            if($(this).val() == ''){
                $(this).removeClass("not_save");
            }

            if(event.keyCode == "13"){
                // 保存微信号
                var param = {"fandianUser.beizhu":$(this).val(),"fandianUser.fandianId":$(this).attr("fid"),"fandianUser.resourceId":$(this).attr("fuid")};
                customerList.js.operFandianUser(param);
                $(this).removeClass("not_save").blur();
            }
        });

        // 初始化分页组件
        $('#callBackPager').extendPagination({
            totalCount: data.count,
            showCount: 2,
            limit: 10,
            callback: function (curr, limit, totalCount) {
                customerList.js.pageTo(curr);
            }
        });

    });

    
});

customerList.js = {};

customerList.js.pageTo = function(curr){

    $.post(path+"/customerList/customerList_getList.action",{
        "page" : curr
    },function (data) {
        var html = template('grid_template',{'result':data.fandianList});
        // 渲染列表
        $('#grid_ul').html(html);
        // 绑定日期组件
        $('.datepicker').datepicker().bind('changeDate',function() {
            customerList.js.updateDate($(this));
            $(this).blur();
        });
        // 绑定微信文本框回车事件
        $("input[name=wechat_input]").on('keyup',function (event) {
            // 文本修改标记颜色
            $(this).addClass("not_save");

            if($(this).val() == ''){
                $(this).removeClass("not_save");
            }

            if(event.keyCode == "13"){
                // 保存微信号
                var param = {"fandianUser.wechat":$(this).val(),"fandianUser.fandianId":$(this).attr("fid"),"fandianUser.resourceId":$(this).attr("fuid")};
                customerList.js.operFandianUser(param);
                $(this).removeClass("not_save").blur();
            }
        });

        // 绑定备注文本框的回车事件
        $("input[name=beizhu_input]").on('keyup',function (event) {

            // 文本修改标记颜色
            $(this).addClass("not_save");

            if($(this).val() == ''){
                $(this).removeClass("not_save");
            }

            if(event.keyCode == "13"){
                // 保存微信号
                var param = {"fandianUser.beizhu":$(this).val(),"fandianUser.fandianId":$(this).attr("fid"),"fandianUser.resourceId":$(this).attr("fuid")};
                customerList.js.operFandianUser(param);
                $(this).removeClass("not_save").blur();
            }
        });

    });
};

// 修改状态
customerList.js.state = function (obj,fid,fuid) {
    var state = $(obj).val();
    var param = {"fandianUser.state":state,"fandianUser.fandianId":fid,"fandianUser.resourceId":fuid};
    customerList.js.operFandianUser(param);
    // 如果状态值为:2没打通,自动将回访时间后调一天
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth()+1;
    var day = now.getDay();
    switch(state){
        case '2' : $(obj).next("input[name=recall_date_input]").datepicker('show');break;
        case '3' : $(obj).next("input[name=recall_date_input]").val(year+"-"+month+"-"+(day+1));break;
        case '4' : $(obj).next("input[name=recall_date_input]").datepicker('show');break;
        case '5' : $(obj).next("input[name=recall_date_input]").datepicker('show');break;

    }

};

// 更新回访日期
customerList.js.updateDate = function (obj) {
    var param = {"fandianUser.recallDate":$(obj).val(),"fandianUser.fandianId":$(obj).attr("fid"),"fandianUser.resourceId":$(obj).attr("fuid")};
    customerList.js.operFandianUser(param);
};

// 联系后台
customerList.js.operFandianUser = function(param){
    $.post(path+"/customerList/customerList_operFandianUser.action",param,function (data) {
        console.info(data);
    });
};