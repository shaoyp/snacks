/**
 * Created by jerrywang on 16/7/29.
 */
$.namespace("customerList");
$(function () {
    customerList.js.getAll();
});

customerList.js = {};
customerList.js.getAll = function () {

    $.post(path+"/demo/getDemoList.do",{
    },function (data) {
        console.info(data)
        var html = template('userList',{'result':data});
        $('userList').html(html);
    });
};