package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
  @Select("SELECT fno,name,poster,address,rownum "
		 +"FROM (SELECT fno,name,poster,address "
		 +"FROM project_food_house ORDER BY hit DESC) "
		 +"WHERE rownum<=5")
  public List<FoodVO> foodHitTop5();
}
