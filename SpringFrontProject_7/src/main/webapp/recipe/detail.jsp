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
    <h3 class="text-center">상세보기</h3>
    <div class="row">
      <table class="table">
                   <tr>
                     <td class="text-center" colspan="3">
                      <img :src="vo.poster" style="width:800px;height: 200px">
                     </td>
                   </tr>
                   <tr>
                     <td class="text-center" colspan="3">
                       <h3>{{vo.title}}</h3>
                     </td>
                   </tr>
                   <tr>
                     <td class="text-center" colspan="3">{{vo.content}}</td>
                   </tr>
                   <tr>
                     <td class="text-center"><img src="../img/icon/a1.png"></td>
                     <td class="text-center"><img src="../img/icon/a2.png"></td>
                     <td class="text-center"><img src="../img/icon/a3.png"></td>
                   </tr>
                   <tr>
                     <td class="text-center">{{vo.info1}}</td>
                     <td class="text-center">{{vo.info2}}</td>
                     <td class="text-center">{{vo.info3}}</td>
                   </tr>
                  </table>
                  <h3>[재료]</h3>
                  <table class="table">
                    <tr>
                      <td>
                        <ul style="list-style-type: none">
                          <li v-for="d in datas">{{d}}</li>
                        </ul>
                      </td>
                    </tr>
                  </table>
                  <h3>[조리순서]</h3>
                  <table class="table">
                    <tr>
                     <td>
                       <table class="table" v-for="(m,index) in makes">
                         <tr>
                           <td width=80% class="text-left">
                            <h5>{{m}}</h5>
                           </td>
                           <td width=20% class="text-right">
                             <img :src="images[index]" style="width: 100px;height: 75px"
                             class="img-rounded">
                           </td>
                         </tr>
                       </table>
                     </td>
                    </tr>
                  </table>
                  <h3>[레시피 작성자]</h3>
                  <table class="table">
                    <tr>
                      <td width=20% class="text-center" rowspan="2">
                        <img :src="vo.chef_poster" style="width: 100px;height: 100px" class="img-circle">
                      </td>
                      <td width=80%>{{vo.chef}}</td>
                    </tr>
                    <tr>
                      <td width=80%>{{vo.chef_profile}}</td>
                    </tr>
                  </table>
    </div>
  </div>
  <script>
    let detailApp=Vue.createApp({
    	data(){
   		 return {
   			 vo:{},
   			 no:${no},
   			 makes:[],
   			 images:[],
   			 datas:[]
   		 }
   	 },
   	 mounted(){
   		 axios.get('../recipe/detail_vue.do',{
   			 params:{
   				 no:this.no
   			 }
   		 }).then(response=>{
   			 console.log(response.data)
   			 this.vo=response.data.vo
   			 this.makes=response.data.mList
   			 this.images=response.data.iList
   			 this.datas=response.data.vo.data.split(",")
   		 }).catch(error=>{
   			 console.log(error.response)
   		 })
   	 }
    }).mount('.container')
  </script>
</body>
</html>