package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.vo.FoodVO;
import com.sist.service.*;
import java.util.*;
@Controller
public class FoodController {
   @Autowired
   private FoodService fService; // 데이터베이스 연동
   
   @GetMapping("food/list.do")
   public String food_list()
   {
	   return "food/list";
   }
   @GetMapping("food/detail_before.do")
   public String food_detail_before(int fno,HttpServletResponse response,RedirectAttributes ra)
   {
	   // forward => Model를 이용해서 데이터 전송 
	   // redirect => RedirectAttributes이용해서 데이터 전송 
	   Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno));
	   cookie.setMaxAge(60*60*24);
	   cookie.setPath("/");
	   response.addCookie(cookie);
	   ra.addAttribute("fno", fno);// ?fno=1
	   return "redirect:../food/detail.do";
   }
   // response는 한가지 일만 수행 
   // => HTML/Cookie 
   @GetMapping("food/detail.do")
   public String food_detail(int fno,Model model,HttpSession session)
   {
	   String id=(String)session.getAttribute("userId");
	   
	   FoodVO vo=fService.foodDetailData(fno);
	   model.addAttribute("vo", vo);
	   model.addAttribute("fno", fno);
	   model.addAttribute("sessionId", id);
	   
	   return "food/detail";
   }
   @GetMapping("food/find.do")
   public String food_find()
   {
	   return "food/find";
   }
}
