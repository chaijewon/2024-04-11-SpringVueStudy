package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class CommentServiceImpl implements CommentService{
     @Autowired
     private CommentDAO cDao;

	@Override
	public List<CommentVO> commentListData(Map map) {
		// TODO Auto-generated method stub
		return cDao.commentListData(map);
	}
	
	@Override
	public int commentTotalPage(Map map) {
		// TODO Auto-generated method stub
		return cDao.commentTotalPage(map);
	}
	  
  
}
