package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class ReserveDAO {
   @Autowired
   private ReserveMapper mapper;
   
   /*
    *   @Select("SELECT fno,poster,name,num "
		 +"FROM (SELECT fno,poster,name,rownum as num "
		 +"FROM (SELECT + INDEX_ASC(project_food_house fh_fno_pk)fno,poster,name "
		 +"FROM project_food_house WHERE type LIKE '%'||#{type}||'%')) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<FoodVO> reserveFoodInfoData(Map map);
		  
		  @Select("SELECT CEIL(COUNT(*)/30.0) FROM project_food_house "
				 +"WHERE type LIKE '%'||#{type}||'%'")
		  public int reserveFoodTotalPage();
    */
   public List<FoodVO> reserveFoodInfoData(Map map)
   {
	   return mapper.reserveFoodInfoData(map);
   }
   public int reserveFoodTotalPage(Map map)
   {
	   return mapper.reserveFoodTotalPage(map);   
   }
   /*
    *   @Insert("INSERT INTO spring_reserve(rno,fno,id,rday,rtime,rinwon) "
		 +"VLAUES(sr2_rno_seq.nextval,#{fno},#{id},"
		 +"#{rday},#{rtime},#{rinwon})")
        public void reserveInsert(ReserveVO vo);
    */
   public void reserveInsert(ReserveVO vo)
   {
	   mapper.reserveInsert(vo);
   }
   public List<ReserveVO> reserveMyPageListData(String id)
   {
	   return mapper.reserveMyPageListData(id);
   }
}
