package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class RecipeDAO {
   @Autowired
   private RecipeMapper mapper;
   
   /*
    *   @Select("SELECT no,chef,poster,title,num "
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
    */
   public List<RecipeVO> recipeListData(Map map)
   {
	   return mapper.recipeListData(map);
   }
   public int recipeTotalPage()
   {
	   return mapper.recipeTotalPage();
   }
   
   /*
    *   @Update("UPDATE recipe SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
	  public void hitIncrement(int no);
	  
	  @Select("SELECT * FROM recipedetail "
			 +"WHERE no=#{no}")
	  public RecipeDetailVO recipeDetailData(int no);
    */
   public RecipeDetailVO recipeDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.recipeDetailData(no);
   }
}
