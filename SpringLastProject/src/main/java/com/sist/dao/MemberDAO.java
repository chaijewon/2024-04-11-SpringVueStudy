package com.sist.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class MemberDAO {
   @Autowired
   private MemberMapper mapper;
   
   /*
    *   @Select("SELECT COUNT(*) FROM spring_member "
		 +"WHERE userId=#{userId}")
        public int idCheck(String userId);
    */
   public int idCheck(String userId)
   {
	   return mapper.idCheck(userId);
   }
   /*
    *    // 회원 가입 
  @Insert("INSERT INTO spring_member(userId,userName,userPwd,enabled,"
		 +"sex,birthday,email,post,addr1,addr2,phone,content) "
		 +"VALUES(#{userId},#{userName},"
		 +"#{userPwd},1,#{sex},#{birthday},#{email},"
		 +"#{post},#{addr1},#{addr2},#{phone},#{content})")
  public void memberInsert(MemberVO vo);
  // role_admin / role_user
  @Insert("INSERT INTO authority VALUES(#{userId},'ROLE_USER')")
  public void memberAuthorityInsert(String userId);
    */
   public void memberInsert(MemberVO vo) {
	   mapper.memberInsert(vo);
   }
   public void memberAuthorityInsert(String userId)
   {
	   mapper.memberAuthorityInsert(userId);
   }
}
