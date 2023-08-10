var isLiked = {};

function likeOrUnlike(id) {
  var heartImage = document.getElementById(id);
 	var header = $("meta[name='_csrf_header']").attr('content');
	var token = $("meta[name='_csrf']").attr('content');
  console.log("id : "+ id);
  
  if (!isLiked[id]) {
    heartImage.src = "/images/education/redHeart.jpg";
    isLiked[id] = true;
    $.ajax({
		url : "/school/education/liked/insert",
		type : "post",
		data : {eduNO : id},
		beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		}
	});
  } else {
    heartImage.src = "/images/education/whiteHeart.jpg";
    isLiked[id] = false;
      $.ajax({
		url : "/school/education/liked/delete",
		type : "post",
		data : {eduNO : id},
		beforeSend : function(xhr){
			xhr.setRequestHeader(header, token);
		}
	});
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