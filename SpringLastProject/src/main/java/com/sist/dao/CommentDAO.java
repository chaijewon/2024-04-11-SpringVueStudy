package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
}
