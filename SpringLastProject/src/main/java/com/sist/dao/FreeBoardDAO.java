package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 형식동일 => 마이페이지,관리자페이지에서 여러개를 동시에 삭제  
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FreeBoardDAO {
   @Autowired
   private FreeBoardMapper mapper;
   
   /*
    *   @Select("SELECT no,subject,id,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,num "
		 +"FROM (SELECT no,subject,id,name,regdate,rownum as num "
		 +"FROM (SELECT no,subject,id,name,regdate "
		 +"FROM spring_freeboard ORDER BY no DESC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
		  public List<FreeBoardVO> freeboardListData(@Param("start") int start,
				  @Param("end") int end);
		  @Select("SELECT COUNT(*) FROM spring_freeboard")
		  public int freeboardRowCount();
		  
		  // 수정 / 삭제 / 추가 / 상세보기 => 여러개를 동시에 처리 방법 
		  @Insert("INSERT INTO spring_freeboard VALUES("
				 +"sf_no_seq.nextval,#{id},#{name},#{subject},#{content},"
				 +"SYSDATE,0)")
		  public void freeboardInsert(FreeBoardVO vo);
    */
   public List<FreeBoardVO> freeboardListData(int start,int end)
   {
	   return mapper.freeboardListData(start, end);
   }
   public int freeboardRowCount()
   {
	   return mapper.freeboardRowCount();
   }
   public void freeboardInsert(FreeBoardVO vo)
   {
	   mapper.freeboardInsert(vo);
   }
   /*
    *    @Update("UPDATE spring_freeboard SET "
		 +"hit=hit+1 "
		 +"WHERE no=#{no}")
		  public void hitIncrement(int no);
		  
		  @Select("SELECT no,id,name,subject,content,"
				 +"TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,hit "
				 +"FROM spring_freeboard "
				 +"WHERE no=#{no}")
		  public FreeBoardVO freeboardDetailData(int no);
    */
   public FreeBoardVO freeboardDetailData(int no)
   {
	   mapper.hitIncrement(no);
	   return mapper.freeboardDetailData(no);
   }
   /*
    *  @Delete("DELETE FROM spring_freeboard "
		 +"WHERE no=#{no}")
       public void freeboardDelete(int no);
    */
   public void freeboardDelete(int no)
   {
	   mapper.freeboardDelete(no);
   }
}
