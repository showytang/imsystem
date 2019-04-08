/**
 * 首页顶部统计方法
 * 
 */
function queryTop(storeid, code, startTime, endTime) {
	var data;
	$.ajax({
		url : "/statistics/query",
		type : "post",
		async : false,
		data : {
			storeid : storeid,
			code : code,
			startTime : startTime,
			endTime : endTime
		},
		dataType : "json",
		success : function(result) {
			data = result;
		}
	});

	return data;

}
/**
 * 销售额、利润、订单数 统计图
 */
function queryDaysAgo(storeid) {
	var data;
	$.ajax({
		url : "/statistics/queryDaysAgo",
		type : "post",
		async : false,
		data : {
			storeid : storeid
		},
		dataType : "json",
		success : function(result) {
			data = result;
		}
	});

	return data;

}
var myDate = new Date;
var year = myDate.getFullYear();
var yue = myDate.getMonth() + 1;
var date = myDate.getDate();
/**
 * 获取开始时间
 * 
 * @returns
 */
function getStartTime() {
	return year + "-" + yue + "-" + date + " 00:00:00";
}
/**
 * 结束时间
 * 
 * @returns
 */
function getEndTime() {
	return year + "-" + yue + "-" + date + " 23:59:59";
}