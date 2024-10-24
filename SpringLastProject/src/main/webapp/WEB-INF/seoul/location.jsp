<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.page-link:hover{
   cursor: pointer;
}
li {
  display: inline-block;
}
.img_130{
  width: 160px;
  height: 200px;
}
</style>
</head>
<body>
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>서울 명소</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div style="margin-top:2px;border: 1px solid black;width: 1100px;height: 200px">
                      <img src="https://shopping-phinf.pstatic.net/main_2452598/24525984253.jpg?type=f300" alt="단체 경량 패딩 점퍼 인쇄 주문제작 / 마크 MK2553" class="img_130" onerror="this.onerror=null; this.src='//img.danawa.com/new/noData/img/noImg_160.gif';" />
                      <img src="https://shopping-phinf.pstatic.net/main_4345830/43458307234.jpg?type=f300" alt="단체복 겨울 경량 패딩 점퍼 남녀공용 / MK397" class="img_130" onerror="this.onerror=null; this.src='//img.danawa.com/new/noData/img/noImg_160.gif';" />
                      <img src="https://shopping-phinf.pstatic.net/main_3593833/35938335089.jpg?type=f300" alt="단체 솔라볼 점퍼 경량 패딩 인쇄 가능 / MK4081" class="img_130" onerror="this.onerror=null; this.src='//img.danawa.com/new/noData/img/noImg_160.gif';" />
                      <img src="https://shopping-phinf.pstatic.net/main_2953573/29535738012.jpg?type=f300" alt="단체 경량 패딩 파카 점퍼 후드 탈부착 / TL201" class="img_130" onerror="this.onerror=null; this.src='//img.danawa.com/new/noData/img/noImg_160.gif';" />
                      <img src="https://searchad-phinf.pstatic.net/MjAyNDEwMDdfMTgx/MDAxNzI4MjY1OTQ0NDI5.hAohqdxOspRAWJUe2tUZZRLrf4q_TwLNEWyfXJOaS-wg.W85kydpxTWPMMWmwHha4VdzmV8SrZchJD2mLEaNgEUEg.JPEG/1321729-8776e709-234e-4312-8b01-bafbf16bb736.jpg?type=f300" alt="코오롱 브렌우드 경량 다운 패딩 자켓 3종" class="img_130" onerror="this.onerror=null; this.src='//img.danawa.com/new/noData/img/noImg_160.gif';" />
                      <img src="https://searchad-phinf.pstatic.net/MjAyMjAyMTRfMjEz/MDAxNjQ0ODE1ODY0MjI4.0Znzndj0TVdqqfd9LJw1DygywUaWXWCDRvfatl9ffEsg.fzqkLEHAcpA6JMCQJMGz9EEvKUv6DSfP5rR5_vDjJfAg.PNG/1353853-4c648d0d-6b38-4354-96b7-147027f124eb.png?type=f300" alt="JK113 단체 반사 경량 바람막이 대학교 과잠제작/디자인시안 가능" class="img_130" onerror="this.onerror=null; this.src='//img.danawa.com/new/noData/img/noImg_160.gif';" />
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80" id="listApp">
        <div class="container">
            <div class="row">
                <!-- Single Post -->
                <div class="col-12 col-md-6 col-lg-4" v-for="vo in seoul_list">
                    <div class="single-post wow fadeInUp" data-wow-delay="0.1s">
                        <!-- Post Thumb -->
                        <div class="post-thumb">
                           <a :href="'../seoul/location_detail.do?no='+vo.no">
                            <img :src="vo.poster" style="width: 350px;height: 200px"
                             onerror="../img/icon/noimage.png"
                            >
                           </a>
                        </div>
                        <!-- Post Content -->
                        <div class="post-content">
                            <div class="post-meta d-flex">
                                <div class="post-author-date-area d-flex">
                                    <!-- Post Author -->
                                    <div class="post-author">
                                        <a href="#"></a>
                                    </div>
                                    <!-- Post Date -->
                                    <div class="post-date">
                                        <a href="#" style="color:orange;">0</a>
                                        
                     
                                    </div>
                                </div>
                                <!-- Post Comment & Share Area -->
                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->
                                    <div class="post-favourite">
                                        <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i> 0</a>
                                    </div>
                                    <!-- Post Comments -->
                                    <div class="post-comments">
                                        <a href="#"><i class="fa fa-comment-o" aria-hidden="true"></i> 12</a>
                                    </div>
                                    <!-- Post Share -->
                                    <div class="post-share">
                                        <a href="#"><i class="fa fa-share-alt" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a :href="'../recipe/detail.do?no='+vo.no">
                                <h4 class="post-headline">{{vo.title}}</h4>
                            </a>
                        </div>
                    </div>
                </div>

                

                <div class="col-12">
                    <div class="pagination-area d-sm-flex mt-15">
                        <nav aria-label="#">
                            <ul class="pagination">
                                <li class="page-item" v-if="startPage>1">
                                    <a class="page-link" @click="prev()"><i class="fa fa-angle-double-left" aria-hidden="true"></i> 이전</a>
                                </li>
                                
                                <li :class="i===curpage?'page-item active':'page-item'" v-for="i in range(startPage,endPage)">
                                    <a class="page-link" @click="pageChange(i)">{{i}}</a>
                                </li>
                     
                                <li class="page-item" v-if="endPage<totalpage">
                                    <a class="page-link" @click="next()">다음 <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                                </li>
                            </ul>
                        </nav>
                        <div class="page-status">
                            <p>{{curpage}} page / {{totalpage}} pages</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <script>
     let listApp=Vue.createApp({
    	 //Model => 데이터관리 
    	 data(){
    		 return  {
    			 seoul_list:[],
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
    		 prev(){
    			 this.curpage=this.startPage-1
    			 this.dataRecv()
    		 },
    		 next(){
    			 this.curpage=this.endPage+1
    			 this.dataRecv()
    		 },
    		 pageChange(page){
    			 this.curpage=page
    			 this.dataRecv()
    		 },
    		 range(start,end){
    			 let arr=[]
    			 let len=end-start
    			 for(let i=0;i<=len;i++)
    			 {
    				 arr[i]=start
    				 start++;
    			 }
    			 return arr
    		 },
    		 dataRecv(){
    			 axios.get('../seoul/location_vue.do',{
    				params:{
    					 page:this.curpage
    				}
    			 }).then(response=>{
    				 console.log(response.data)
    				 this.seoul_list=response.data.list
    				 this.curpage=response.data.curpage
    				 this.totalpage=response.data.totalpage
    				 this.startPage=response.data.startPage
    				 this.endPage=response.data.endPage
    			 }).catch(error=>{
    				 console.log(error.response)
    			 })
    		 }
    	 }
     }).mount('#listApp')
    </script>
</body>
</html>