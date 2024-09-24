package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.sist.vo.*;
/* 
 *   FormData 
 */
public interface DataBoardMapper {
	  @Select("SELECT no,subject,name,TO_CHAR(regdate,'yyyy-mm-dd') as dbday,hit,num "
			 +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			 +"FROM (SELECT no,subject,name,regdate,hit "
			 +"FROM vue_databoard ORDER BY no DESC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<DataBoardVO> databoardListData(@Param("start") int start,@Param("end") int end);
	  
	  @Select("SELECT COUNT(*) FROM vue_databoard")
	  public int databoardCount();
	  
	  // Mybatis에서 sequence 
	  @SelectKey(keyProperty = "no",resultType = int.class,before = true,
			  statement = "SELECT NVL(MAX(no)+1,1) as no FROM vue_databoard")
	  @Insert("INSERT INTO vue_databoard(no,name,subject,content,pwd,filename,filesize,filecount) "
			 +"VALUES(#{no},#{name},#{subject},#{content},"
			 +"#{pwd},#{filename},#{filesize},#{filecount})")
	  public void databoardInsert(DataBoardVO vo);
	    
}
