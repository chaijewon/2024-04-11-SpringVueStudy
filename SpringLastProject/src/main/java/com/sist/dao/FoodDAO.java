package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
  @Autowired
  private FoodMapper mapper;
  
  /*
   *   @Select("SELECT fno,name,poster,address,rownum "
		 +"FROM (SELECT fno,poster,address "
		 +"FROM project_food_house ORDER BY hit DESC) "
		 +"WHERE rownum<=5")
        public List<FoodVO> foodHitTop5();
   */
  public List<FoodVO> foodHitTop5()
  {
	  return mapper.foodHitTop5();
  }
}
