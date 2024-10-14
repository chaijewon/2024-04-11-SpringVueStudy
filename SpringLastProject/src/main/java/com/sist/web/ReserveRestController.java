package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.RecipeService;
import com.sist.service.ReserveService;
import com.sist.vo.FoodVO;

import java.util.*;
@RestController
public class ReserveRestController {
  @Autowired
  private ReserveService rService;
  
  @GetMapping(value = "reserve/reserve_main_vue.do",produces = "text/plain;charset=UTF-8")
  public String reserve_food_info(String type,int page) throws Exception
  {
	  int rowSize=30;
	  int start=(rowSize*page)-(rowSize-1);
	  int end=rowSize*page;
	  
	  Map map=new HashMap();
	  map.put("start", start);
	  map.put("end", end);
	  map.put("type", type);
	  List<FoodVO> list=rService.reserveFoodInfoData(map);
	  int totalpage=rService.reserveFoodTotalPage(map);
	  
	  map=new HashMap();
	  map.put("curpage", page);
	  map.put("list", list);
	  map.put("totalpage", totalpage); // response.data={}
	  map.put("type", type);
	  
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(map);
	  
	  return json; // 자바스크립트(Jquery,VueJs,Ajax)와 연동 
  }
  
}
