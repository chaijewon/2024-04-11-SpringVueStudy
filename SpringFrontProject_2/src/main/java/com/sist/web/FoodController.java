package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
// 출력에 필요한 데이터 전송 
// 화면 변경하는 역할 
@Controller
public class FoodController {
    // 필요한 클래스 설정 => 스프링에서 주소값을 주입 
	@Autowired
	private FoodDAO dao;
	
	// 사용자 요청에 따라서 처리 => 구분 (URI주소로 구분)
	// 일반 JSP
	@GetMapping("food/list.do")
	public String food_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		List<FoodVO> list=dao.foodListData(start, end);
		int totalpage=dao.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;// 1,11,21...
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;//10 20 30...
		
		if(endPage>totalpage)
		     endPage=totalpage;
		
		// 출력에 필요한 데이터 전송 
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		return "food/list";
	}
	// VueJS
	@GetMapping("food/list2.do")
	public String food_list2()
	{
		return "food/list2";
	}
	@RequestMapping("food/find.do") // POST/GET => 동시에 처리 
	public String food_find(String address,String page,Model model)
	{
		if(address==null)
			address="마포";
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		int rowSize=20;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("address", address);
		
		List<FoodVO> list=dao.foodFindListData(map);
		int totalpage=dao.foodFindTotalPage(map);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;// 1,11,21...
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;//10 20 30...
		
		if(endPage>totalpage)
		     endPage=totalpage;
		
		// 출력에 필요한 데이터 전송 
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("address", address);
		return "food/find";
	}
	// Vue화면만 변경 => vue(router)
	@GetMapping("food/find2.do")
	public String food_find2()
	{
		return "food/find2";
	}
}
