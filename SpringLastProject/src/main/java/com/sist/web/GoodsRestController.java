package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// => 링크(목록 / 메뉴 : <a> ) => Mapper => DAO => Service => Controller => JSP 
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
@RestController
public class GoodsRestController {
  @Autowired
  private GoodsService gService;
  
  @GetMapping(value="goods/list_vue.do",produces = "text/plain;charset=UTF-8")
  public String goods_list(int page) throws Exception
  {
	  int rowSize=12;
	  int start=(rowSize*page)-(rowSize-1);
	  int end=rowSize*page;
	  // 오라클 
	  Map map=new HashMap();
	  map.put("start", start);
	  map.put("end", end);
	  
	  List<GoodsVO> list=gService.goodsListData(map);
	  int totalpage=gService.goodsTotalPage();
	  
	  final int BLOCK=10;
	  int startPage=((page-1)/BLOCK*BLOCK)+1;
	  int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
	  
	  if(endPage>totalpage)
		  endPage=totalpage;
	  // Vue
	  map=new HashMap();
	  map.put("list", list);
	  map.put("curpage", page);
	  map.put("totalpage", totalpage);
	  map.put("startPage", startPage);
	  map.put("endPage", endPage);
	  
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(map);
	  
	  return json;
  }
  @GetMapping(value="goods/detail_vue.do",produces = "text/plain;charset=UTF-8")
  public String goods_detail(int no) throws Exception
  {
	  GoodsVO vo=gService.goodsDetailData(no);
	  String temp=vo.getGoods_price();
	  temp=temp.replaceAll("[^0-9]", "");// 숫자외에 나머지 제거 
	  vo.setPrice(Integer.parseInt(temp.trim()));
	  
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(vo); // vo = response.data
	  
	  return json;
  }
  @PostMapping(value="goods/cart_insert.do",produces = "text/plain;charset=UTF-8")
  public String cart_insert(int gno,int account,HttpSession session)
  {
	  String result="";
	  try
	  {
		  String id=(String)session.getAttribute("userId");
		  CartVO vo=new CartVO();
		  vo.setGno(gno);
		  vo.setAccount(account);
		  vo.setId(id);
		  // 오라클 저장 
		  int count=gService.goodsCartGnoCount(gno);
		  if(count==0)
		  {
		      gService.goodsCartInsert(vo);
		  }
		  else
		  {
			  gService.goodsCartAccountUpdate(vo);
		  }
		  result="yes";
	  }catch(Exception ex)
	  {
		  result=ex.getMessage();  
	  }
	  return result;
  }
  @GetMapping(value="goods/cart_cancel_vue.do",produces = "text/plain;charset=UTF-8")
  public String cart_cancel(int cno,HttpSession session) throws Exception
  {
	  gService.goodsCartCancel(cno);
	  String id=(String)session.getAttribute("userId");
	  List<CartVO> list=gService.goodsCartListData(id);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(list);
	  return json;
  }
  @GetMapping(value="goods/goods_detail_vue.do",produces = "text/plain;charset=UTF-8")
  public String goods_detail_cart(int gno) throws Exception
  {
	  GoodsVO vo=gService.goodsDetailData(gno);
	  String temp=vo.getGoods_price();
	  temp=temp.replaceAll("[^0-9]", "");// 숫자외에 나머지 제거 
	  vo.setPrice(Integer.parseInt(temp.trim()));
	  
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(vo); // vo = response.data
	  
	  return json;
  }
  @GetMapping(value="goods/goods_buy_vue.do",produces = "text/plain;charset=UTF-8")
  public String goods_buy(int cno,int gno,HttpSession session) throws Exception
  {
	  gService.goodsBuy(cno);
	  GoodsVO vo=gService.goodsDetailData(gno);
	  String temp=vo.getGoods_price();
	  temp=temp.replaceAll("[^0-9]", "");
	  vo.setPrice(Integer.parseInt(temp.trim()));
	
	  String id=(String)session.getAttribute("userId");
	  
	  MemberVO mvo=gService.memberInfodData(id);
	  
	  Map map=new HashMap();
	  map.put("gvo",vo);
	  map.put("mvo", mvo);
	  
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(map);
	  
	  return json;
  }
  @GetMapping(value="goods/buy_vue.do",produces = "text/plain;charset=UTF-8")
  public String goods_buy_vue(HttpSession session)throws Exception
  {
	  String id=(String)session.getAttribute("userId");
	  List<CartVO> list=gService.goodsBuyListData(id);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(list);
	  return json;
  }
  
  @GetMapping(value="goods/cart_cancel_vue2.do",produces = "text/plain;charset=UTF-8")
  public String cart_cancel2(int cno,HttpSession session) throws Exception
  {
	  gService.goodsCartCancel(cno);
	  String id=(String)session.getAttribute("userId");
	  List<CartVO> list=gService.goodsBuyListData(id);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(list);
	  return json;
  }
 
}
