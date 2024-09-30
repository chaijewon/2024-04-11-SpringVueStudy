<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

.container{
   margin-top: 50px
}
.row{
   margin: 0px auto;
   width: 960px
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
      <!-- 목록 (이미지) : component : image-card -->
      <!-- 페이지 출력 : component : page-card -->
     </div>
   </div>
   <script>
   // .js => 재사용 목적 => 다이얼로그 => 
   const image_card={
	 	   
   }
   const page_card={
		   
   }
   let listApp=Vue.createApp({
	   data(){
		   return {
			   list:[],
			   curpage:1,
			   totalpage:0,
			   startPage:0,
			   endPage:0
		   }
	   },
	   mounted(){
		   this.dataRecv()
	   },
	   methods:{
		   dataRecv(){
			   axios.get('../food/list_vue.do',{
				   page:this.curpage
			   }).then(response=>{
				   console.log(response.data)
				   this.list=response.data.list
				   this.curpage=response.data.curpage
				   this.totalpage=response.data.totalpage
				   this.startPage=response.data.startPage
				   this.endPage=response.data.endPage
			   }).catch(error=>{
				   console.log(error.response)
			   })
		   }
	   }
   }).mount('.container')
   </script>
</body>
</html>