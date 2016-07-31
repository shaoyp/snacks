/**
 * Created by jerrywang on 16/7/29.
 */
jQuery.namespace("customerList");

$(function () {

    $('.datepicker').datepicker();
    
    $.post(path+"/customerList/customerList_getList.action",{
    },function (data) {
        var html = template('grid_template',{'result':data.fandianList});
        $('#grid_ul').html(html);
        
    });

    customerList.js.getAll();
    
    
});

customerList.js = {};
customerList.js.getAll = function () {

};

customerList.js.state = function (obj,id) {
    $.post(path+"/customerList/customerList_operFandianUser.action",{
        "fandianUser.state":$(obj).val(),"fandianUser.fandianId":id
    },function (data) {
        console.info(data);
    });
}