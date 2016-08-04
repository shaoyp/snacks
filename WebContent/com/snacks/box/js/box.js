/**
 * Created by jerrywang on 16/7/30.
 */
$.namespace("box")
$(function () {



    var pt = getParameter(location.hash,"pt","");
    if(pt==""){
        console.info(path+"/customerList/customerList_show.action")
        $('#content').load(path+"/customerList/customerList_show.action");
    }else{
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
}
box.js.load = function (to) {

    // $.ajaxSetup ({
    //     cache: false //关闭AJAX相应的缓存
    // });

    console.info(to)
    $('#content').load(to);
    // var mo = to.split("/");
    // $.getScript("/snacks/com/snacks/"+mo[2]+"/js/"+mo[2]+".js");

    // $.get(to,function(data){
    //     $("#content").html(data);
    // });

};