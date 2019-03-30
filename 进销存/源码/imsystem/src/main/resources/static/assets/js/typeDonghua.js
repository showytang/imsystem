$(function() {
	$(".activePosition").css("width", $(".activePosition").next().width());
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

}

//类型滑动
function activeSpanStyle(obj) {

	//禁用点击事件，在动画未完成之前再次点击选项会异常
	$(obj).parents().find("span").css("pointer-events", "none");

	let activeSpan = $(".option-top-div").find(".active1");

	//获取上一个span的X轴坐标
	let parX = $(obj).parents().find(".activeColor").offset().left;
	//获取当前span的X轴坐标
	let nowX = $(obj).offset().left;

	//获取上一个span的Y轴坐标
	let parY = $(obj).parents().find(".activeColor").offset().top;
	//获取当前span的Y轴坐标
	let nowY = $(obj).offset().top;

	$(".option-top-div").find("span").removeClass("activeColor");

	//当前span的宽度
	var nowWidth = $(obj).width();

	//分开写直角转向
	//添加动画
	$(activeSpan).animate({
		marginLeft: "+=" + (nowX - parX) + "px",
		marginTop: "+=" + (nowY - parY) + "px"

	}, 500, function() {
		$(obj).addClass("activeColor");
		//背景滑块和当前选项宽度同步
		$(activeSpan).css("width", nowWidth);
		//恢复点击事件
		$(obj).parents().find("span").css("pointer-events", "");
	});

}