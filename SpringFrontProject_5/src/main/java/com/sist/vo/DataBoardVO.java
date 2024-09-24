package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class DataBoardVO {
  private int no,hit,filecount;
  private String name,subject,content,pwd,filename,filesize,dbday;
  private Date regdate;
  // Update File을 저장하는 List
  // => files[0] , files[1] ...... 
  private List<MultipartFile> files;
}
