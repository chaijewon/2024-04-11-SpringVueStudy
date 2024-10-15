package com.sist.vo;
/*
 *   CNO     NOT NULL NUMBER       
GNO              NUMBER       
ID               VARCHAR2(20) 
ACCOUNT          NUMBER       
ISBUY            NUMBER       
REGDATE          DATE     
 */

import java.util.*;
import lombok.Data;
@Data
public class CartVO {
   private int cno,gno,account,isbuy;
   private Date regdate;
   private String dbday,id;
   private MemberVO mvo=new MemberVO();
   private GoodsVO gvo=new GoodsVO();
}
