package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class EmpController {
   @Autowired
   private EmpDAO dao;
   
   @GetMapping("emp/list.do")
   public String emp_list(Model model) {
	   List<EmpVO> list=dao.empListData();
	   Map map=new HashMap();
	   map.put("table_name", "emp_5");
	   List<EmpVO> list5=dao.empDeleteList(map);
	   map=new HashMap();
	   map.put("table_name", "emp_6");
	   List<EmpVO> list6=dao.empDeleteList(map);
	   map=new HashMap();
	   map.put("table_name", "emp_7");
	   List<EmpVO> list7=dao.empDeleteList(map);
	   map=new HashMap();
	   map.put("table_name", "emp_8");
	   List<EmpVO> list8=dao.empDeleteList(map);
	   map=new HashMap();
	   map.put("table_name", "emp_9");
	   List<EmpVO> list9=dao.empDeleteList(map);
	   map=new HashMap();
	   map.put("table_name", "emp_10");
	   List<EmpVO> list10=dao.empDeleteList(map);
	   
	   model.addAttribute("list", list);
	   model.addAttribute("list5", list5);
	   model.addAttribute("list6", list6);
	   model.addAttribute("list7", list7);
	   model.addAttribute("list8", list8);
	   model.addAttribute("list9", list9);
	   model.addAttribute("list10", list10);
	   return "emp/list";
   }
   @GetMapping("emp/delete.do")
   public String emp_delete(int empno) {
	   dao.allDelete(empno);
	   return "redirect:../emp/list.do";
   }
}
