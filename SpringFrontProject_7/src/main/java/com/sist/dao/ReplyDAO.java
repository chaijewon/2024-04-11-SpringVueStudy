package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class ReplyDAO {
   @Autowired
   private ReplyMapper mapper;
   
   /*
    *   @Select("SELECT rno,fno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
		 +"FROM spring_reply "
		 +"WHERE fno=#{fno}")
        public List<ReplyVO> replyListData(int fno);
    */
   public List<ReplyVO> replyListData(int fno)
   {
	   return mapper.replyListData(fno);
   }
   /*
    *   @SelectKey(keyProperty = "rno",resultType = int.class,before = true,
		  statement = "SELECT NVL(MAX(rno)+1,1) as rno FROM spring_reply")
	    @Insert("INSERT INTO spring_reply VALUES("
			 +"#{rno},#{fno},#{id},#{name},#{msg},SYSDATE)")
	    public void replyInsert(ReplyVO vo);
    */
   public void replyInsert(ReplyVO vo)
   {
	   mapper.replyInsert(vo);
   }
   /*
    *   @Delete("DELETE FROM spring_reply "
		 +"WHERE rno=#{rno}")
        public void replyDelete(int rno);
    */
   public void replyDelete(int rno)
   {
	   mapper.replyDelete(rno);
   }
}
