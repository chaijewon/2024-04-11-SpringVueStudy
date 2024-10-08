<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://dapi.kakao.com/v2/maps/sdk.js?appkey=72fa81817487692b6dc093004af97650&libraries=services"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
  <!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>맛집 상세보기</h2>
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
    <section class="single_blog_area section_padding_80">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">

                        <!-- Single Post -->
                        <div class="col-12 col-sm-12">
                            
                            <!-- Related Post Area -->
                            <div class="related-post-area section_padding_50">
                              
                                <div class="related-post-slider owl-carousel">
                                    <!-- Single Related Post-->
                                    <c:forTokens items="${vo.images }" delims="^" var="img">
	                                    <div class="single-post">
	                                        <!-- Post Thumb -->
	                                        <div class="post-thumb">
	                                            <img src="http://www.menupan.com${img }" alt="">
	                                        </div>
	                                    </div>
                                    </c:forTokens>
                                </div>
                            </div>
                            <table class="table">
                              <tr>
                                <td width="30%" class="text-center" rowspan="6">
                                  <img src="http://www.menupan.com${vo.poster }" style="width: 100%">
                                </td>
                                <td colspan="2">
                                  <h3>${vo.name }&nbsp;<span style="color:orange;">${vo.score }</span></h3>
                                </td>
                              </tr>
                              <tr>
                                <td width=15% class="text-center">주소</td>
                                <td width="55%">${vo.address }</td>
                              </tr>
                              <tr>
                                <td width=15% class="text-center">전화</td>
                                <td width="55%">${vo.phone }</td>
                              </tr>
                              <tr>
                                <td width=15% class="text-center">음식종류</td>
                                <td width="55%">${vo.type }</td>
                              </tr>
                              <tr>
                                <td width=15% class="text-center">주차</td>
                                <td width="55%">${co.parking }</td>
                              </tr>
                              <tr>
                                <td width=15% class="text-center">영업시간</td>
                                <td width="55%">${vo.time }</td>
                              </tr>
                 
                            </table>
                            <table class="table">
                              <tr>
                                <td>${vo.theme }</td>
                              </tr>
                              <tr>
                                <td>${vo.content }</td>
                              </tr>
                              <tr>
                                <td class="text-right">
                                 <c:if test="${sessionScope.userId!=null }">
                                  <a href="#" class="btn btn-xs btn-danger">좋아요</a>
                                  <a href="#" class="btn btn-xs btn-success">찜하기</a>
                                  <a href="#" class="btn btn-xs btn-info">예약</a>
                                 </c:if>
                                  <a href="../food/list.do" class="btn btn-xs btn-warning">목록</a>
                                </td>
                              </tr>
                              <tr>
                                <td>
                                 <div id="map" style="width:100%;height:350px;"></div>
                                </td>
                              </tr>
                            </table>
                            <script>
                            var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
                   		    mapOption = {
                   		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                   		        level: 3 // 지도의 확대 레벨
                   		    };  

                   		// 지도를 생성합니다    
                   		var map = new kakao.maps.Map(mapContainer, mapOption); 

                   		// 주소-좌표 변환 객체를 생성합니다
                   		var geocoder = new kakao.maps.services.Geocoder();

                   		// 주소로 좌표를 검색합니다
                   		geocoder.addressSearch('${vo.address}', function(result, status) {

                   		    // 정상적으로 검색이 완료됐으면 
                   		     if (status === kakao.maps.services.Status.OK) {

                   		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                   		        // 결과값으로 받은 위치를 마커로 표시합니다
                   		        var marker = new kakao.maps.Marker({
                   		            map: map,
                   		            position: coords
                   		        });

                   		        // 인포윈도우로 장소에 대한 설명을 표시합니다
                   		        var infowindow = new kakao.maps.InfoWindow({
                   		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.name}</div>'
                   		        });
                   		        infowindow.open(map, marker);

                   		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                   		        map.setCenter(coords);
                   		    } 
                   		    });    
                            </script>
                            <!-- Comment Area Start -->
                            <div id="replyApp">
                            <div class="comment_area section_padding_50 clearfix">
                                <h4 class="mb-30">댓글</h4>

                                <ol>
                                    <!-- Single Comment Area -->
                                    <li class="single_comment_area" v-for="vo in reply_list">
                                        <div class="comment-wrapper d-flex" v-if="vo.group_tab===0">
                                            <!-- Comment Meta -->
                                            <div class="comment-author">
                                                <img :src="vo.sex==='남자'?'../img/icon/man.png':'../img/icon/woman.png'" alt="">
                                            </div>
                                            <!-- Comment Content -->
                                            <div class="comment-content">
                                                <span class="comment-date text-muted">{{vo.dbday}}</span>
                                                <h5>{{vo.name}}</h5>
                                                <p>{{vo.msg}}</p>
                                                <a href="#" v-if="sessionId===vo.id">Update</a>
                                                <a href="#" v-if="sessionId===vo.id">Delete</a>
                                                <a class="active" href="#" v-if="sessionId!=''">Reply</a>
                                                <a href="#" v-if="sessionId!=''">Like</a>
                                                
                                            </div>
                                        </div>
                                        <ol class="children" v-if="vo.group_tab===1">
                                            <li class="single_comment_area">
                                                <div class="comment-wrapper d-flex">
                                                    <!-- Comment Meta -->
                                                    <div class="comment-author">
                                                        <img :src="vo.sex==='남자'?'../img/icon/man.png':'../img/icon/woman.png'" alt="">
                                                    </div>
                                                    <!-- Comment Content -->
                                                    <div class="comment-content">
                                                        <span class="comment-date text-muted">{{vo.dbday}}</span>
                                                        <h5>{{vo.name}}</h5>
                                                        <p>{{vo.msg}}</p>
                                                        <a href="#" v-if="sessionId===vo.id">Update</a>
                                                        <a href="#" v-if="sessionId===vo.id">Delete</a>
                               
                                                        <a href="#" v-if="sessionId!=''">Like</a>
                                                        
                                                    </div>
                                                </div>
                                            </li>
                                        </ol>
                                    </li>
                                    
                                </ol>
                            </div>

                            <!-- Leave A Comment -->
                            <c:if test="${sessionScope.userId!=null }">
	                            <div class="leave-comment-area section_padding_50 clearfix">
	                                <div class="comment-form">
	                                   <table class="table">
	                                    <tr>
	                                      <td>
	                                       <textarea rows="4" cols="70" style="float: left" ref="msg" v-model="msg"></textarea>
	                                       <input type=button value="댓글" style="float: left;background-color: blue;color: white;width: 80px;height:94px">
	                                       
	                                      </td>
	                                    </tr>
	                                   </table>
	                                </div>
	                            </div>
                            </c:if>
                          </div>
                        </div>
                    </div>
                </div>
          </div>
      </div>
    </section>
    <script>
     let replyApp=Vue.createApp({
    	 data(){
    		 return {
                rno:${fno},
                reply_list:[],
                curpage:1,
                totalpage:0,
                endPage:0,
                startPage:0,
                type:1,
                sessionId:'${sessionId}'
    		 }
    	 },
    	 mounted(){
    		 this.dataRecv()
    	 },
    	 methods:{
    		 dataRecv(){
    			 axios.get('../comment/list_vue.do',{
    				 params:{
    					rno:this.rno, 
    					type:this.type,
    					page:this.curpage
    				 }
    			 }).then(response=>{
    				 console.log(response.data)
    				 this.reply_list=response.data.list
    				 this.curpage=response.data.curpage
    				 this.totalpage=response.data.totalpage
    				 this.startPage=response.data.startPage
    				 this.endPage=response.data.endPage
    			 }).catch(error=>{
    				 console.log(error.response)
    			 })
    		 }
    	 }
     }).mount('#replyApp')
    </script>          
</body>
</html>