package com.sist.vo;
/*
 *  NO                                        NOT NULL NUMBER
 ID                                                 VARCHAR2(20)
 NAME                                      NOT NULL VARCHAR2(50)
 SUBJECT                                   NOT NULL VARCHAR2(2000)
 CONTENT                                   NOT NULL CLOB
 REGDATE                                            DATE
 HIT                                                NUMBER
 */
import java.util.*;

import lombok.Data;
@Data // getter/setter
public class FreeBoardVO {
   private int no,hit;
   private String id,name,subject,content,dbday;
   private Date regdate;
}
