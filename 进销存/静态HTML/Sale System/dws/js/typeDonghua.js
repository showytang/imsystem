
$(function(){
	$(".activePosition").css("width",$(".activePosition").next().width());
})

function optionAllStyle(obj) {
	$(obj).parent().find(".option-span-z").removeClass("active1");
	$(obj).parent().find(".option-span-z").animate({
		backgroundColor: "",
		color: "#000000"
	}, 300);

	$(obj).addClass("active1");
	$(obj).animate({
		backgroundColor: "#00AAFF",
		color: "#ffffff"
	}, 300);

}

//详细类型多选
function optionAddStyle(obj) {

	$(obj).parent().find(".option-span-all").removeClass("active1");

	$(obj).parent().find(".option-span-all").animate({
		backgroundColor: "",
		color: "#000000"
	}, 300);

	if($(obj).hasClass("active1")) {

		if($(obj).parent().find(".active1").length > 1) {

			$(obj).removeClass("active1");
			$(obj).animate({
				backgroundColor: "",
				color: "#000000"
			}, 300);
		}

	} else {

		$(obj).addClass("active1");
		$(obj).animate({
			backgroundColor: "#00AAFF",
			color: "#ffffff"
		}, 300);
	}

	if($(obj).parent().find(".active1").length == $(obj).parent().find(".option-span-z").length) {

		$(obj).parent().find(".option-span-z").removeClass("active1");
		$(obj).parent().find(".option-span-z").animate({
			backgroundColor: "",
			color: "#000000"
		}, 300);

		$(obj).parent().find(".option-span-all").addClass("active1");
		$(obj).parent().find(".option-span-all").animate({
			backgroundColor: "#00AAFF",
			color: "#ffffff"
		}, 300);

	}

}

//类型滑动
function activeSpanStyle(obj) {

	//禁用点击事件，在动画未完成之前再次点击选项会异常
	$(obj).parent().find("span").css("pointer-events", "none");

	let activeSpan = $(obj).parent().find(".active1");

	//获取上一个span的下标
	let parindex = $(obj).parent().find(".activeColor").index();
	//获取当前span的下标
	let nowindex = $(obj).index();
	//获取上一个span的X轴坐标
	let parX = $(obj).parent().find(".activeColor").position().left;
	//获取当前span的X轴坐标
	let nowX = $(obj).position().left;

	$(obj).parent().find("span").removeClass("activeColor");

	if(nowindex < parindex) {
		//添加动画
		$(activeSpan).animate({
			marginLeft: "+=" + (nowX - parX) + "px"
		}, 500);

	} else if(nowindex > parindex) {
		//添加动画
		$(activeSpan).animate({
			marginLeft: "+=" + (nowX - parX) + "px"
		}, 500);
	}

	//当前span的宽度
	var nowWidth = $(obj).width();

	setTimeout(function() {
		$(obj).addClass("activeColor");
		//背景滑块和当前选项宽度同步
		$(activeSpan).css("width", nowWidth);
		//恢复点击事件
		$(obj).parent().find("span").css("pointer-events", "");
	}, 500);
}