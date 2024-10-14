<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div id="mypageApp">
   <table class="table">
    <tr>
      <th class="text-center">번호</th>
      <th class="text-center"></th>
      <th class="text-center">업체명</th>
      <th class="text-center">예약일</th>
      <th class="text-center">시간</th>
      <th class="text-center">인원</th>
      <th class="text-center">등록일</th>
      <th class="text-center">비고</th>
    </tr>
    <tr v-for="vo in reserve_list">
      <td class="text-center">{{vo.rno}}</td>
      <td class="text-center">
        <img :src="'http://menupan.com'+vo.fvo.poster" style="width: 30px;height: 30px">
      </td>
      <td class="text-center">{{vo.fvo.name}}</td>
      <td class="text-center">{{vo.rday}}</td>
      <td class="text-center">{{vo.rtime}}</td>
      <td class="text-center">{{vo.rinwon}}</td>
      <td class="text-center">{{vo.dbday}}</td>
      <td class="text-center">
        <buttton class="btn-xs btn-success" v-if="vo.isReserve===1">예약완료</buttton>
        <buttton class="btn-xs btn-success" v-else>예약대기</buttton>
      </td>
    </tr>
   </table>
   
 </div>
 <script>
  let mypageApp=Vue.createApp({
	  data(){
		  return {
			 reserve_list:[],
			 rno:0
		  }
	  },
	  mounted(){
		  // 서버로 전송할 데이터가 없는 경우 params => ?
		  axios.get('../mypage/mypage_reserve_vue.do')
		  .then(response=>{
			  console.log(response.data)
			  this.reserve_list=response.data
		  }).catch(error=>{
			  console.log(error.response)
		  })
	  },
	  methods:{
		  
	  }
  }).mount("#mypageApp")
 </script>
</body>
</html>