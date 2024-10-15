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
	        <h4>구매 관리</h4>
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
	        <button class="btn-sm btn-info" @click="goodsCancel(cart_vo.cno)">취소</button>
	        <button class="btn-sm btn-warning" @click="goodsDetail(cart_vo.gno)">상품상세</button>
	      </td>
	    </tr>
	   </table>
	   <div v-if="isShow">
	     <h4>상품 상세보기</h4>
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
                      </table>
	   </div>
	</div>
	<script>
	let mypageApp=Vue.createApp({
		data(){
			return {
				cart_list:[],
				detail_data:{},
				isShow:false
			}
		},
		mounted(){
			axios.get('../goods/buy_vue.do')
			.then(response=>{
				this.cart_list=response.data
			}).catch(error=>{
				console.log(error.response)
			})
		},
		methods:{
			goodsCancel(cno){
				axios.get('../goods/cart_cancel_vue2.do',{
					params:{
						cno:cno
					}
				}).then(response=>{
					this.cart_list=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			},
			goodsDetail(gno){
				this.isShow=true
				axios.get('../goods/goods_detail_vue.do',{
					params:{
						gno:gno
					}
				}).then(response=>{
					console.log(response.data)
					this.detail_data=response.data
				}).catch(error=>{
					console.log(error.response)
				})
			}
		}
	}).mount("#mypageApp")
	</script>
</body>
</html>