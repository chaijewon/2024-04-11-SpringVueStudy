<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>맛집 예약</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                   
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Single Blog Area Start ****** -->
    <section class="single_blog_area section_padding_80" id="reserveApp">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-12">
                    <div class="row no-gutters">
                     <table class="table">
                      <tr>
                       <td width="20%" height="500">
                         <table class="table">
                          <tr>
	                          <td colspan="2">
	                           <h4>맛집 정보</h4>
	                          </td>
                          </tr>
                          <tr>
                            <td colspan="2">
                             <button class="btn-xs btn-danger" @click="typeChange('한식')">한식</button>
                             <button class="btn-xs btn-success" @click="typeChange('양식')">양식</button>
                             <button class="btn-xs btn-info" @click="typeChange('중식')">중식</button>
                             <button class="btn-xs btn-primary" @click="typeChange('일식')">일식</button>
                             <button class="btn-xs btn-warning" @click="typeChange('분식')">분식</button>
                            </td>
                           </tr>
                          </table>
                          <div style="overflow-y:auto;height: 500px ">
                            <table class="table">
                             <tr>
                               <th class="text-center"></th>
                               <th class="text-center">업체명</th>
                             </tr>
                             <tr v-for="vo in food_list">
                               <td class="text-center">
                                <img :src="'http://menupan.com'+vo.poster" 
                                   style="width: 35px;height: 35px">
                               </td>
                               <td>{{vo.name}}</td>
                             </tr>
                             <tr>
                               <td colspan="2" class="text-center">
                                <button class="btn-xs btn-success" @click="prev">이전</button>
                                 {{curpage}} page/ {{totalpage}} pages
                                <button class="btn-xs btn-info" @click="next">다음</button>
                               </td>
                             </tr>
                            </table>
                          </div>
                          
                         
                       </td>
                       <td width="45%" height="500">
                         <table class="table">
                          <caption><h4>예약일 정보</h4></caption>
                         </table>
                       </td>
                       <td width="35%" height="500" rowspan="2">
                         <table class="table">
                          <caption><h4>예약 정보</h4></caption>
                         </table>
                       </td>
                      </tr>
                      <tr>
                        <td width="30%" height="150">
                          <table class="table">
                           <caption><h4>시간 정보</h4></caption>
                          </table>
                        </td>
                        <td width="35%" height="150">
                          <table class="table">
                           <caption><h4>인원 정보</h4></caption>
                          </table>
                        </td>
                      </tr>
                     </table>
                    </div>
                </div>
            </div>
         </div>
    </section>
    <script>
      let reserveApp=Vue.createApp({
    	  data(){
    		  return {
    		     type:'한식',
    		     curpage:1,
    		     totalpage:0,
    		     food_list:[]
    		  }
    	  },
    	  // 실행시에 자동 호출되는 메소드 
    	  // => useEffect() / componentDidMount() => react 
    	  // $(function(){})
    	  mounted(){
    		  // window.onload => 화면에 출력하기 전에 처리 
    		  this.dataRecv()
    	  },
    	  // data() , methods => Vue클래스의 멤버변수,멤버메소드 => 사용시에는 반드시 this.
    	  methods:{
    		  prev(){
    			  this.curpage=this.curpage>1?this.curpage-1:this.curpage
    			  this.dataRecv()
    		  },
    		  next(){
    			  this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage
    	          this.dataRecv()  
    		  },
    		  typeChange(type){
    			this.type=type
    			this.curpage=1
    			this.dataRecv()
    		  },
    		  dataRecv(){
    			  // @GetMapping , axios.post() => @PostMapping => 405
    			  // 404(파일명) , 405 (GET/POST) , 400(매개변수 오류) , 500(소스 에러)
    			  axios.get('../reserve/reserve_main_vue.do',{
    				  params:{
    					  type:this.type,
    					  page:this.curpage
    				  }
    			  }).then(response=>{
    				  console.log(response.data)
    				  // 서버에서 전송한 데이터를 받는다 
    				  this.food_list=response.data.list
    				  this.curpage=response.data.curpage
    				  this.totalpage=response.data.totalpage
    				  this.type=response.data.type
    				  // response.data={name:'',sex:'',address:''}
    				  //                 객체 
    				  // response.data.name , response.data.sex , response.data.address
    			  }).catch(error=>{
    				  console.log(error.response)
    			  })
    		  }
    	  }
      }).mount("#reserveApp") //section 태그안에 있는 HTML만 제어 
    </script>
</body>
</html>