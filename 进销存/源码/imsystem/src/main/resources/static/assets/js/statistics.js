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
function queryDaysAgo(storeid,startTime,endTime) {
	var data;
	$.ajax({
		url : "/statistics/queryDaysAgo",
		type : "post",
		async : false,
		data : {
			storeid : storeid,
			startTime:startTime,
			endTime:endTime
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
function queryRanking(startTime,endTime,storeId){
	var v;
	$.ajax({
		url:"/statistics/queryRanking",
		type:"post",
		async : false,
		data:{
			startTime:startTime,
			endTime:endTime,
			storeId:storeId
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
function queryGoodsDetail(currentPage,time,startTime,endTime,storeId,gid,name){
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
			gid:gid,
			name:name
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
function queryJinHuo(currentPage,startTime,endTime,cid,sid){
	var v;
	$.ajax({
		url:"/statistics/queryJinHuo",
		type:"post",
		data:{
			currentPage:currentPage,
			startTime:startTime,
			endTime:endTime,
			cid:cid,
			storeId:sid
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
function queryStockByGidAndStoreId(currentPage,gid,storeId,name){
	var v;
	$.ajax({
		url:"/statistics/queryStockByGidAndStoreId",
		type:"post",
		data:{
			currentPage:currentPage,
			gid:gid,
			storeId:storeId,
			name:name
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
/**欠款（All）
 * @param startTime
 * @param endTime
 * @param sid
 * @returns
 */
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

/***
 * 收账查询
 * @param currentPage
 * @param startTime
 * @param endTime
 * @param sid
 * @returns
 */
function queryShouZhang(currentPage,startTime,endTime,cid,storeid){
	var v;
	$.ajax({
		url:"/statistics/queryShouZhang",
		type:"post",
		data:{
			currentPage:currentPage,
			startTime:startTime,
			endTime:endTime,
			cid,cid,
			storeid:storeid
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryShouZhang'");
		}
	});
	return v;
}

/**收賬（All）
 * @param startTime
 * @param endTime
 * @param sid
 * @returns
 */
function queryAllShouZhang(startTime,endTime,cid,storeid){
	var v;
	$.ajax({
		url:"/statistics/queryAllShouZhang",
		type:"post",
		data:{
			startTime:startTime,
			endTime:endTime,
			cid,cid,
			storeid:storeid
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryAllShouZhang'");
		}
	});
	return v;
}

/***
 * 查詢客戶
 * @param sid
 * @returns
 */
function queryCustomer(sid){
	var v;
	$.ajax({
		url:"/statistics/queryCustomer",
		type:"post",
		data:{
			sid:sid
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryCustomer'");
		}
	});
	return v;
}
/***
 * 查询店铺
 * @returns
 */
function queryStore(){
	var v;
	$.ajax({
		url:"/statistics/queryStore",
		type:"post",
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryStore'");
		}
	});
	return v;
}

/***
 * 查询商品
 * @returns
 */
function queryGoods(){
	var v;
	$.ajax({
		url:"/ther/queryGoods",
		type:"post",
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryGoods'");
		}
	});
	return v;
}

/***
 * 查询商品排名
 * @param storeId
 * @returns
 */
function queryAllGoodsDetail(storeId){
	var v;
	$.ajax({
		url:"/statistics/queryAllGoodsDetail",
		type:"post",
		data:{
			storeId:storeId
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'queryAllGoodsDetail'");
		}
	});
	return v;
}

/***
 * 查询供应商
 * @param storeId
 * @returns
 */
function querySupplier_yByStore(storeId){
	var v;
	$.ajax({
		url:"/ther/querySupplier_yByStore",
		type:"post",
		data:{
			sid:storeId
		},
		dataType:"json",
		async:false,
		success:function(data){
			v = data;
		},
		error:function(){
			console.log("ERROR:'querySupplier_yByStore'");
		}
	});
	return v;
}


/***
 * 获取店铺id
 * @returns
 */
function getStoreId(){
		var uid = JSON.stringify(window.localStorage.getItem("user")).id;
		var sid = "";
		if (uid != "") {
			if (uid == "1") {
				sid = "";
			} else {
				sid = JSON.stringify(window.localStorage.getItem("user")).storeid;
			}
		}
		return sid;
}

