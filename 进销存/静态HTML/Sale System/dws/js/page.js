
/*
 页面要求
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
	$(".pageCurrent:eq("+index+")").removeClass("currentPage");
	$(".pageCurrent:eq("+(index+1)+")").addClass("currentPage");
}
function pageJian(index){
	$(".pageCurrent:eq("+index+")").removeClass("currentPage");
	$(".pageCurrent:eq("+(index-1)+")").addClass("currentPage");
}
$(function(){
		var s=0;
		$(".pageNext").click(function(){
			var currentPage = $(".currentPage");
			var index = $(".pageCurrent").index(currentPage);
			if(index == 0){
				pageJia(index);
				return;
			}
			if($("#pageDian").css("display") != "none"){
				$(".pageq").each(function(index,e){
					if(index == $(".pageq").length-1){
						$(e).text(parseInt($(e).text())+1)
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
				return;
			}
			if(parseInt($(".pageCurrent:eq("+(index)+")").text()) == parseInt($(".pageDi").text())-2){
				$("#pageDian").css("display","block");
				s=0;
			}
			if(parseInt($(".pageCurrent:eq("+(index)+")").text()) > parseInt($(".pageDi").text())-2){
				pageJian(index);
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
				
			}
			
		});
		
		$(".pageCurrent").click(function(){
			
			var index = $(".pageCurrent").index(this);
			
			var currentPage = $(".currentPage");
			
			var currentIndex = $(".pageCurrent").index(currentPage);
			
			var text = $(this).text();
			
			if(text == "1"){
				$(".pageCurrent").removeClass("currentPage");
				$(this).addClass("currentPage");
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
					
					$("#pageDian").css("display","block");
					
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
		});
});
