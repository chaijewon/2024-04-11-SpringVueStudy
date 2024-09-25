package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
@RestController
public class FoodRestController {
   // DAO => 스프링에서 메모리 할당 => getBean() => (X) => 스프링에서 주소값을 대입 
   @Autowired 
   private FoodDAO dao;
   
   @GetMapping(value="food/list_vue.do",produces = "text/plain;charset=UTF-8")
   // => html :text/html (스크립트) , => xml : text/xml, => json(일반 문자열) : text/plain
   // JSON => 데이터를 모아서 자바스크립트로 전송 
   // 객체 : {키:값,키:값...} (VO), 목록 : [{},{},{}]... List
   // JSON => Ajax , Vue , React , Next ... kotlin / flutter
   public String food_list(int page,String type) throws Exception
   {
	   int rowSize=20;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   
	   Map map=new HashMap();
	   map.put("start", start);
	   map.put("end", end);
	   map.put("type", type);
	   // #{type} ==> map.get("type")
	   List<FoodVO> list=dao.foodTypeListData(map);
	   int totalpage=dao.foodTypeTotalPage(type);
	   
	   map=new HashMap();
	   map.put("list", list); // model.addAttribute("list",list) => EL,JSTL
	   // => Vue에서 처리 => [] => food_list:[]
	   map.put("curpage", page); // 정수  curpage:0
	   map.put("totalpage", totalpage); //정수
	   map.put("type", type);//문자열 type:''
	   
	   // 자바스크립트에서 인식이 가능 => JSON으로 변경 
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   
	   return json;
   }
   @GetMapping(value="food/detail_vue.do",produces = "text/plain;charset=UTF-8")
   // detail.do?fno=1
   // String page , int page  
   public String food_detail(int fno,int page) throws Exception
   {
	   FoodVO vo=dao.foodDetailData(fno);
	   // 서울 은평구 대조동 
	   String addr1=vo.getAddress();
	   addr1=addr1.substring(addr1.indexOf(" ")+1);
	   String addr2=addr1.trim();
	   addr2=addr2.substring(0,addr2.indexOf(" "));
		/*
		 * String addr3=addr2.trim(); 
		 * addr3=addr3.substring(0,addr3.indexOf(" "));
		 */
	   System.out.println("address:"+addr2.trim());
	   List<FoodVO> list=dao.foodRearHouseData(addr2);
	   ObjectMapper mapper=new ObjectMapper();
	   Map map=new HashMap();
	   map.put("vo", vo);
	   map.put("page", page);
	   map.put("address", vo.getAddress());
	   map.put("fno", fno);
	   map.put("list", list);
	   String json=mapper.writeValueAsString(map);
	   return json;
   }
}
