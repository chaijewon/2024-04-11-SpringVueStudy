<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px
}
.row{
   margin: 0px auto;
   width: 600px
}
</style>
<!-- 
     ES5  => type="text/javascript"
     ES6  => type="text/babel" => 생략 
 -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link href='https://cdn.jsdelivr.net/npm/@fullcalendar/icalendar@5.11.3/main.css' rel='stylesheet' />
<script src="
https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.js
"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div id="calendar"></div>
    </div>
  </div>
  <script>
     document.addEventListener('DOMContentLoaded', function() {
	    var calendarEl = document.getElementById('calendar');
	    var calendar = new FullCalendar.Calendar(calendarEl, {
	    	initialView: 'dayGridMonth',
	    	height:500,
	    	headerToolbar: {
	            left: 'prev,next today',
	            center: 'title'
	          },
	          validRange: {
	        	    start: '2024-09-25'
	          },
	          themeSystem: 'bootstrap',	// 이렇게 설정하면 다크모트 라이트모드 가능
	          editable: true,
	          droppable: true, // this allows things to be dropped onto the calendar !!!
	          dateClick: ((info) => {
	               location.href="http://daum.net"
	          })
	        });
	    calendar.render();
	    });

    let app=Vue.createApp({
    	
    }).mount('.container')
  </script>
</body>
</html>