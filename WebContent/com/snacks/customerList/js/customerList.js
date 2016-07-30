/**
 * Created by jerrywang on 16/7/29.
 */
$.namespace("customerList");
$(function () {

    $('.datepicker').datepicker();
    
    $.post(path+"/box/customerList_getList.action",{
    },function (data) {
        console.info(data.fandianList)
        var html = template('userList',{'result':data});
        $('userList').html(html);
        
    });
    customerList.js.getAll();
});

customerList.js = {};
customerList.js.getAll = function () {

};