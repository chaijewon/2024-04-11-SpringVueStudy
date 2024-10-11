package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class FreeBoardServiceImpl implements FreeBoardService{
    @Autowired
    private FreeBoardDAO fDao;

	@Override
	public List<FreeBoardVO> freeboardListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.freeboardListData(start, end);
	}
	
	@Override
	public int freeboardRowCount() {
		// TODO Auto-generated method stub
		return fDao.freeboardRowCount();
	}
	
	@Override
	public void freeboardInsert(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		fDao.freeboardInsert(vo);
	}

	@Override
	public FreeBoardVO freeboardDetailData(int no) {
		// TODO Auto-generated method stub
		return fDao.freeboardDetailData(no);
	}

	@Override
	public void freeboardDelete(int no) {
		// TODO Auto-generated method stub
		fDao.freeboardDelete(no);
	}

	@Override
	public FreeBoardVO freeboardUpdateData(int no) {
		// TODO Auto-generated method stub
		return fDao.freeboardUpdateData(no);
	}

	@Override
	public void freeboardUpdate(FreeBoardVO vo) {
		// TODO Auto-generated method stub
		fDao.freeboardUpdate(vo);
	}
   
    /*
     *   JSP => .do
     *    |
     *   Controller 
     *    |
     *   Mapper
     *    | 
     *   DAO
     *    |
     *   Service 
     *    |
     *   ServiceImpl
     */
}
