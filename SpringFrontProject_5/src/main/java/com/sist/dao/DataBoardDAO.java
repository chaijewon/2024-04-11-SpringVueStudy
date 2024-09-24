package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class DataBoardDAO {
   @Autowired
   private DataBoardMapper mapper;
   
   /*
    *     @Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit,num "
			 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			 +"FROM (SELECT no,subject,name,regdate,hit "
			 +"FROM vue_databoard ORDER BY no DESC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<DataBoardVO> databoardListData(@Param("start") int start,@Param("end") int end);
		  
		  @Select("SELECT CEIL(COUNT(*)/10.0) FROM vue_databoard")
		  public int databoardTotalPage();
    */
   public List<DataBoardVO> databoardListData(int start,int end)
   {
	   return mapper.databoardListData(start, end);
   }
   public int databoardCount()
   {
	   return mapper.databoardCount();
   }
   /*
    *     @SelectKey(keyProperty = "no",resultType = int.class,before = true,
			  statement = "SELECT NVL(MAX(no)+1,1) as no FROM vue_databoard")
		  @Insert("INSERT INTO vue_databoard(no,name,subject,content,pwd,filename,filesize,filecount) "
				 +"VALUES(#{no},#{name},#{subject},#{content},"
				 +"#{pwd},#{filename},#{filesize},#{filecount})")
		  public void databoardInsert(DataBoardVO vo);
    */
   public void databoardInsert(DataBoardVO vo)
   {
	   mapper.databoardInsert(vo);
   }
   /*
    *   // 조회수 증가 
	  @Update("UPDATE vue_databoard SET "
			 +"hit=hit+1 "
			 +"WHERE no=#{no}")
	  public void hitIncrement(int no);
	  // 게시물의 모든 데이터를 읽기
	  @Select("SELECT no,name,subject,content,TO_CHAR(regdate,'yyyy-mm-dd hh24:mi:ss') as dbday,"
			 +"filename,filesize,filecount "
			 +"FROM vue_databoard "
			 +"WHERE no=#{no}")
	  public DataBoardVO databoardDetailData(int no);
    */
   public DataBoardVO databoardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.databoardDetailData(no);
   }
}
