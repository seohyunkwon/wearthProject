
//오늘 날짜 및 요일 구하기
	
  var today = new Date(); //오늘 날짜

  console.log("new Date() : " +  today);
  console.log("today.getFullYear() : " + today.getFullYear());
  console.log("today.getMonth() : " + today.getMonth());
  console.log("today.getDate() : " + today.getDate());
  console.log("today.getDay() : " + today.getDay());
	

	//특정 날짜의 요일 구하기
    function getInputDayLabel() {

        var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');

        var today = new Date('2023-08-03').getDay();
        var todayLabel = week[today];

        return todayLabel;
    }
		
// 원하는 날짜 영역에 내용 추가하기
function addContentToDay(lecNO, lecDate, lecName) {
	//var lecDate = $("#lecDate").text();
	//var lecName = $("#lecName").text();
    var tdElement = document.getElementById(lecDate); // 해당 날짜에 대한 td 요소 가져오기

    if (tdElement) {
        var existingContent = tdElement.innerHTML;
        var str = existingContent + "<br><div class='title'><a href='/school/lecture/detail/" + lecNO + "'>" + lecName + "</a></div>";
        tdElement.innerHTML = str;

        // 추가: lecDate를 콘솔에 출력하여 확인
        console.log("lecDate 데이터: " + lecDate);
    } else {
        console.log("해당 날짜의 td 요소를 찾을 수 없습니다: " + lecDate);
    }
}
	
	//그리기 스크립트
	var today = new Date(); //오늘 날짜        
	var date = new Date();
	
	//이전달
	function beforem() //이전 달을 today에 값을 저장
	{ 
		today = new Date(today.getFullYear(), today.getMonth() - 1, today.getDate());
		autoReload(); //만들기
	}
	
	//다음달
	function nextm()  //다음 달을 today에 저장
	{
		today = new Date(today.getFullYear(), today.getMonth() + 1, today.getDate());
		autoReload();
	}
	
	//오늘선택
	function thisMonth(){
		today = new Date();
		autoReload();
	}
	
	function autoReload()
	{
		var nMonth = new Date(today.getFullYear(), today.getMonth(), 1); //현재달의 첫째 날
		var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0); //현재 달의 마지막 날
		var tbcal = document.getElementById("calendar"); // 테이블 달력을 만들 테이블
		var yearmonth = document.getElementById("yearmonth"); //  년도와 월 출력할곳
		yearmonth.innerHTML = today.getFullYear() + "년  "+ (today.getMonth() + 1) + "월"; //년도와 월 출력

		if(today.getMonth()+1==12) //  눌렀을 때 월이 넘어가는 곳
		{
			before.innerHTML=("◁ "+today.getMonth())+"월";
			next.innerHTML="1월"+" ▷";
			
		}
		else if(today.getMonth()+1==1) //  1월 일 때
		{
			before.innerHTML="◁ "+"12월";
			next.innerHTML=(today.getMonth()+2)+"월" +" ▷";
		}
		else //   12월 일 때
		{
			before.innerHTML="◁ "+(today.getMonth())+"월";
			next.innerHTML=(today.getMonth()+2)+"월"+" ▷";
		}


		// 남은 테이블 줄 삭제
		while (tbcal.rows.length > 2) 
		{
			tbcal.deleteRow(tbcal.rows.length - 1);
		}
		var row = null;
		row = tbcal.insertRow();
		var cnt = 0;
		var dayCheck = (nMonth.getDay()==0) ? 7 : nMonth.getDay(); //일요일을 마지막으로 넣기 위해서.

		 // 1일 시작칸 찾기
		for (i = 0; i < (dayCheck-1); i++) 
		{
			cnt = cnt + 1;	//요일값
			cell = row.insertCell();
			
		}

		// 달력 출력
	    for (i = 1; i <= lastDate.getDate(); i++) // 1일부터 마지막 일까지
	    {
	        cell = row.insertCell();
	
	        var str = "";
	
	        str += "<div>" + i + "</div>";
	        var day = (i < 10) ? "0" + i : i;
	        var lecDate = today.getFullYear() + "-" + ("0" + (today.getMonth() + 1)).slice(-2) + "-" + day; // 날짜를 "YYYY-MM-DD" 형식으로 생성
	        str += "<div id='" + lecDate + "'></div>";
	        
			console.log("lecDate 데이터: " + lecDate);
			
	        cnt = cnt + 1;
        
			if (cnt % 7 == 6) {//토요일
			    cell.style.color = "#009de0";
			}
			if (cnt % 7 == 0) { //일요일
				cell.style.color = "#ed5353";
			}
			
			cell.innerHTML = str;
			
			if (cnt % 7 == 0) { //일요일
				row = calendar.insertRow();// 줄 추가
			}
			//마지막 날짜가 지나면 일요일까지 칸 그리기
			if(lastDate.getDate() == i && ((cnt % 7) != 0)){
				var add = 7 - (cnt % 7);
				for(var k = 1; k <= add; k++){
					cell = row.insertCell();
					cnt = cnt + 1;
				}
			}
			
			//오늘날짜배경색
			if( today.getFullYear() == date.getFullYear() && today.getMonth() == date.getMonth() && i==date.getDate() )
			{
				cell.style.backgroundColor = "#e2f3da"; //오늘날짜배경색
			}
			
			//마지막 날짜가 지나면 일요일까지 칸 그리기
			if(lastDate.getDate() == i && ((cnt % 7) != 0)){
				var add = 7 - (cnt % 7);
				for(var k = 1; k <= add; k++){
					cell = row.insertCell();
					cnt = cnt + 1;
					if (cnt % 7 == 6) {//토요일
						cell.style.backgroundColor = "#f7f7f7";
					}
					if (cnt % 7 == 0) { //일요일
						cell.style.backgroundColor = "#f7f7f7";
					}
				}
			}
		}
   		
   		var arr = $(".lec");
   		$.each(arr, function(){
			   var no = $(this).attr("lecNO");
			   var d = $(this).attr("lecDate");
			   var n = $(this).attr("lecName");
			  addContentToDay(no,d,n);
		   } )
	}
autoReload();
