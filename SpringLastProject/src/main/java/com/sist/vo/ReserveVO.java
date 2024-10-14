package com.sist.vo;
/*
 *   RNO       NOT NULL NUMBER       
	FNO                NUMBER       
	ID                 VARCHAR2(20) 
	RDAY      NOT NULL VARCHAR2(30) 
	RTIME     NOT NULL VARCHAR2(30) 
	RINWON    NOT NULL VARCHAR2(20) 
	REGDATE            DATE         
	ISRESERVE          NUMBER       

 */
import java.util.*;

import lombok.Data;
@Data
public class ReserveVO {
  private int rno,fno,isReserve;
  private String id,rday,rtime,rinwon,dbday;
  private Date regdate;
  private FoodVO fvo=new FoodVO();
  private MemberVO mvo=new MemberVO();
}
