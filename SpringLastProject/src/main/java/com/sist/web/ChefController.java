package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // 화면 변경
public class ChefController {
  @GetMapping("chef/list.do")
  /*
   *   리턴형 
   *     = String : 화면 변경 => forward/redirect
   *     = void : download처리 
   *   매개변수 
   *     = 일반 데이터형 , VO , List , 배열 , 내장 객체 
   *       ===============
   *         | 전송되는 데이터명이 일치 
   *         
   *       ?fno=1   => (int fno)
   *        ===             ===
   *       ?no=1&name=..&... => 
   *        ==   ====  VO안에 변수가 존재 
   *       List => file[0] , file[1]...
   *       배열 => checkbox => String[]
   *       내장 객체 
   *         HttpServletRequest  => Cookie 읽기
   *         HttpServletResponse => Cookie 전송 
   *         HttpSession => Loign 
   *         RedirectAttributes => sendRedirect에 데이터를 전송 
   *         Model => 전송객체 => forward에서 전송시에 사용 
   *         
   *         ? => GET 
   *         <form> , params:{}
   *         
   */
  public String chef_list()
  {
	  return "chef/make";  
  }
}
