/**
 * Created by jerrywang on 16/7/30.
 */
$.namespace("box")
$(function () {


    var pt = getParameter(location.hash,"pt","");
    if(pt==""){
        $('#content').load(path+"/customerList/customerList_show.action");
    }else{
        $("#sidebar").find("li").removeClass("active");
        $("#sidebar").find("a").each(function () {
            var onclick = $(this).attr("onclick");
            if(onclick != undefined && onclick.indexOf(pt) >0 ) {
                $(this).parent().addClass("active");
                return;
            }
        });
        $('#content').load(pt);
    }
    $(window).hashchange(function () {
        var pt = getParameter(location.hash,"pt","");
        if(pt != ""){
            box.js.load(pt);
        }
    });

});
box.js = {};
box.js.menucheck = function(menupath,pid,cid,obj){
    setHash('#pt='+menupath);
    $("#sidebar").find("li").removeClass("active");
    $(obj).parent().addClass("active");
};
box.js.load = function (to) {

    $('#content').load(to);

};