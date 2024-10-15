<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="mypageApp">
	   <table class="table">
	    <tr>
	      <td class="text-center" colspan="6">
	        <h4>장바구니 관리</h4>
	      </td>
	    </tr>
	    <tr>
	      <th class="text-center">번호</th>
	      <th class="text-center"></th>
	      <th class="text-center">수량</th>
	      <th class="text-center">가격</th>
	      <th class="text-center">등록일</th>
	      <th class="text-center">비고</th>
	    </tr>
	    <tr v-for="cart_vo in cart_list">
	      <td class="text-center">{{cart_vo.cno}}</td>
	      <td class="text-center">
	       <img :src="cart_vo.gvo.goods_poster" style="width:30px;height: 30px">
	      </td>
	      <td class="text-center">{{cart_vo.account}}</td>
	      <td class="text-center">{{cart_vo.gvo.goods_price}}</td>
	      <td class="text-center">{{cart_vo.dbday}}</td>
	      <td class="text-center">
	        <button class="btn-sm btn-success">구매</button>
	        <button class="btn-sm btn-info">취소</button>
	        <button class="btn-sm btn-warning">상품상세</button>
	      </td>
	    </tr>
	   </table>
	</div>
	<script>
	let mypageApp=Vue.createApp({
		data(){
			return {
				cart_list:[]
			}
		},
		mounted(){
			axios.get('../mypage/mypage_cart_vue.do')
			.then(response=>{
				console.log(response.data)
				this.cart_list=response.data
			}).catch(error=>{
				console.log(error.response)
			})
		},
		methods:{
			
		}
	}).mount("#mypageApp")
	</script>
</body>
</html>