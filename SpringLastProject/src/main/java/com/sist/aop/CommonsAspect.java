package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.sist.service.*;
import com.sist.vo.*;
@Aspect
@Component
//1111111lllllggg1111vcvcvfhfhfh
//      sdsd   cbvcbc
public class CommonsAspect {
   @Autowired
   private FoodService fService;
   
   // finally => 무조건 실행
   /*
    *   DispatcherServlet 
    *     => 연결 클래스 
    *        @Controller / @RestController
    */
   @After("execution(* com.sist.web.*Controller.*(..))")
   public void footerCookieSend()
   {
	   // request를 가지고 온다
	   HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	   
	   Cookie[] cookies=request.getCookies();
	   List<FoodVO> list=new ArrayList<FoodVO>();
	   if(cookies!=null)
	   {
		   for(int i=cookies.length-1;i>=0;i--)
		   {
			   // Cookie(key , value) => Cookie("food_1","1")
			   if(cookies[i].getName().startsWith("food_"))
			   {
				   String fno=cookies[i].getValue();
				   FoodVO vo=fService.foodInfoData(Integer.parseInt(fno));
				   list.add(vo);
				   // footer에 전송 vvv  
			   }
		   }
	   }
	   request.setAttribute("cList", list);
   }
}



