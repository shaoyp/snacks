/**
 * Created by jerrywang on 16/7/29.
 */
jQuery.namespace("customerList");

$(function () {
    
    // select组件初始化
    $.post(path+"/customerList/customerList_getCodeArea.action",{},function (data) {
        var codeString = "<option value=''>请选择</option>";
        for(var i=0;i<data.codeAreaList.length;i++){
            codeString += "<option value='"+data.codeAreaList[i].resource_id+"'>"+data.codeAreaList[i].area_name+"</option>"
        }
        $("#query_area").html(codeString).select2();
    });

    // 初始化列表数据
    $.post(path+"/customerList/customerList_getList.action",{
        "param.start":0
    },function (data) {

        // 清理dom节点中之前的日期组件,防止报错
        $('.datepicker').remove();

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
                // $(this).removeClass("not_save").blur();
                customerList.js.pageTo();
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
                // $(this).removeClass("not_save").blur();
                customerList.js.pageTo();
            }
        });

        // 初始化分页组件
        $('#callBackPager').extendPagination({
            totalCount: data.count,
            showPage: 10,
            limit: 10,
            curr:data.page,
            callback: function (curr, limit, totalCount) {
                customerList.js.pageTo(curr);
            }
        });

        // 初始化查询项的值
        $("#query_box").find("input,select").each(function () {
            if($(this)[0].type == "text"){
                $(this).val(data[$(this).attr("id")]);
            }else{
                $("#query_area").val(data.query_area).trigger("change");
            }
        });


    });
    
});

customerList.js = {};

customerList.js.pageTo = function(curr){

    var param = {};
    if(curr != undefined){
        param = {"page" : curr};
    }

    $.post(path+"/customerList/customerList_getList.action",param,function (data) {

        // 清理dom节点中之前的日期组件,防止报错
        $('.datepicker').remove();
        // $('input[name=wechat_input]').remove();

        var html = template('grid_template',{'result':data.fandianList});
        // 渲染列表
        $('#grid_ul').html(html);
        // 绑定日期组件
        $('.datepicker').datepicker().on('changeDate',function() {

            customerList.js.updateDate($(this));
            $(this).blur();
        });;
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
    var recall_date = null;
    // 如果状态值为:2没打通,自动将回访时间后调一天
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth()+1;
    var day = now.getDay();
    // var recallInput = $(obj).next("input[name=recall_date_input]");
    switch(state){
        case '2' : recall_date = year+"-"+month+"-"+(day+1);break;
        case '3' : recall_date = year+"-"+month+"-"+(day+1);break;
        case '4' : recallInput.datepicker('show');break;
        case '5' : recallInput.datepicker('show');break;

    }
    var param = {"fandianUser.state":state,"fandianUser.fandianId":fid,"fandianUser.resourceId":fuid,"fandianUser.recallDate":recall_date};
    customerList.js.operFandianUser(param);
    customerList.js.pageTo();


};

// 更新回访日期
customerList.js.updateDate = function (obj) {
    var param = {"fandianUser.recallDate":$(obj).val(),"fandianUser.fandianId":$(obj).attr("fid"),"fandianUser.resourceId":$(obj).attr("fuid")};
    customerList.js.operFandianUser(param);
    customerList.js.pageTo();
};

// 联系后台
customerList.js.operFandianUser = function(param){
    $.post(path+"/customerList/customerList_operFandianUser.action",param,function (data) {
    });
};
// 更多按钮点击事件
customerList.js.more = function (_this) {
    if($(_this).attr("value") == 0){
        // 显示更多
        $("div[name=more_div]").removeClass("hidden");
        $(_this).attr("value",1).html("更少");
    }else{
        // 隐藏更多
        $("div[name=more_div]").addClass("hidden");
        $(_this).attr("value",0).html("更多");
    }
};
// 清楚搜索项
customerList.js.clearQueryData = function () {
    $("#query_box").find("input").each(function () {
            $(this).val("");
    });
    $("#query_area").val(null).trigger("change");
};
// 查询按钮点击事件
customerList.js.query = function (){
    var param = {};
    $("#query_box").find("input,select").each(function () {
        param[$(this).attr("id")]=$(this).val();
    });
    param["start"] = 0;

    $.post(path+"/customerList/customerList_getList.action",param,function (data) {

        // 清理dom节点中之前的日期组件,防止报错
        $('.datepicker').remove();

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
                // $(this).removeClass("not_save").blur();
                customerList.js.pageTo();
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
                // $(this).removeClass("not_save").blur();
                customerList.js.pageTo();
            }
        });

        // 初始化分页组件
        $('#callBackPager').extendPagination({
            totalCount: data.count,
            showPage: 10,
            limit: 10,
            curr:data.page,
            callback: function (curr, limit, totalCount) {
                customerList.js.pageTo(curr);
            }
        });


    });
};

customerList.js.openDetail = function (obj) {
    var index = layer.open({
        type: 2,
        title: "添加",
        closeBtn: 1, //不显示关闭按钮
        area: ['340px','560px'],
        shift: 0,
        maxmin: true,//是否带有全屏按钮
        content: [path+'/customerList/customerList_show.action','no'], //iframe的url，no代表不显示滚动条
        success: function(){ //弹出成功打开

        },
        end: function () { // 弹出层关闭

        }
    });
    layer.full(index);
};