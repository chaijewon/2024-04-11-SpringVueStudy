<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>상품 상세보기</h2>
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
                        <div class="col-12 col-sm-12">
                         <table class="table">
                           <tr>
                             <td width=30% class="text-center" rowspan="8">
                               <img :src="detail_data.goods_poster" style="width: 100%">
                             </td>
                             <td colspan="2">
                               <h4>{{detail_data.goods_name}}</h4>
                             </td>
                            </tr>
                            <tr>
                              <td colspan="2">
                               {{detail_data.goods_sub}}
                             </td>
                            </tr>
                            <tr>
                              <td style="color:pink">{{detail_data.goods_discount}}%</td>
                              <td>{{detail_data.goods_price}}</td>
                            </tr>
                            <tr>
                              <td style="color:green">첫번째 구매</td>
                              <td>{{detail_data.goods_first_price}}</td>
                            </tr>
                            <tr>
                              <td style="color:gray">배송</td>
                              <td>{{detail_data.goods_delivery}}</td>
                            </tr>
                            <tr>
                              <td colspan="2">
                                <select class="input-sm" style="width:350px" @change="accountChange()"
                                  ref="account" v-model="account"
                                >
                                 <option value="1" selected>1개</option>
                                 <option value="2">2개</option>
                                 <option value="3">3개</option>
                                 <option value="4">4개</option>
                                 <option value="5">5개</option>
                                </select>
                              </td>
                            </tr>
                            <tr>
                              <td colspan="2" class="text-right">
                               총 금액:<span style="color:bule">{{total_price}}원</span>
                              </td>
                            </tr>
                            <tr>
                              <td colspan="2" class="text-center">
                               <c:if test="${sessionScope.userId!=null }">
                                <button class="btn-sm btn-danger" @click="goodsCart()">장바구니</button>&nbsp;
                                <button class="btn-sm btn-success" @click="goodsBuy()">바로구매</button>&nbsp;
                               </c:if>
                                <button class="btn-sm btn-info"
                                 onclick="javascript:history.back()"
                                >목록</button>
                              </td>
                            </tr>
                         </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
     </section>
     <script>
      var IMP = window.IMP; 
      IMP.init("imp68206770");
      let detailApp=Vue.createApp({
    	  data(){
    		  return {
    			  detail_data:{},
    			  no:${no},
    			  total_price:0,
    			  account:1
    		  }
    	  },
    	  mounted(){
    		 axios.get('../goods/detail_vue.do',{
    			 params:{
    				 no:this.no
    			 }
    		 }).then(response=>{
    			 console.log(response.data)
    			 this.detail_data=response.data
    		 }).catch(error=>{
    			 console.log(error.response)
    		 })
    	  },
    	  methods:{
    		accountChange(){
    			//alert("수량:"+this.account);
    			this.total_price=this.account*this.detail_data.price
    		},
    		// 1. 구매창 
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
    		    	
    		    });
    	    },
    		// 2. 장바구니 ==> 0
    		goodsCart(){
    			axios.post('../goods/cart_insert.do',null,{
    				params:{
    					account:this.account,
    					gno:this.no
    				}
    			}).then(response=>{
    				if(response.data==="yes")
    				{
    					location.href="../mypage/mypage_cart.do"
    				}
    				else
    				{
    					alert("장바구니 실패하셨습니다\n"+response.data)
    				}
    				
    			}).catch(error=>{
    				console.log(error.response)
    			})
    		},
    		
    		// 2. 구매  ===> spring_cart : 1
    		goodsBuy(){
    			// 출력정보 읽기 => 회원 정보 / 상품 정보 (이미 전송 받음) => 서버요청 
    			this.requestPay()
    		}
    		// ===> mypage로 이동 
    		// 3. 구매 / 장바구니 : 취소 
    	  }
      }).mount("#detailApp")
     </script>
</body>
</html>