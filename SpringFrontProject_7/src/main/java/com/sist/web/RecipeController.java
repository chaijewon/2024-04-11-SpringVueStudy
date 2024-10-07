package com.sist.web;
// 화면 변경 
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class RecipeController {
   @GetMapping("recipe/list.do")
   public String recipe_list()
   {
	   return "recipe/list";
   }
   @GetMapping("recipe/detail.do")
   public String recipe_detail(int no,Model model,HttpSession session)
   {
	    String id=(String)session.getAttribute("id");
	    model.addAttribute("no", no);   
	    model.addAttribute("sessionId", id);
	    
	    return "recipe/detail";
   }
}
