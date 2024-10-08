package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface CommentService {
	public List<CommentVO> commentListData(Map map);
	public int commentTotalPage(Map map);
}
