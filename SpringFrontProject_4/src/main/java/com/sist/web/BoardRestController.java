package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
// 화면제어는 불가능 => 자바스크립트/다른언어로 데이터 전송
//                           모바일 : Kotlin , Flutter , Dart ... 
//                  Ajax/Vue/React/Next
//                  서버를 나눠서 처리 => MSA(Spring Cloud)
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;
import com.sist.vo.*;
// JSON / 일반 문자열 / 숫자 ...
@RestController
public class BoardRestController {
   @Autowired
   private BoardDAO dao;
   
   @GetMapping(value="board/list_vue.do",produces = "text/plain;charset=UTF-8")
   public String board_list(int page) throws Exception
   {
	   int rowSize=10;
	   int start=(rowSize*page)-(rowSize-1);
	   int end=rowSize*page;
	   
	   List<BoardVO> list=dao.boardListData(start, end);
	   int count=dao.boardTotalPage();
	   int totalpage=(int)(Math.ceil(count/10.0));
	   count=count-((rowSize*page)-rowSize);
	   
	   // 화면 출력 => 데이터 전송 (자바스크립트 => JSON)
	   Map map=new HashMap();
	   map.put("list", list);
	   map.put("curpage", page);
	   map.put("totalpage", totalpage);
	   map.put("count", count);
	   map.put("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(map);
	   
	   return json;
	   
   }
   @PostMapping(value="board/insert_vue.do",produces = "text/plain;charset=UTF-8")
   public String board_insert(BoardVO vo)
   {
	   String result="yes";
	   try
	   {
		   result="yes";
		   dao.boardInsert(vo);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
		   result="no";   
	   }
	   return result;
   }
   
   @GetMapping(value="board/detail_vue.do",produces = "text/plain;charset=UTF-8")
   public String board_detail(int no) throws Exception
   {
	   // JSON
	   BoardVO vo=dao.boardDetailData(no);
	   
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   
	   return json;
   }
   
   @GetMapping(value="board/delete_vue.do",produces = "text/plain;charset=UTF-8")
   public String board_delete(int no,String pwd)
   {
	   String result=dao.boardDelete(no, pwd);
	   return result;
   }
   // EntityResponse<BoardVO> => 데이터 / 에러 
   @GetMapping(value="board/update_vue.do",produces = "text/plain;charset=UTF-8")
   public String board_update(int no) throws Exception
   {
	   BoardVO vo=dao.boardUpdateData(no);
	   ObjectMapper mapper=new ObjectMapper();
	   String json=mapper.writeValueAsString(vo);
	   return json;
   }
   // 자바스크립트 = 자바 연동 
   // 일반데이터 (자바와 동일) , List:[] , VO:{}
   @PostMapping(value="board/update_ok_vue.do",produces = "text/plain;charset=UTF-8")
   public String board_update_ok(BoardVO vo)
   {
	   String result=dao.boardUpdate(vo);
	   return result;
   }
}
