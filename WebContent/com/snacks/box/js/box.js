/**
 * Created by jerrywang on 16/7/30.
 */
$.namespace("box")
$(function () {
    var pt = getParameter(location.hash,"pt","");
    $(window).hashchange(function () {
        var pt = getParameter(location.hash,"pt","");
        if(pt != ""){
            box.js.load(pt);
        }
    });
    if(pt != "") {
        box.js.load(pt);
    }
});
box.js = {};
box.js.menucheck = function(menupath,pid,cid,obj){
    // $('.sidebar_li_02').removeClass("active");
    // $(obj).addClass("active");
    setHash('pt='+menupath);
}
box.js.load = function (to) {
    $('#content').load(to);
}