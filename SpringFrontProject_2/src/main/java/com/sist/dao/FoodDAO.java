package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
/*
 *    1. 스프링 어노테이션 
 *       = 메모리 할당 => 스프링에 클래스 관리 
 *                            ========= 생성 ~ 소멸 => 필요시에는 주소값을 얻어서 사용 
 *         구분
 *         ===
 *          DAO  ========> @Repository : 저장소 , 데이터베이스 연결 
 *          SERVICE =====> @Service : BI (DAO 여러개를 통합) 
 *          MODEL   =====>
 *                         화면제어 : @Controller
 *                         자바스크립트/코틀린 다른 언어와 연결 : @RestController 
 *                         ============================ JSON
 *          Exception ===> 공통 예외처리 => 모든 모델 클래스의 예외처리 한번에 처리
 *                         @ControllerAdvice / @RestControllerAdvice
 *          일반 클래스 : OpenAPI => @Component
 *       = 모든 클래스를 메모리 할당 요청하지는 않는다 
 *         ~VO : 사용자 정의 데이터형 
 *         인터페이스는 메모리 할당을 하지 않는다 
 *       = 공통으로 사용되는 기능을 모아서 관리 => 공통모듈 
 *         @Aspect => AOP 
 *         
 *       = 자바로 환경 설정 => @Bean
 *       = React연결 : port가 다르다 (서버연결을 할 수 없다 => 포토 허용)
 *       = 보안 / 스케쥴러 
 *        
 */
@Repository
public class FoodDAO {
   @Autowired
   private FoodMapper mapper; // 스프링에서 구현된 객체주소를 받는다 => 자동주입
   
   /*
    *   @Select("SELECT fno,name,poster,num "
		 +"FROM (SELECT fno,name,poster,rownum as num "
		 +"FROM (SELECT fno,name,poster "
		 +"FROM project_food_house ORDER BY fno ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<FoodVO> foodListData(@Param("start") int start,@Param("end") int end);
		  // 여러개의 매개변수 => @Param , Map , VO
		  @Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house")
		  public int foodTotalPage();
    */
   public List<FoodVO> foodListData(int start,int end)
   {
	   return mapper.foodListData(start, end);
   }
   public int foodTotalPage()
   {
	   return mapper.foodTotalPage();
   }
   
   /*
    *    @Select("SELECT fno,name,poster,num "
			 +"FROM (SELECT fno,name,poster,rownum as num "
			 +"FROM (SELECT fno,name,poster "
			 +"FROM project_food_house WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<FoodVO> foodFindListData(Map map);
			  // 여러개의 매개변수 => @Param , Map , VO
		  @Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house "
				 +"WHERE address LIKE '%'||#{address}||'%'")
		  public int foodFindTotalPage(Map map);
    */
   public List<FoodVO> foodFindListData(Map map)
   {
	   return mapper.foodFindListData(map);
   }
   public int foodFindTotalPage(Map map)
   {
	   return mapper.foodFindTotalPage(map);
   }
}
