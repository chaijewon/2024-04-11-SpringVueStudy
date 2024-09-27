package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class RecipeDAO {
  @Autowired
  private RecipeMapper mapper;
  
  /*
   *   @Select("SELECT no,title,poster,chef,hit,"
		 +"(SELECT content FROM recipedetail WHERE no=recipe.no) as content "
		 +"FROM recipe "
		 +"WHERE hit=(SELECT MAX(hit) FROM recipe)")
	   public RecipeVO recipeMaxHitData();
	   
	   @Select("SELECT no,title,poster,chef,hit,content,rownum "
			  +"FROM (SELECT no,title,poster,chef,hit,"
			  +"(SELECT content FROM recipedetail WHERE no=recipe.no) as content "
			  +"FROM recipe ORDER BY hit DESC) "
			  +"WHERE rownum<=8")
	   public List<RecipeVO> recipeHitTop8();
   */
  public RecipeVO recipeMaxHitData()
  {
	  return mapper.recipeMaxHitData();
  }
  public List<RecipeVO> recipeHitTop8()
  {
	  return mapper.recipeHitTop8();
  }
  
  // 목록 
  /*
   *   @Select("SELECT no,poster,title,chef,hit,num "
		 +"FROM (SELECT no,poster,title,chef,hit,rownum as num "
		 +"FROM (SELECT + INDEX_ASC(recipe recipe_no_pk)no,poster,title,chef,hit "
		 +"FROM recipe WHERE no IN(SELECT no FROM recipe "
		 +"INTERSECT SELECT no FROM recipedetail))) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
	   public List<RecipeVO> recipeListData(Map map);
	   
	   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
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
  
  // 상세보기 
  /*
   *    @Update("UPDATE recipe SET "
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
