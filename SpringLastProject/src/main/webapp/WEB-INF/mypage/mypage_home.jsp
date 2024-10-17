<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div id="myApp">
   <table class="table">
    <tr>
      <td class="text-center">
       <button class="btn-sm btn-danger" @click="cctvView(1)">두산,LG</button>
       <button class="btn-sm btn-success" @click="cctvView(2)">키움</button>
       <button class="btn-sm btn-info" @click="cctvView(3)">SSG</button>
       <button class="btn-sm btn-warning" @click="cctvView(4)">KT</button>
       <button class="btn-sm btn-primary" @click="cctvView(5)">한화</button>
       <button class="btn-sm btn-danger" @click="cctvView(6)">삼성</button>
       <button class="btn-sm btn-success" @click="cctvView(7)">NC</button>
       <button class="btn-sm btn-warning" @click="cctvView(8)">롯데</button>
       <button class="btn-sm btn-info" @click="cctvView(9)">KIA</button>
      </td>
    </tr>
   </table>
   <table class="table" v-show="isShow">
     <tr>
       <td class="text-center" colspan="5">
         <h4>교통 돌발 상황</h4>
       </td>
     </tr>
     <tr>
       <th class="text-center">돌발상황</th>
       <th class="text-center">공사일</th>
       <th class="text-center">도로위치</th>
       <th class="text-center">도로차단</th>
       <th class="text-center">사유</th>
     </tr>
     <tr v-for="vo in state_list">
       <td class="text-center">{{vo.eventType}}</td>
       <td class="text-center">{{vo.startDate}}</td>
       <td>{{vo.roadName}}</td>
       <td class="text-center">{{vo.lanesBlocked}}</td>
       <td>{{vo.message}}</td>
     </tr>
   </table>
  </div>
  <script>
  let app=Vue.createApp({
	  data(){
		return {
			 no:0,
		     state_list:[],
		     isShow:false
		}
	  },
	  methods:{
		  cctvView(no){
			  alert("no:"+no)
			  this.isShow=true
			  this.no=no
			  axios.get('http://127.0.0.1:8000/web/food/',{
				  params:{
					  no:this.no
				  }
			  }).then(response=>{
				  alert("정상수행:"+response.data)
			  }).catch(error=>{
				  console.log(error.response)
			  })
			  
			  axios.get('../mypage/mypage_home_vue.do',{
				  params:{
					  no:this.no
				  }
			  }).then(response=>{
				  this.state_list=response.data
			  }).catch(error=>{
				  console.log(error.response)
			  })
		  }
	  }
  }).mount("#myApp")
  </script>
</body>
</html>