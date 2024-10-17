package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class SeoulDAO {
   @Autowired
   private SeoulMapper mapper;
   /*
    *   @Select("SELECT no,poster,title,num "
		  +"FROM (SELECT no,poster,title,rownum as num "
		  +"FROM (SELECT no,poster,title "
		  +"FROM seoul_location ORDER BY no ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
	   public List<SeoulVO> seoulLocationListData(Map map);
	   
	   @Select("SELECT no,poster,title,num "
				  +"FROM (SELECT no,poster,title,rownum as num "
				  +"FROM (SELECT no,poster,title "
				  +"FROM seoul_nature ORDER BY no ASC)) "
				  +"WHERE num BETWEEN #{start} AND #{end}")
	   public List<SeoulVO> seoulNatureListData(Map map);
	   
	   @Select("SELECT no,poster,title,num "
				  +"FROM (SELECT no,poster,title,rownum as num "
				  +"FROM (SELECT no,poster,title "
				  +"FROM seoul_shop ORDER BY no ASC)) "
				  +"WHERE num BETWEEN #{start} AND #{end}")
	   public List<SeoulVO> seoulShopListData(Map map);
	   
	   @Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_location")
       public int seoulLocationTotalPage();
    */
   public List<SeoulVO> seoulLocationListData(Map map)
   {
	   return mapper.seoulLocationListData(map);   
   }
   public int seoulLocationTotalPage()
   {
	   return mapper.seoulLocationTotalPage();
   }
   public List<SeoulVO> seoulNatureListData(Map map)
   {
	   return mapper.seoulNatureListData(map);
   }
   public int seoulNatureTotalPage()
   {
	   return mapper.seoulNatureTotalPage();
   }
   public List<SeoulVO> seoulShopListData(Map map)
   {
	   return mapper.seoulShopListData(map);
   }
   public int seoulShopTotalPage()
   {
	   return mapper.seoulShopTotalPage();
   }
   /*
    *   @Select("SELECT no,title,poster,msg,address "
		  +"FROM project_seoul_location "
		  +"WHERE no=#{no}")
	   public SeoulVO seoulLocationDataData(int no);
	   
	   @Select("SELECT no,title,poster,msg,address "
				  +"FROM project_seoul_nature "
				  +"WHERE no=#{no}")
	   public SeoulVO seoulNatureDataData(int no);
	   
	   @Select("SELECT no,title,poster,msg,address "
				  +"FROM project_seoul_shop "
				  +"WHERE no=#{no}")
	   public SeoulVO seoulShopDataData(int no);
    */
   public SeoulVO seoulLocationDataData(int no)
   {
	   return mapper.seoulLocationDataData(no);
   }
   public SeoulVO seoulNatureDataData(int no)
   {
	   return mapper.seoulNatureDataData(no);
   }
   public SeoulVO seoulShopDataData(int no)
   {
	   return mapper.seoulShopDataData(no);
   }
}
