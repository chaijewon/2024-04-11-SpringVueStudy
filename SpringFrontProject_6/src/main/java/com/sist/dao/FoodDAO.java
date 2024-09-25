package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    *   @Select("SELECT fno,poster,type,name,num "
		  +"FROM (SELECT fno,poster,type,name,rownum as num "
		  +"FROM (SELECT fno,poster,type,name "
		  +"FROM project_food_house "
		  +"WHERE type LIKE '%'||#{type}||'%' ORDER BY fno)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
		   public List<FoodVO> foodTypeListData(Map map);
		   
		   @Select("SELECT CEIL(COUNT(*)/20.0) FROM project_food_house "
				  +"WHERE type LIKE '%'||#{type}||'%'")
		   public int foodTypeTotalPage(String type);
    */
   public List<FoodVO> foodTypeListData(Map map)
   {
	   return mapper.foodTypeListData(map);
   }
   public int foodTypeTotalPage(String type)
   {
	   return mapper.foodTypeTotalPage(type);
   }
   // 상세보기 
   /*
    *  // 상세보기 
	   @Update("UPDATE project_food_house SET "
			  +"hit=hit+1 "
			  +"WHERE fno=#{fno}")
	   public void hitIncrement(int fno);
	   @Select("SELECT fno,name,type,phone,address,theme,poster,images,time,"
			  +"content,score "
			  +"FROM project_food_house "
			  +"WHERE fno=#{fno}")
	   public FoodVO foodDetailData(int fno);
    */
   public FoodVO foodDetailData(int fno)
   {
	   mapper.hitIncrement(fno);
	   return mapper.foodDetailData(fno);
   }
   
   /*
    *   @Select("SELECT fno,name,poster,rownum "
		  +"FROM (SELECT fno,name,poster "
		  +"FROM project_food_house "
		  +"WHERE address LIKE '%'||#{adddress}||'%' "
		  +"ORDER BY hit DESC) "
		  +"WHERE rownum<=5")
         public List<FoodVO> foodRearHouseData(String address);
    */
   public List<FoodVO> foodRearHouseData(String address)
   {
	   return mapper.foodRearHouseData(address);
   }
}
