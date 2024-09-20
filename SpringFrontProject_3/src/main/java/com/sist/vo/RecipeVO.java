package com.sist.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

/*
 *   NO     NOT NULL NUMBER         
	TITLE  NOT NULL VARCHAR2(1000) 
	POSTER NOT NULL VARCHAR2(500)  
	CHEF   NOT NULL VARCHAR2(100)  
	LINK            VARCHAR2(500)  
	HIT             NUMBER
	
	SpringFramework 
	  = DI / AOP 
	  = MVC = <jsp:include> , tiles
	  = ORM = Transaction
	  =============================
	  = Validation 
 */
@Data
public class RecipeVO {
   private int no;
   private int hit;
   private String title,poster,chef;
}
