/*
 页面要求
 * 
 * js:{
 * 		
 * 		定义下一页、上一页、和点击的方法必须是floatPage()不需要参数
 * 
 * 		初始化分页方法page(data) data: 是一个vue对象 vue里面分页的对象名字为pageIf
 * 		
 * }
 * 
 css:


 .pagebtn{
 height: 28px;
 width: 25px;
 border: 1px solid #C0C0C0;
 border-radius: 3px;
 list-style: none;
 text-align: center;
 line-height: 28px;
 cursor: pointer;
 }
 #page>ul{
 display: flex;
 justify-content: space-around;
 padding: 0px;
 font-size: 12px;
 }
 #page{
 width: 300px;
 margin: 20px auto ;
 }
 .currentPage{
 background: #1094ce;
 color: white;
 border: none;
 }




 * 
 * <div id="page">
				</div>
 * 
 * 
 * 
 * */

function pageJia(index) {
	$(".pageCurrent").removeClass("currentPage");
	$(".pageCurrent:eq(" + (index + 1) + ")").addClass("currentPage");
}
function pageJian(index) {
	$(".pageCurrent").removeClass("currentPage");
	$(".pageCurrent:eq(" + (index - 1) + ")").addClass("currentPage");
}
function page(data) {

	var pages = data.pageIf.pages;
	var bool = pages > 6 ? false : true;
	

	if(pages == 0){
		return;
	}
	
	var pageNum = data.pageIf.pageNum;
	
	var bool = pages > 6 ? true : false;

	var ul = $("<ul>"
			+ "<li class=\"pagebtn pagePrev\" onclick=\"prevPage()\"><span"
			+ "class=\"glyphicon glyphicon-menu-left\"></span></li>"
			+ "<li onclick=\"currentPage(this)\" class=\"pagebtn  pageCurrent pageq\">1</li>"
			+ "<li onclick=\"currentPage(this)\" class=\"pagebtn pageCurrent pageq\">2</li>"
			+ "<li onclick=\"currentPage(this)\" class=\"pagebtn pageCurrent pageq\">3</li>"
			+ "<li class=\"pagebtn\" id=\"pageDian\""
			+ "style=\"border: none; display: block; background: #DDDDDD; font-size: 20px;\">...</li>"
			+ "<li onclick=\"currentPage(this)\" class=\"pagebtn pageCurrent pageDi\">14</li>"
			+ "<li onclick=\"currentPage(this)\" class=\"pagebtn pageCurrent\">15</li>"
			+ "<li onclick=\"currentPage(this)\" class=\"pagebtn pageCurrent\">16</li>"
			+ "<li class=\"pagebtn pageNext\" onclick=\"nextPage()\"><span"
			+ "class=\"glyphicon glyphicon-menu-right\"></span></li>" + "</ul>");
	ul.find(".pageCurrent:eq("+(data.pageIf.pageNum-1)+")").addClass("currentPage")
	if (bool) {

	if (pages > 6) {

		ul.find("#pageDian").show();

	} else {
		ul.find("#pageDian").hide();
	}
	
	if(bool == false){
		for(var i = 0; i < pages; i++ ){
			
			ul.find(".pageCurrent:eq(" + i + ")").text(i + 1);
			
		}
		
		ul.find(".pageCurrent:gt(" + (pages-1) + ")").remove();
		
		ul.find(".pageCurrent:eq(" + (pageNum-1) + ")").addClass("currentPage");
		
		ul.find(".pageCurrent:eq(" + (pages-1) + ")").addClass("pageDi");
		
		$("#page").html("");

		$("#page").append(ul);
		
		return;
	}
	
	if (pageNum == 1) {
		var s = 3;
		for (var i = 0; i < pages; i++) {

			if (bool) {
				if (i >= pages - 3) {

					ul.find(".pageCurrent:eq(" + s + ")").text(i + 1);
					s++;
				}
				if (i < 3) {
					ul.find(".pageCurrent:eq(" + i + ")").text(i + 1);
				}
			} else {
				ul.find(".pageCurrent:eq(" + i + ")").text(i + 1);
			}

		}
		
		ul.find(".pageCurrent:eq(" + 0 + ")").addClass("currentPage");
		
	} else {
		if (pageNum >= pages - 4) {
			var s = 5;
			var curr = 0;
			for (var i = pages; i > pages - 6; i--) {
				if(i == pageNum){
					curr = s;
				}
				ul.find(".pageCurrent:eq(" + s + ")").text(i);
				s--;
			}
			ul.find("#pageDian").hide();
			ul.find(".pageCurrent:eq(" + curr + ")").addClass("currentPage");
			ul.find(".pageCurrent:gt(" + s + ")").remove();

		} else {

			var s = 0;
			
			ul.find(".pageCurrent:eq(" + s + ")").text(pageNum-1);
			
			for(var i = pageNum ; i < pageNum+2; i++){
				
				s++;
				
				ul.find(".pageCurrent:eq(" + s + ")").text(i);
				
			}
			
			for(var i = 5 ; i > 2; i--){
				
				ul.find(".pageCurrent:eq(" + i + ")").text(pages--);
				
			}
			
			ul.find(".pageCurrent:eq(" + 1 + ")").addClass("currentPage");
		}
	}

	$("#page").html("");

	$("#page").append(ul);

}
var s = 0;
function nextPage() {
	var currentPage = $(".currentPage");
	var index = $(".pageCurrent").index(currentPage);
	if($(".pageCurrent").length == 1){
		return;
	}
	if (index == 0 || $(".pageCurrent").length < 6) {
		pageJia(index);
		floatPage();
		return;
	}
	if ($("#pageDian").css("display") != "none") {
		$(".pageq").each(function(index, e) {
			if (index == $(".pageq").length - 1) {
				$(e).text(parseInt($(e).text()) + 1);
				return;
			}
			$(e).text($(".pageq:eq(" + (index + 1) + ")").text());
		});
		floatPage();
	}
	if (parseInt($(".pageCurrent:eq(" + (index + 1) + ")").text()) >= parseInt($(
			".pageDi").text()) - 1) {
		if (s == 0) {
			$("#pageDian").css("display", "none");
			s++;
		} else {
			pageJia(index);
		}
		floatPage();
		return;
	}
};

function prevPage(th) {
	var currentPage = $(".currentPage");
	var index = $(".pageCurrent").index(currentPage);
	if ($(".pageCurrent:eq(" + (index) + ")").text() == 1) {
		return;
	}
	if ($(".pageCurrent:eq(" + (index) + ")").text() <= 2) {
		pageJian(index);
		floatPage();
		return;
	}
	if (parseInt($(".pageCurrent:eq(" + (index) + ")").text()) == parseInt($(
			".pageDi").text()) - 2) {
		$("#pageDian").css("display", "block");
		s = 0;
	}
	if (parseInt($(".pageCurrent:eq(" + (index) + ")").text()) > parseInt($(
			".pageDi").text()) - 2) {
		pageJian(index);
		floatPage();
		return;
	} else {
		$(".pageq")
				.each(
						function(index, e) {
							if (index == 0) {
								$(e).text(parseInt($(e).text()) - 1)
								return;
							}
							$(e)
									.text(
											parseInt($(
													".pageq:eq(" + (index - 1)
															+ ")").text()) + 1);
						});
		floatPage();

	}

};

function currentPage(th) {

	var index = $(".pageCurrent").index(th);

	var currentPage = $(".currentPage");

	var currentIndex = $(".pageCurrent").index(currentPage);

	if (index == currentIndex) {
		return;
	}

	var text = $(th).text();

	if (text == "1" || $(".pageCurrent").length < 6) {
		$(".pageCurrent").removeClass("currentPage");
		$(th).addClass("currentPage");
		floatPage();
		return;
	}

	if (index != currentIndex) {
		var zhi = parseInt($(".pageCurrent:eq(" + index + ")").text() - 2);
		if (zhi + 2 >= parseInt($(".pageDi").text()) - 2) {

			$("#pageDian").css("display", "none");

			var dishu = parseInt($(".pageDi").text()) - 4;
			$(".pageq").each(function(index, e) {
				$(e).text(++dishu);
			});
			s = 1;
		} else {
			if ($(".pageCurrent").length >= 5) {

				$("#pageDian").css("display", "block");

			}

			s = 0;

			$(".pageq").each(function(index, e) {
				$(e).text(++zhi);
			});
		}
		$(".pageCurrent").removeClass("currentPage");
		$(".pageCurrent").each(function(index, e) {
			if ($(e).text() == text) {
				$(e).addClass("currentPage");
			}
		});
	}
	floatPage();
};
