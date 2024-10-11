package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class ChefDAO {
  @Autowired
  private ChefMapper mapper;
  
  /*
   *   @Select("SELECT chef,poster "
  		+ "FROM chef "
  		+ "WHERE chef=(SELECT chef FROM recipe WHERE hit=(SELECT MAX(hit) FROM recipe))")
        public ChefVO chefToday();
   */
  public ChefVO chefToday()
  {
	  return mapper.chefToday();
  }
  
  /*
   *   @Select("SELECT chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2,num "
		 +"FROM (SELECT chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2,"
		 +"rownum as num "
		 +"FROM (SELECT /+ INDEX_ASC(chef chef_chef_pk)/chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2 "
		 +"FROM chef)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<ChefVO> chefListData(Map map);
	  
	  @Select("SELECT CEIL(COUNT(*)/20.0) FROM chef")
	  public int chefTotalPage();
   */
  public List<ChefVO> chefListData(Map map)
  {
	  return mapper.chefListData(map);
  }
  public int chefTotalPage()
  {
	  return mapper.chefTotalPage();
  }
}
