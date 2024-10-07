package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
/*
 *   ~VO : 데이터형 => class
 *                   ===== 관련된 데이터를 모아서 관리 (다른 데이터형을 모아서 처리)
 *                   = 데이터형 클래스 
 *                   = 액션 클래스 (기능=>메소드)
 *                     ~DAO / ~Manager / ~Service / ~Controller / ~RestController
 *                     =====  ========  =========   ============  ===============
 *                                                  @Controller   @RestController
 *                                      DAO여러개를 통합해서 사용(BI)
 *                                      @Service
 *                            @Component
 *                            AOP
 *                     @Repository
 *                     ========> 스프링에서 관리 => 반드시 등록 (생성~소멸)
 *   ~Mapper
 *   ~Service
 *   ===================== 메모리 할당에서 제외 
 */
@Repository
public class RecipeDAO {
   @Autowired
   private RecipeMapper mapper;
   /*
    *  // 목록 출력 
	   @Select("SELECT no,poster,title,chef,hit,num "
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
	   
	   // 상세보기 
	   @Update("UPDATE recipe SET "
			  +"hit=hit+1 "
			  +"WHERE no=#{no}")
	   public void hitIncrement(int no);
	   
	   @Select("SELECT * FROM recipedetail "
			  +"WHERE no=#{no}")
	   public RecipeDetailVO recipeDetailData(int no);
    */
   public List<RecipeVO> recipeListData(Map map)
   {
	   return mapper.recipeListData(map);
   }
   public int recipeTotalPage()
   {
	   return mapper.recipeTotalPage();
   }
   public RecipeDetailVO recipeDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.recipeDetailData(no);
   }
}



