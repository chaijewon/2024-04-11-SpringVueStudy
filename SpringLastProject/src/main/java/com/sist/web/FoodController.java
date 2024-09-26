package com.sist.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FoodController {
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
   public String food_detail(int fno,Model model)
   {
	   
	   model.addAttribute("fno", fno);
	   return "food/detail";
   }
}
