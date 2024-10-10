<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.nav-link{
  cursor: pointer;
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
                        <h2>상세보기</h2>
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
    <section class="single_blog_area section_padding_80" id="detailApp">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-lg-8">
                    <div class="row no-gutters">
                      <table class="table">
                        <tr>
                          <th width=20% class="text-center">번호</th>
                          <td width=30% class="text-center">{{vo.no}}</td>
                          <th width=20% class="text-center">작성일</th>
                          <td width=30% class="text-center">{{vo.dbday}}</td>
                        </tr>
                        <tr>
                          <th width=20% class="text-center">이름</th>
                          <td width=30% class="text-center">{{vo.name}}</td>
                          <th width=20% class="text-center">조회수</th>
                          <td width=30% class="text-center">{{vo.hit}}</td>
                        </tr>
                        <tr>
                          <th width=20% class="text-center">제목</th>
                          <td colspan="3">{{vo.subject}}</td>
                        </tr>
                        <tr>
                          <td colspan="4" class="text-left" valign="top" height="200">
                          <pre style="white-space: pre-wrap;background-color: white;border: none">{{vo.content}}</pre>
                          </td>
                        </tr>
                        <tr>
                          <td colspan="4" class="text-right">
                           <a :href="'../freeboard/update.do?no='+vo.no" class="btn btn-xs btn-primary"
                             v-show="sessionId===vo.id"
                           >수정</a>
                           <button class="btn btn-xs btn-success" @click="boardDelete()"
                             v-show="sessionId===vo.id"
                           >삭제</button>
                           <a href="../freeboard/list.do" class="btn btn-xs btn-info">목록</a>
                          </td>
                        </tr>
                      </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script>
      let detailApp=Vue.createApp({
    	  data(){
    		return {
    			vo:{},
    			no:${no},
    			sessionId:'${sessionId}'
    		}  
    	  },
    	  mounted(){
    		  axios.get('../freeboard/detail_vue.do',{
    			  params:{
    				  no:this.no
    			  }
    		  }).then(response=>{
    			  console.log(response.data)
    			  this.vo=response.data
    		  }).catch(error=>{
    			  console.log(error.response)
    		  })
    	  },
    	  methods:{
    		  boardDelete(){
    			  axios.get('../freeboard/delete_vue.do',{
    				  params:{
    					  no:this.no
    				  }
    			  }).then(response=>{
    				  if(response.data==='yes')
    				  {
    					   location.href="../freeboard/list.do"  
    				  }
    				  else
    				  {
    					  alert('삭제 실패!!')
    					  console.log(response.data)
    				  }
    			  }).catch(error=>{
    				  console.log(error.response)
    			  })
    		  }
    	  }
      }).mount('#detailApp')
    </script>
</body>
</html>