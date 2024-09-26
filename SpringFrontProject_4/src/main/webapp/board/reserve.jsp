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
   width: 1100px
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
     <table class="table">
       <tr>
         <td width=20% class="text-center" height="500">
           <table class="table">
            <caption><h3>맛집 정보</h3></caption>
           </table>
         </td>
         <td width=50% class="text-center" height="500">
           <table class="table">
            <caption><h3>예약일 정보</h3></caption>
            <tr>
              <td>
                <div id="calendar"></div>
              </td>
            </tr>
           </table>
         </td>
         <td width=30% class="text-center" rowspan="2">
           <table class="table">
            <caption><h3>예약정보</h3></caption>
            <tr>
              <td class="text-left">예약일:{{day}}</td>
            </tr>
            <tr>
              <td class="text-left">인원:{{inwon}}명</td>
            </tr>
           </table>
         </td>
       </tr>
       <tr>
         <td width=35% class="text-center">
           <table class="table" height="200">
            <caption><h3>시간 정보</h3></caption>
           </table>
         </td>
         <td width=35% class="text-center" height="200">
           <table class="table">
            <caption><h3>인원 정보</h3></caption>
            <tr>
             <td class="text-center">
               <span class="btn btn-xs btn-success" v-for="i in time" style="margin-left:2px" @click="inwonSelect(i)">{{i}}</span>
             </td>
            </tr>
           </table>
         </td>
       </tr>
     </table>
    </div>
  </div>
  <script>
    let app=Vue.createApp({
    	data(){
    		return {
    			day:'2024-09-25',
    			time:[],
    			inwon:0
    		}
    	},
    	mounted(){
    		let date = new Date();
    	    let year = date.getFullYear();
    	    let month = ("0" + (1 + date.getMonth())).slice(-2);
    	    let day = ("0" + date.getDate()).slice(-2);
    		for(let i=0;i<10;i++)
    		{
    			this.time.push(i+1)
    		}
    		let _this=this
    		document.addEventListener('DOMContentLoaded', function() {
    		    var calendarEl = document.getElementById('calendar');
    		    var calendar = new FullCalendar.Calendar(calendarEl, {
    		    	initialView: 'dayGridMonth',
    		    	headerToolbar: {
    		            left: 'prev,next today',
    		            center: 'title'
    		          },
    		          height:450,
    		          width:480,
    		          validRange: {
    		        	    start: year+"-"+month+"-"+day
    		          },
    		          themeSystem: 'bootstrap',	// 이렇게 설정하면 다크모트 라이트모드 가능
    		          editable: true,
    		          droppable: true, // this allows things to be dropped onto the calendar !!!
    		          dateClick: ((info) => {
    		               //location.href="http://daum.net"
    		               //alert('Click Date:'+info.dateStr)
    		               _this.day=info.dateStr
    		          })
    		        });
    		    calendar.render();
    		    });
    	},
    	methods:{
    		inwonSelect(i){
    			this.inwon=i
    		}
    	}
    }).mount('.container')
  </script>
</body>
</html>