package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // DispatcherServlet
public class RecipeController {
  @GetMapping("recipe/list.do")
  // return은 반드시 => 파일명 , .do => Router
  public String recipe_list()
  {
	  return "recipe/list";
  }
}
