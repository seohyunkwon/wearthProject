// 좋아요 이미지 변경 자바스크립트
var isLiked = {};

function changeImage(id) {
  var heartImage = document.getElementById(id);
  if (!isLiked[id]) {
    heartImage.src = "/images/education/redHeart.jpg";
    isLiked[id] = true;
  } else {
    heartImage.src = "/images/education/whiteHeart.jpg";
    isLiked[id] = false;
  }
}


// 검색 기능 category, search 값 받아서 url로 넘기기 

$(function(){
	
	$("#btnSearch").click(function(){
		var category = $("#category").val();
		var search = $("#search").val();
		
		console.log("category :"+category);
		console.log("search :"+search);
		if( search != null){
			location.href="/school/education/list/" + category + "/" + search+ "/1";
		}
	})
	
})