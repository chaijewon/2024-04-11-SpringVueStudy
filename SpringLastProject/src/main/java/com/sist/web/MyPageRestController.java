package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;
import com.sist.task.ApiExplorer;

@RestController
public class MyPageRestController {
  @Autowired
  private ReserveService rService;
  
  @Autowired
  private GoodsService gService;
  
  @GetMapping(value="mypage/reserve_info_vue.do",produces = "text/plain;charset=UTF-8")
  public String reserve_info(int fno,int rno) throws Exception
  {
	  ReserveVO vo=rService.reserveInfoData(rno);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(vo);
	  return json;
  }
  
  @GetMapping(value="mypage/mypage_cart_vue.do",produces = "text/plain;charset=UTF-8")
  public String mypage_cart(HttpSession session) throws Exception
  {
	  String id=(String) session.getAttribute("userId");
	  List<CartVO> list=gService.goodsCartListData(id);
	  
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(list);
	  
	  return json;
  }
  @GetMapping(value="mypage/mypage_home_vue.do",produces = "text/plain;charset=UTF-8")
  public String mypage_home(int no) throws Exception
  {
	  List<CctvVO> list=ApiExplorer.cctvData(no);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(list);
	  return json;
  }
}
