/**
 * Created by jerrywang on 16/7/29.
 */
$.namespace("dataHandle");
dataHandle.js = {};
dataHandle.js.getAll = function () {
};

//合并外卖数据（fandiandata）
dataHandle.js.mergeData = function (obj) {
	$.post(path+"/dataHandle/dataHandle_mergeData.action",{},function(data){
	});
};

//合并饭店数据（fandian）
dataHandle.js.mergeFandian = function (obj) {
	$.post(path+"/dataHandle/dataHandle_mergeFandian.action",{},function(data){
	});
};

//合并坐标点（fandian）
dataHandle.js.mergeZuobiao = function (obj) {
	$.post(path+"/dataHandle/dataHandle_mergeZuobiao.action",{},function(data){
	});
};

//导出菜品 （caipin）
dataHandle.js.mergeCaipin = function (obj) {
	$.post(path+"/dataHandle/dataHandle_mergeCaipin.action",{},function(data){
	});
};

$(function(){
	
});