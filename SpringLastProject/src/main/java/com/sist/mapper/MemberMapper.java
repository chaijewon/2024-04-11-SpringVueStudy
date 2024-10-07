package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;
/*
 *   USERID                                    NOT NULL VARCHAR2(20)
 USERNAME                                  NOT NULL VARCHAR2(50)
 USERPWD                                   NOT NULL VARCHAR2(20)
 ENABLED                                            NUMBER(1)
 SEX                                                VARCHAR2(6)
 BIRTHDAY                                  NOT NULL VARCHAR2(20)
 EMAIL                                              VARCHAR2(100)
 POST                                      NOT NULL VARCHAR2(10)
 ADDR1                                     NOT NULL VARCHAR2(500)
 ADDR2                                              VARCHAR2(500)
 PHONE                                              VARCHAR2(20)
 CONTENT                                            CLOB
 */
public interface MemberMapper {
  //ID중복 체크 
  @Select("SELECT COUNT(*) FROM spring_member "
		 +"WHERE userId=#{userId}")
  public int idCheck(String userId);
  // 회원 가입 
  @Insert("INSERT INTO spring_member(userId,userName,userPwd,enabled,"
		 +"sex,birthday,email,post,addr1,addr2,phone,content) "
		 +"VALUES(#{userId},#{userName},"
		 +"#{userPwd},1,#{sex},#{birthday},#{email},"
		 +"#{post},#{addr1},#{addr2},#{phone},#{content})")
  public void memberInsert(MemberVO vo);
  // role_admin / role_user
  @Insert("INSERT INTO authority VALUES(#{userId},'ROLE_USER')")
  public void memberAuthorityInsert(String userId);
}

