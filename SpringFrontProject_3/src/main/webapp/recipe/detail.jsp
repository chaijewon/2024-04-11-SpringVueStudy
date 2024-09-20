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
   width: 960px
}
</style>
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
   <div class="row">
     <table class="table">
      <tr>
       <td class="text-center">
        <img :src="detail_data.poster" style="width: 800px;height: 200px">
       </td>
      </tr>
      <tr>
        <td class="text-center"><h3>{{detail_data.title}}</h3></td>
      </tr>
      <tr>
        <td class="text-center">{{detail_data.content}}</td>
      </tr>
     </table>
     <h3>[조리순서]</h3>
     <table class="table">
      <tr>
       <td>
         <table class="table" v-for="(m,index) in make_list">
           <tr>
            <td class="text-left" width="80%">{{m}}</td>
            <td class="text-right" width="20%">
              <img :src="image_list[index]" style="width:150px;height: 80px">
            </td>
           </tr>
         </table>
       </td>
      </tr>
     </table>
   </div>
  </div>
  <script>
  /*
        int a=10  => let a=10
        VO        => {}
        List      => [{},{},{}...] JSON
  */
   let detailApp=Vue.createApp({
	   data(){
		   return {
			   no:${no},
			   detail_data:{},
			   image_list:[],
			   make_list:[]
		   }
	   },
	   mounted(){
		   axios.get('http://localhost:8080/web/recipe/detail_vue.do',{
			   params:{
				   no:this.no
			   }
		   }).then(response=>{
			   console.log(response.data)
			   this.detail_data=response.data.vo
			   this.image_list=response.data.iList
			   this.make_list=response.data.mList
		   })
	   }
   }).mount('.container')
  </script>
</body>
</html>