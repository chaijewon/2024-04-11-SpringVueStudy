package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository
public class NaverDAO {
    @Autowired
    private NaverMapper mapper;
    
    /*
     *     @Insert("INSERT INTO naverData VALUES("
		   +"(SELECT NVL(MAX(no)+1,1) FROM naverData),#{word})")
		   public void naverInsert(String word);
		   
		   @Delete("DELETE FROM naverData")
		   public void naverDelete();
		   
		   @Select("SELECT word FROM naverData WHERE no=1")
		   public String naverSelectData();
     */
    public void naverInsert(String word)
    {
    	mapper.naverInsert(word);
    }
    public void naverDelete()
    {
    	mapper.naverDelete();
    }
    public String naverSelectData()
    {
    	return mapper.naverSelectData();
    }
}
