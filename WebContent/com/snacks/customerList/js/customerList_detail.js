/**
 * Created by Jerry Wang on 16/8/5.
 */
$.namespace("customerList_detail");
$(function () {
    
    $.post(path+"/customerList/customerList_getCaipinByFandianId.action",{"caipinPage":1},function (data) {
        var html = template('caipin_template',{'result':data.caipinList});
        // 渲染列表
        $("#caipin_table").html(html);
        // 初始化分页组件
        $('#detail_callBackPager').extendPagination({
            totalCount: data.caipinCount,
            showPage: 10,
            limit: 10,
            curr:1,
            callback: function (curr, limit, totalCount) {
                $.post(path+"/customerList/customerList_getCaipinByFandianId.action",{"caipinPage":curr},function (data) {
                    var html = template('caipin_template',{'result':data.caipinList});
                    // 渲染列表
                    $("#caipin_table").html(html);
                });
            }
        });
    });

});

customerList_detail.js = {};

