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
   width: 800px
}
</style>
<!-- 
     ES5  => type="text/javascript"
     ES6  => type="text/babel" => 생략 
 -->
<script src="https://unpkg.com/vue@3"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
   <div class="container">
     <h3 class="text-center">내용보기</h3>
     <div class="row">
      <table class="table">
        <tr>
          <th width=20% class="text-center">번호</th>
          <td width=30% class="text-center">{{no}}</td>
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
           <pre style="white-space: pre-wrap;background-color: white;border:none">{{vo.content}}</pre>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
            <a :href="'update.do?no='+no" class="btn btn-xs btn-warning">수정</a>
            <input type="button" 
            class="btn btn-xs btn-info" @click="del()" value="삭제"
            ref="delBtn"
            >
            <a href="list.do" class="btn btn-xs btn-success">목록</a>
          </td>
        </tr>
        <tr v-show="isShow">
          <td colspan="4" class="text-right">
          비밀번호:<input type=password v-model="pwd" ref="pwd" class="input-sm"
                 size=15>
          <input type=button value="삭제" class="btn-sm btn-danger"
            ref="deleteBtn" v-on:click="boardDelete()"
          >
          </td>
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
    			pwd:'',
    			isShow:false
    		}
    	},
    	// detail_vue.do?no=39
    	mounted(){
    		//jquery 연동 => $(function(){}) 
    		/*$('#delBtn').click(function(){
    			if(this.index===0)
    			{
    			   this.index=1	
    			   $('#delBtn').text("취소")
    			   $('#delTr').show()
    			}
    			else
    			{
    			   $('#delBtn').text("삭제")
     			   $('#delTr').hide()
    			   this.index=0	
    			}
    		})*/
    		axios.get('http://localhost:8080/web/board/detail_vue.do',{
    			params:{
    				no:this.no
    			}
    		}).then(response=>{
    			console.log(response.data)
    			this.vo=response.data
    			// vo={}
    		}).catch(error=>{
    			console.log(error.response)
    		})
    	},
    	methods:{
    		del(){
    			if(this.isShow===false)
    			{
    				this.isShow=true
    				this.$refs.delBtn.value="취소"
    			}
    			else
    			{
    				this.isShow=false
    				this.$refs.delBtn.value="삭제"
    			}
    		},
    		boardDelete(){
    			if(this.pwd==="")
    			{
    				this.$refs.pwd.focus()
    				return
    			}
    			// 입력이 된 경우 => 서버연결  
    			axios.get('http://localhost:8080/web/board/delete_vue.do',{
    				params:{
    					  no:this.no,
    				      pwd:this.pwd
    				}
    			}).then(response=>{
    				// 서버에서 전송된 결과값 읽기 
    				if(response.data==='yes')
    				{
    					location.href="list.do"
    				}
    				else
    				{
    				    alert("비밀번호가 틀립니다!!")
    				    this.$refs.pwd.value=""
    				    this.$refs.pwd.focus()
    				}
    			}).catch(error=>{
    				console.log(error.response) //에러에 대한 메세지 출력
    			})
    		}
    	}
    }).mount('.container')
   </script>
</body>
</html>