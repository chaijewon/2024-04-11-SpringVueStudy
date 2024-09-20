package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface RecipeMapper {
  @Select("SELECT no,chef,poster,title,num "
		 +"FROM (SELECT no,chef,poster,title,rownum as num "
		 +"FROM (SELECT no,chef,poster,title "
		 +"FROM recipe WHERE no IN(SELECT no FROM recipe "
		 +"INTERSECT SELECT no FROM recipedetail) "
		 +"ORDER BY no ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<RecipeVO> recipeListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe "
		 +"WHERE no IN(SELECT no FROM recipe "
		 +"INTERSECT SELECT no FROM recipedetail)")
  public int recipeTotalPage();
  
  @Update("UPDATE recipe SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
  public void hitIncrement(int no);
  
  @Select("SELECT * FROM recipedetail "
		 +"WHERE no=#{no}")
  public RecipeDetailVO recipeDetailData(int no);
}
