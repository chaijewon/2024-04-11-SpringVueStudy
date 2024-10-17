package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
public interface NaverMapper {
   @Insert("INSERT INTO naverData VALUES("
		  +"(SELECT NVL(MAX(no)+1,1) FROM naverData),#{word})")
   public void naverInsert(String word);
   
   @Delete("DELETE FROM naverData")
   public void naverDelete();
   
   @Select("SELECT word FROM naverData WHERE no=1")
   public String naverSelectData();
}
