package com.sist.vo;

import lombok.Data;

/*
 *  NO      NOT NULL NUMBER         
	TITLE   NOT NULL VARCHAR2(200)  
	POSTER  NOT NULL VARCHAR2(500)  
	MSG     NOT NULL VARCHAR2(4000) 
	ADDRESS NOT NULL VARCHAR2(300)  
	
	Spring 
	 1. MVC 
	 2. DI : 클래스 설계 => 메모리할당 , 자동 주입
	                                @Autowried , @Resource  (1.8이전)
	                     @Component 
	                     @Repository
	                     @Service 
	                     @Controller / @RestController
	 3. AOP : Transaction / Security / Commons 
	 4. ORM => MyBatis ====> JPA
	 =====================> 오라클 => MySQL  limit 0,10 
	  MVC => CRUD (게시판,댓글) 
	         목록 : 페이징 / 상세보기
	         
	  
	  ===========================
	  Spring 
	  1) DI / AOP 
	  2) Transaction 
	  3) MVC구조 
	  4) Session VS Cookie 
	  5) DAO VS Service
	  Java 
	  1) 객체지향 (캡슐화 VS 은닉화 , 상속 VS 포함 , 오버라이딩 VS 오버로딩)
	  2) Collection 
	  3) 추상 클래스 VS 인터페이스 
	  4) 쓰레드 (동기화 / 비동기화) 
	  HTML/JSP/CSS
	  1) GET / POST 
	  2) Session VS Cookie
	  3) JSTL / EL 
	  4) MVC구조
	     model1 VS model2 
	  JavaScript 
	  1) 클로저 
	  2) ES6 장점 : 변경 
	     let VS const VS var 
	  Oracle 
	  1) JOIN / SUBQUERY 
	  2) 프로시저 VS  트리거 
	  ============================== Basic 
	  나머지는 포트폴리어에서 주로 질문
	         ========
	         1. 1차 / 2차 / 개인  
	         
	  스프링 : 객체생성 ~ 객체 소멸 
	          => 기본 모든 클래스를 관리 
	             VO => 데이터형 (사용자)
	             ============
	             Mapper 
	             Service
	             ============ 인터페이스 => 연결용 
	                          ======== 98%
	          => 재사용 기법 : 싱글턴 
	          => @Autowired => 스프링에서 메모리할당된 클래스안에서만 찾아서 주소를 대입 
	                           ================
	                        => 오라클 : 자바를 유료화 
	                                  =========== 자바 => 코틀린 
	          var / val 
	          a=10
	          Java : 80% -> 포화 -> Front
	          MS : 20%
	  @Component => 싱글턴
	  @Scope("prototype") => 요청시마다 새롭게 메모리 할당 
	  class A
	  
	  VO 
	  DTO
	  =========== 데이터를 모아서 전송 
	  ENTITY 
	  =========== 데이터베이스 컬럼과 연동 => JPA
	  Spring => VO => Mybatis
	  *** Spring-Boot => Entity => JPA
	  
 */
@Data
public class SeoulVO {
    private int no;
    private String title,poster,msg,address,addr;
}
