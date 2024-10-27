package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.EmpVO;
@Repository
public class EmpDAO {
   @Autowired
   private EmpMapper mapper;
   
   public void allDelete(int empno)
   {
	   mapper.allDelete(empno);
   }
   public List<EmpVO> empListData()
   {
	   return mapper.empListData();
   }
   //
   public List<EmpVO> empDeleteList(Map map)
   {
	   return mapper.empDeleteList(map);
   }
}
