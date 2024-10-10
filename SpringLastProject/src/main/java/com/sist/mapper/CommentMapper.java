package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;
public interface CommentMapper {
  @Select("SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,num "
		 +"FROM (SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,regdate,rownum as num "
		 +"FROM (SELECT cno,rno,type,id,name,msg,sex,group_tab,likecount,regdate "
		 +"FROM spring_comment WHERE rno=#{rno} AND type=#{type} "
		 +"ORDER BY group_id DESC , group_step ASC)) "
		 +"WHERE num BETWEEN #{start} AND #{end}")
  public List<CommentVO> commentListData(Map map);
  
  @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_comment "
		 +"WHERE rno=#{rno} AND type=#{type}")
  public int commentTotalPage(Map map);
  
  // 댓글 입력 
  @Insert("INSERT INTO spring_comment(cno,rno,id,name,sex,msg,group_id,type) "
		 +"VALUES(sc_cno_seq.nextval,#{rno},#{id},#{name},#{sex},#{msg},"
		 +"(SELECT NVL(MAX(group_id)+1,1) FROM spring_comment),#{type})")
  public void commentInsert(CommentVO vo);
  /*
   *    AAAAA 
   *      =LLLLL
   *      =BBBBB
   *      =CCCCC
   *      =DDDDD
   *    KKKKK
   */
  // 대댓글 
  @Select("SELECT group_id,group_step,group_tab "
		 +"FROM spring_comment "
		 +"WHERE cno=#{cno}")
  public CommentVO commentParentInfoData(int cno);
  
  @Update("UPDATE spring_comment SET "
		 +"group_step=group_step+1 "
		 +"WHERE group_id=#{group_id} AND group_step>#{group_step}")
  public void commentGroupStepIncrement(CommentVO vo);
  //cno,rno,id,name,sex,msg,group_id,type
  @Insert("INSERT INTO spring_comment(cno,rno,id,name,sex,msg,group_id,"
		 +"group_step,group_tab,root,type) "
	     +"VALUES(sc_cno_seq.nextval,#{rno},#{id},#{name},#{sex},"
		 +"#{msg},#{group_id},#{group_step},#{group_tab},#{root},#{type})"
		 )
  public void commentReplyReplyInsert(CommentVO vo);
  
  @Update("UPDATE spring_comment SET "
		 +"depth=depth+1 "
		 +"WHERE cno=#{cno}")
  public void commentDepthIncrement(int cno);
  
  // 삭제하기 
  @Select("SELECT group_id,group_step FROM spring_comment "
		 +"WHERE cno=#{cno}")
  public CommentVO commentDeleteInfoData(int cno);
  // 동적 쿼리 => 여러개의 SQL문장을 사용자 요청에 따라 한개의 SQL문장으로 처리
  // 삭제 / 검색 => 관리자 모드 : 삭제 / 수정 => 체크박스 
  //              => 등급 => 동적쿼리 
  @Delete("<script>"
		 +"DELETE FROM spring_comment "
		 +"WHERE "
		 +"<if test=\"group_step==0\">"
		 +"group_id=#{group_id}"
		 +"</if> "
		 +"<if test=\"group_step!=0\">"
		 +"cno=#{cno} "
		 +"</if>"
		 +"</script>"
		 )
  public void commentDelete(Map map);
  
  @Update("UPDATE project_food_house SET "
		 +"replycount=replycount+1 "
		 +"WHERE fno=#{fno}")
  public void foodReplyIncrement(int fno);
  
  @Update("UPDATE project_food_house SET "
		 +"replycount=replycount-1 "
	     +"WHERE fno=#{fno}")
  public void foodReplyDecrement(int fno);
  
  // 수정 
  @Update("UPDATE spring_comment SET "
		 +"msg=#{msg} "
		 +"WHERE cno=#{cno}")
  public void commentUpdate(CommentVO vo);
}
