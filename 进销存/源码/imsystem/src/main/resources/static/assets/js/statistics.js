/**
 * 首页顶部统计
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
/*******************************************************************************
 * 获取Year
 * 
 * @returns
 */
function getThisYear() {
	return year;
}
/**
 * 获取当前月
 * 
 * @returns
 */
function getCurrentMonth() {
	return yue;
}
/**
 * 结束时间
 * 
 * @returns
 */
function getEndTime() {
	return year + "-" + yue + "-" + date + " 23:59:59";
}
/*******************************************************************************
 * 店铺排名查询
 * 
 * @param startTime
 * @param endTime
 * @returns
 */
function queryRanking(startTime,endTime){
	var v;
	$.ajax({
		url:"/statistics/queryRanking",
		type:"opst",
		async : false,
		data:{
			startTime:startTime,
			endTime:endTime
		},
		dataType:"json",
		success:function(data){
			v = data;
		},
		error:function(){
			v = null;
		}
		
	});
	return v;
}
/*******************************************************************************
 * 查询今年每月盈利额
 * 
 * @param year
 * @param storeId
 * @returns
 */
function queryThisYear(year,storeId){
	var resp;
	$.ajax({
		url:"/statistics/queryThisYear",
		type:"post",
		data:{
			year:year,
			storeId:storeId
		},
		async : false,
		dataType:"json",
		success:function(data){
			resp = data;
		},
		error:function(){
			console.log("ERROR:'queryThisYear'");
			resp = null;
		}
	});
	return resp;
}
/*******************************************************************************
 * 查询商品排名
 * 
 * @param time
 *            年月 : '2019-06'
 * @param startTime
 * @param endTime
 * @param storeId
 * @returns
 */
function queryGoodsRanking(time,startTime,endTime,storeId){
	var value;
	$.ajax({
		url:"/statistics/queryGoodsRanking",
		type:"post",
		data:{
			time:time,
			startTime:startTime,
			endTime:endTime,
			storeId:storeId
		},
		dataType:"json",
		async:false,
		success:function(data){
			value = data;
		},
		error:function(){
			console.log("ERROR:'queryGoodsRanking'");
			value = null;
		}
	});
	return value;
}
/*******************************************************************************
 * 查询明细
 * 
 * @param currentPage
 * @param time
 * @param startTime
 * @param endTime
 * @param storeId
 * @param gid
 * @returns
 */
function queryGoodsDetail(currentPage,time,startTime,endTime,storeId,gid){
	var v;
	$.ajax({
		url:"/statistics/queryGoodsDetail",
		type:"post",
		data:{
			currentPage:currentPage,
			time:time,
			startTime:startTime,
			endTime:endTime,
			storeId:storeId,
			gid:gid
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryGoodsDetail'");
		}
	});
	return v;
}

/**
 * 进货统计
 * 
 * @param currentPage
 * @param time
 * @param startTime
 * @param endTime
 * @param storeId
 * @param cid
 * @returns
 */
function queryJinHuo(currentPage,startTime,endTime,cid){
	var v;
	$.ajax({
		url:"/statistics/queryJinHuo",
		type:"post",
		data:{
			currentPage:currentPage,
			startTime:startTime,
			endTime:endTime,
			cid:cid
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryGoodsDetail'");
		}
	});
	return v;
}
/*******************************************************************************
 * 库存统计
 * 
 * @param currentPage
 * @param gid
 * @param storeId
 * @returns
 */
function queryStockByGidAndStoreId(currentPage,gid,storeId){
	var v;
	$.ajax({
		url:"/statistics/queryStockByGidAndStoreId",
		type:"post",
		data:{
			currentPage:currentPage,
			gid:gid,
			storeId:storeId
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryStockByGidAndStoreId'");
		}
	});
	return v;
}
/*******************************************************************************
 * 查询欠款
 * 
 * @param currentPage
 * @param startTime
 * @param endTime
 * @param sid
 * @returns
 */
function queryQianKuan(currentPage,startTime,endTime,sid){
	var v;
	$.ajax({
		url:"/statistics/queryQianKuan",
		type:"post",
		data:{
			currentPage:currentPage,
			startTime:startTime,
			endTime:endTime,
			sid,sid
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryQianKuan'");
		}
	});
	return v;
}

function queryAllQianKuan(startTime,endTime,sid){
	var v;
	$.ajax({
		url:"/statistics/queryAllQianKuan",
		type:"post",
		data:{
			startTime:startTime,
			endTime:endTime,
			sid,sid
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryAllQianKuan'");
		}
	});
	return v;
}