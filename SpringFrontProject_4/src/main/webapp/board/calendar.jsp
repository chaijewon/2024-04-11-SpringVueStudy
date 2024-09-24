<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <style>
@mixin font-heading-bolder {
 font-weight: 700;
 color: #242424;
}
@mixin font-heading-small-bolder {
 font-weight: 600;
 color: #242424;
}
@mixin font-heading-medium {
 font-weight: 500;
 color: #242424;
}

@mixin font-heading-regular {
 font-weight: 400;
 color: #242424;
}
</style> -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="
https://cdn.jsdelivr.net/npm/v-calendar-he@0.0.9/lib/v-calendar.min.js
"></script>
<link href="
https://cdn.jsdelivr.net/npm/v-calendar-he@0.0.9/lib/v-calendar.min.css
" rel="stylesheet">
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
	    	header: {
	            left: 'prev,next today',
	            center: 'title',
	            right: 'month,agendaWeek,agendaDay'
	        },
	        selectable: true,
	        selectHelper: true,
	        editable: true,
	        eventLimit: true,
	        events: function(start, end, timezone, callback) {
	            // AJAX를 통해 서버에서 일정 데이터를 가져옵니다.
	            //alert("서버로 이동")
	            $.ajax({
	                url: 'http://www.daum.net',
	                type: 'GET',
	                dataType: 'json',
	                success: function(events) {
	                    callback(events);
	                }
	            });
	        }
	      });
	    calendar.render();
	    });

    let app=Vue.createApp({
    	
    }).mount('.container')
  </script>
</body>
</html>