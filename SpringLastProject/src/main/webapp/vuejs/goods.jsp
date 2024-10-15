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
.nav-link{
  cursor: pointer;
}
p{
   white-space: nowrap;
   overflow: hidden;
   text-overflow: ellipsis;
}
</style>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
   <div class="container">
     <div class="row">
      <button class="btn-lg btn-danger" @click="click()">결재</button>
     </div>
   </div>
   <script>
    var IMP = window.IMP; 
    IMP.init("imp68206770");
    let app=Vue.createApp({
    	data(){
    		return {
    			
    		}
    	},
    	methods:{
    		
    	    click(){
    	    	this.requestPay()    
    	    },
    		requestPay() {
    		    IMP.request_pay({
    		        pg: "html5_inicis",
    		        pay_method: "card",
    		        merchant_uid: "ORD20180131-0000011",   // 주문번호
    		        name: '홍길동전',
    		        amount: 10000,         // 숫자 타입
    		        buyer_email: '',
    		        buyer_name: '',
    		        buyer_tel: '',
    		        buyer_addr: '',
    		        buyer_postcode: ''
    		     }, function (rsp) { // callback
    		    	location.href='http://localhost/JSPLastProject/mypage/mypage_buy.do' 
    		    });
    	    }
    	}
    }).mount(".container")
   </script>
</body>
</html>