package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface RecipeMapper {
   // 1. 오라클에서 실행여부 확인 
   @Select("SELECT no,title,poster,chef,hit,"
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
}
