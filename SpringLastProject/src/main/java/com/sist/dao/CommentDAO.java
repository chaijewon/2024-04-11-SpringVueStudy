package com.sist.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 *   스프링에서 메모리 할당 ==> @Autowried 
 *           =========
 *           1. @Component : 일반 클래스 (추천=네이버API,뉴스 읽기,다른 프로그램 연동)  
 *           2. @Repository : DAO (데이터베이스 연결)
 *           3. @Service : DAO여러개 연동 
 *                 => Food / Reply
 *           4. @Controller : DispatcherServlet와 연결 => 사이트 페이지 이동
 *                 => 1) forward : request를 JSP를 전송
 *                                 ======= Model( 전송객체 ) 
 *                       return "경로명/JSP명";
 *                    2) redirect : 이미 만들어진 메소드 호출시에 사용 
 *                       _ok 
 *                       return "redirect:~.do";
 *              *** 유지보수 : 스프링프레임워크 ==> 1년 
 *                           Ajax => Vue / React 
 *                  => 전자정부 프레임워크 (공기업) => 관리자 모드 
 *              ================================================
 *              *** 개발 : 스프링부트 ==> 2년 
 *                        ======= JSP(X)
 *                        HTML => 타임리프 / Front를 별도로 작성 
 *                                         ================
 *                                          연결 => MSA
 *              파이썬 서버 (장고) === React 
 *              스프링부트 === React-Query , Redux 
 *                | MySql / MariaDB 
 *                  NVL => isnull
 *                  TO_CHAR => dateformat
 *                | MyBatis / JPA 
 *                  SELECT * FROM emp  => findAll() 
 *                  SELECT * FROM emp WHERE empno=1 => findByEmpno(int empno)
 *                            ==== JOIN/Subquery 
 *                | Vue+React => NextJS
 *              ================================================
 *           5. @RestController : DispatcherServlet와 연결 => 다른 프로그램과 연동 
 *                                모든 프로그램 언어 (파이썬,자바스크립트,코틀린) 
 *                                ====================================
 *                                  | XML , JSON
 *                                => 데이터만 전송 
 *           6. @ControllerAdvice,@RestControllerAdvice => 예외처리 
 *           
 *           => 메모리 할당(X) => @CrossOrigin , @Aspect , @RequestMapping
 *                              ============  =======   ================
 *                                            | 공통모듈   | 공통 경로 
 *                              | 포트번호가 틀린 경우 => 허용 
 *                             @Async : 비동기 
 *           => 메소드 위에 : @GetMapping,@PostMapping 
 *              ========
 *              멤버변수 : @Autowired
 *              => 구분자 : 어노테이션에 따라 주소 대입 , 메소드 호출 
 *           => MVC 
 *           클라이언트 : <a> , <form> , javascript 
 *                     요청 => .do => 화면보여달라 / 저장 / 수정 / 삭제 ...
 *              |
 *           DispatcherServlet : .do 자동 호출 
 *              | 요청 처리 => 사용자 정의 (Model) => Controller
 *                =======
 *                찾기 => 구분 (GetMapping,PostMapping) 
 *                ==== HandlerMapping 
 *                | model,request값을 전송 
 *                ViewResolver 
 *                | 
 *                JSP를 찾아서 요청 결과 출력 
 *            ====> Model(Controller,RestController)
 *                    | Controller , DAO , Service , VO
 *                      ===============================
 *                      |기능별로 분리 (재사용 , 수정편리하게 , 에러 처리) 
 *            ====> JSP 
 *            
 */
import java.util.*;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class CommentDAO {
  @Autowired
  private CommentMapper mapper;
  
  /*
   *   @Select("SELECT cno,rno,type,id,name,msg,likecount,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday,num "
		 +"FROM (SELECT cno,rno,type,id,name,msg,likecount,regdate,rownum as num "
		 +"FROM (SELECT cno,rno,type,id,name,msg,likecount,regdate "
		 +"FROM spring_comment WHERE rno=#{rno} "
		 +"ORDER BY group_id DESC , group_step ASC)) "
		 +"WHERE num BEWTEEN #{start} AND #{end}")
        public List<CommentVO> commentListData(Map map);
  
        @Select("SELECT CEIL(COUNT(*)/10.0) FROM spring_comment "
		  +"WHERE rno=#{rno}")
        public int commentTotalPage(int rno);
   */
  public List<CommentVO> commentListData(Map map)
  {
	  return mapper.commentListData(map);
  }
  public int commentTotalPage(Map map)
  {
	  return mapper.commentTotalPage(map);
  }
  /*
   *   @Insert("INSERT INTO spring_comment(cno,rno,id,name,sex,msg,group_id,type) "
		 +"VALUES(sc_cno_seq.nextval,#{rno},#{id},#{name},#{sex},#{msg},"
		 +"(SELECT NVL(MAX(group_id)+1,1) FROM spring_comment),#{type})")
       public void replyInsert(CommentVO vo);
   */
  public void commentInsert(CommentVO vo)
  {
	  mapper.foodReplyIncrement(vo.getRno());
	  mapper.commentInsert(vo);
  }
  /*
   *   @Select("SELECT group_id,group_step,group_tab "
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
   */
  // 일괄처리 
  @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
  public void commentReplyReplyInsert(int cno,CommentVO vo)
  {
	  mapper.foodReplyIncrement(vo.getRno());
	  CommentVO pvo=mapper.commentParentInfoData(cno);
	  vo.setGroup_id(pvo.getGroup_id());
	  vo.setGroup_step(pvo.getGroup_step()+1);
	  vo.setGroup_tab(pvo.getGroup_tab()+1);
	  
	  mapper.commentGroupStepIncrement(pvo);
	  mapper.commentReplyReplyInsert(vo);
	  mapper.commentDepthIncrement(cno);
	  
  }
  /*
   *   MyBatis 
   *   CRUD => INSERT / UPDATE / DELETE / SELECT => 1차
   *   Spring = MyBatis 
   *   CRUD / JOIN / 동적 쿼리 / Transaction
   *                 =======   ===========
   */
  /*
   *    @Select("SELECT group_id,group_step FROM spring_comment "
		 +"WHERE cno=#{cno}")
		  public CommentVO commentDeleteInfoData(int cno);
		  
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
   */
  public CommentVO commentDeleteInfoData(int cno)
  {
	  return mapper.commentDeleteInfoData(cno);
  }
  public void commentDelete(Map map)
  {
	   mapper.commentDelete(map);    
  }
  /*
   *   @Update("UPDATE project_food_house SET "
		 +"replycount=replycount+1 "
		 +"WHERE fno=#{fno}")
	  public void foodReplyIncrement(int fno);
	  
	  @Update("UPDATE project_food_house SET "
			 +"replycount=replycount-1 "
		     +"WHERE fno=#{fno}")
	  public void foodReplyDecrement(int fno);
   */
  /*public void foodReplyIncrement(int fno)
  {
	  mapper.foodReplyIncrement(fno);
  }
  public void foodReplyDecrement(int fno)
  {
	  mapper.foodReplyDecrement(fno);
  }*/
  public void foodReplyDecrement(int fno)
  {
	  mapper.foodReplyDecrement(fno);
  }
  public void commentUpdate(CommentVO vo)
  {
	  mapper.commentUpdate(vo);
  }
}
