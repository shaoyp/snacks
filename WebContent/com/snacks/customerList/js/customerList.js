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

            if(event.keyCode == "13"){
                // 保存微信号
                $.post(path+"/customerList/customerList_operFandianUser.action",{
                    "fandianUser.wechat":$(this).val(),"fandianUser.fandianId":$(this).attr("fid"),"fandianUser.resourceId":$(this).attr("fuid")
                },function (data) {
        
                });
                $(this).removeClass("not_save").blur();
            }
        });

    });
    //
    // customerList.js.getAll();
    
    
});

customerList.js = {};
// customerList.js.getAll = function () {
//
// };

customerList.js.state = function (obj,fid,fuid) {
    $.post(path+"/customerList/customerList_operFandianUser.action",{
        "fandianUser.state":$(obj).val(),"fandianUser.fandianId":fid,"fandianUser.resourceId":fuid
    },function (data) {
        console.info(data);
    });
};

customerList.js.updateDate = function (obj) {
    $.post(path+"/customerList/customerList_operFandianUser.action",{
        "fandianUser.recallDate":$(obj).val(),"fandianUser.fandianId":$(obj).attr("fid"),"fandianUser.resourceId":$(obj).attr("fuid")
    },function (data) {
        console.info(data);
    });
};