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
 <link href='https://unpkg.com/@fullcalendar/core@4.1.0/main.css' rel='stylesheet' />
  <link href='https://unpkg.com/@fullcalendar/daygrid@4.1.0/main.css' rel='stylesheet' />
  <script src='https://unpkg.com/@fullcalendar/core@4.1.0/main.js'></script>
  <script src='https://unpkg.com/@fullcalendar/daygrid@4.1.0/main.js'></script>
  <script src="https://unpkg.com/@fullcalendar/vue@4.1.0/main.umd.js"></script>
</head>
<body>
  <div class="container">
    <div class="row">
     <template>
      <FullCalendar :options="calendarOptions"/>
     </template>
    </div>
  </div>
  <script>
    let app=Vue.createApp({
    	data(){
    		return {
    			calendarOptions: {
    		        initialView: 'dayGridMonth',
    		        dateClick: this.handleDateClick,
    		        events: [
    		          { title: 'event 1', date: '2019-04-01' },
    		          { title: 'event 2', date: '2019-04-02' }
    		        ]
    		      }
    		    }
    	},
    	components:{
    		FullCalendar:window.FullCalendarVue.default
    	}
    }).mount('.container')
  </script>
</body>
</html>