
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
		<ul>
			<li class="pagebtn pagePrev"><span class="glyphicon glyphicon-menu-left"></span></li>
			<li class="pagebtn currentPage pageCurrent pageq">1</li>
			<li class="pagebtn pageCurrent pageq">2</li>
			<li class="pagebtn pageCurrent pageq">3</li>
			<li class="pagebtn" id="pageDian" style="border: none;background: white;font-size: 20px;">...</li>
			<li class="pagebtn pageCurrent pageDi">14</li>
			<li class="pagebtn pageCurrent">15</li>
			<li class="pagebtn pageNext"><span class="glyphicon glyphicon-menu-right"></span></li>
		</ul>
	</div>
 * 
 * 
 * 
 * */

function pageJia(index){
	$(".pageCurrent").removeClass("currentPage");
	$(".pageCurrent:eq("+(index+1)+")").addClass("currentPage");
}
function pageJian(index){
	$(".pageCurrent").removeClass("currentPage");
	$(".pageCurrent:eq("+(index-1)+")").addClass("currentPage");
}
function page(data){
	
	var pages = data.pageIf.pages;
	
	var bool = pages > 6 ? false:true;
	
	pageJian(1)
	
	if(bool){
		$("#pageDian").hide();
		$(".pageCurrent:gt("+(pages-1)+")").hide();
	}
	else{
		$("#pageDian").show();
		$(".pageCurrent").show();
	}
	for(var i = 0 ; i < pages ; i++){
		
		if(i >= (pages - 4) && bool == false){
			
			if(bool == false){
				
				$(".pageCurrent:eq("+i+")").text((i+2));
			}
		}
		else{
			
			$(".pageCurrent:eq("+i+")").text((i+1));
		}
			
	}
	
}
$(function(){
		var s=0;
		$(".pageNext").click(function(){
			var currentPage = $(".currentPage");
			var index = $(".pageCurrent").index(currentPage);
			if(index == 0){
				pageJia(index);
				floatPage();
				return;
			}
			if($("#pageDian").css("display") != "none"){
				$(".pageq").each(function(index,e){
					if(index == $(".pageq").length-1){
						$(e).text(parseInt($(e).text())+1);
						return;
					}
					$(e).text($(".pageq:eq("+(index+1)+")").text());
				});
			}
			if(parseInt($(".pageCurrent:eq("+(index+1)+")").text()) >= parseInt($(".pageDi").text())-1){
				if(s == 0){
					$("#pageDian").css("display","none");
					s++;
				}
				else{
					pageJia(index);
				}
				floatPage();
				return;
			}
		});
		
		$(".pagePrev").click(function(){
			var currentPage = $(".currentPage");
			var index = $(".pageCurrent").index(currentPage);
			if($(".pageCurrent:eq("+(index)+")").text() == 1){
				return;
			}
			if($(".pageCurrent:eq("+(index)+")").text() <= 2){
				pageJian(index);
				floatPage();
				return;
			}
			if(parseInt($(".pageCurrent:eq("+(index)+")").text()) == parseInt($(".pageDi").text())-2){
				$("#pageDian").css("display","block");
				s=0;
			}
			if(parseInt($(".pageCurrent:eq("+(index)+")").text()) > parseInt($(".pageDi").text())-2){
				pageJian(index);
				floatPage();
				return;
			}
			else{
				$(".pageq").each(function(index,e){
					if(index == 0){
						$(e).text(parseInt($(e).text())-1)
						return;
					}
					$(e).text(parseInt($(".pageq:eq("+(index-1)+")").text())+1);
				});
				floatPage();
				
			}
			
		});
		
		$(".pageCurrent").click(function(){
			
			
			var index = $(".pageCurrent").index(this);
			
			var currentPage = $(".currentPage");
			
			var currentIndex = $(".pageCurrent").index(currentPage);

			if(index == currentIndex){
				return;
			}
			
			var text = $(this).text();
			
			if(text == "1"){
				$(".pageCurrent").removeClass("currentPage");
				$(this).addClass("currentPage");
				floatPage();
				return;
			}
			
			if(index != currentIndex){
				var zhi = parseInt($(".pageCurrent:eq("+index+")").text()-2);
				if(zhi+2 >= parseInt($(".pageDi").text())-2){
					
					$("#pageDian").css("display","none");
					
					var dishu = parseInt($(".pageDi").text())-4;
					$(".pageq").each(function(index,e){
						$(e).text(++dishu);			
					});
					s=1;
				}else{
					if($(".pageCurrent").length > 5){
						
						$("#pageDian").css("display","block");
						
					}
						
					s=0;
					
					$(".pageq").each(function(index,e){
						$(e).text(++zhi);			
					});
				}
				$(".pageCurrent").removeClass("currentPage");
				$(".pageCurrent").each(function(index,e){
					if($(e).text() == text){
						$(e).addClass("currentPage");
					}
				});
			}
			floatPage();
		});
});
