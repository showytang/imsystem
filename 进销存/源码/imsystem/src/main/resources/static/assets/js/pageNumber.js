/***
 * 加載調用方法
 * 		$(".panel-headline").append(page(vue.page.pageNum,vue.page.prePage,vue.page.nextPage,vue.page.pages));
 */

/**
 * 
 * 调用点击方法
 $(document).on("click",".pageFy>ul li",function(){
	 var create = $(this).attr("pageNumber");
	 if(create != null && create != 0){
		 vue.page = queryQianKuan(create, "", "", "");
		 $(".panel-headline").append(page(当前页,上一页,下一页,总页数));
	 }
 });
 * 
 * 
 * 
 * 
 * 
 */

/*******************************************************************************
 * 生成页码
 * 
 * @param currentPage
 * @param prevPage
 * @param nextPage
 * @param countPage
 * @returns
 */
function page(currentPage, prevPage, nextPage, countPage) {
	var prev;
	if (currentPage < 1 || prev == currentPage) {
		return;
	}

	$(".pageFy").remove();
	var nav = $("<nav class='pageFy'><ul class='pagination pagination-sm'><li pageNumber='"
			+ prevPage
			+ "' class='prev'><span> <span class='glyphicon glyphicon-menu-left'></span></span></li></ul></nav>");
	if (currentPage >= 1 && countPage <= 6) {

		for (var i = 1; i <= countPage; i++) {
			if (i == currentPage) {
				nav.children("ul").append(
						"<li class='active'><span>" + i + "</span></li>");
			} else {
				nav.children("ul").append(addLi(i));
			}
		}
	} else {

		if (countPage - currentPage >= 3) {
			if (currentPage != 1) {
				if (currentPage != 2) {
					nav.children("ul").append(addLi((currentPage - 2)));
				}
				nav.children("ul").append(addLi((currentPage - 1)));
			}
			nav.children("ul").append(addLi(currentPage).addClass("active"));
			nav.children("ul").append(addLi((parseInt(currentPage) + 1)));
			nav.children("ul").append(addLi((parseInt(currentPage) + 2)));
			nav.children("ul").append(addLi((parseInt(currentPage) + 3)));
			if (currentPage == 1) {
				nav.children("ul").append(addLi((parseInt(currentPage) + 4)));
				nav.children("ul").append(addLi((parseInt(currentPage) + 5)));
			}
			if (currentPage == 2) {
				nav.children("ul").append(addLi((parseInt(currentPage) + 4)));
			}
		} else {
			var s = 0;
			for (var i = 5; i >= 0; i--) {
				nav.children("ul").append(addLi((countPage - i)));
				if (currentPage == countPage - i) {
					nav.find("ul>li:eq(" + (s + 1) + ")").addClass("active");
				}
				s++;
			}
		}
	}
	nav
			.children("ul")
			.append(
					"<li pageNumber='"
							+ nextPage
							+ "'><span> <span aria-hidden='true' class='glyphicon glyphicon-menu-right'></span></span></li>");
	prev = currentPage;
	return nav;
}
/*******************************************************************************
 * 创建页码
 * 
 * @param number
 * @returns
 */
function addLi(number) {
	return $("<li pageNumber='" + number + "'><span>" + number + "</span></li>");
}