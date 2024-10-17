package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import java.text.*;
@Controller
public class SeoulController {
   @GetMapping("seoul/location.do")
   public String seoul_location()
   {
	   return "seoul/location";
   }
   @GetMapping("seoul/nature.do")
   public String seoul_nature()
   {
	   return "seoul/nature";
   }
   @GetMapping("seoul/shop.do")
   public String seoul_shop()
   {
	   return "seoul/shop";
   }
   @GetMapping("seoul/weather.do")
   public String seoul_weather(Model model) 
   {
	   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	   Date date=new Date();
	   StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
	   String today=st.nextToken()+"년도 "+st.nextToken()+"월 "+st.nextToken()+"일";
	   model.addAttribute("today", today);
	   return "seoul/weather";   
   }
   @GetMapping("seoul/location_detail.do")
   public String location_detail(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "seoul/location_detail";
   }
   @GetMapping("seoul/nature_detail.do")
   public String nature_detail(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "seoul/nature_detail";
   }
   @GetMapping("seoul/shop_detail.do")
   public String shop_detail(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "seoul/shop_detail";
   }
}
