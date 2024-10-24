<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div id="app">
   <input type="checkbox" value="1" v-model="delNo" ref="ck">1<br>
   <input type="checkbox" value="2" v-model="delNo" ref="ck">2<br>
   <input type="checkbox" value="3" v-model="delNo" ref="ck">3<br>
   <input type="checkbox" value="4" v-model="delNo" ref="ck">4<br>
   <input type="checkbox" value="5" v-model="delNo" ref="ck">5<br>
   <button @click="send()">전송</button>
   선택된 값:{{delNo}}
  </div>
  <script>
   let app=Vue.createApp({
	   data(){
		   return {
		       delNo:[]	   
		   }
	   },
	   methods:{
		  
		  send(){
			  let len=this.delNo.length;
			  let arr=''
			  for(let i=0;i<len;i++)
			  {
				  arr+='arr['+i+']='+this.delNo[i]+","  
			  }
			  alert(arr)
			  axios.get('board/delete_vue.do',{
				  params:{
					  arr:arr
				  }
			  }).then(response=>{
				  console.log(response.data)
			  })
		  }
	   }
   }).mount("#app")
  </script>
</body>
</html>