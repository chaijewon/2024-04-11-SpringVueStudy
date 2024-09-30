package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 *   링크 : JSP 
 *          |
 *         @Controller => Mapper => DAO => Service => ServiceImpl
 *                         |         |        |            |
 *                                          기능(메소드)     구현 
 *                        SQL     구현된 Mapper
 *              |
 *            데이터베이스 내용을 JSP로 전송 
 *            1. JSP로 전송 => Model
 *            2. Vue로 전송 => JSON
 */
@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    private FoodDAO fDao;

	@Override
	public List<FoodVO> foodHitTop5() {
		// TODO Auto-generated method stub
		return fDao.foodHitTop5();
	}

	@Override
	public List<FoodVO> foodListData(int start, int end) {
		// TODO Auto-generated method stub
		return fDao.foodListData(start, end);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return fDao.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

	// Cookie용 
	@Override
	public FoodVO foodInfoData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodInfoData(fno);
	}

	@Override
	public List<FoodVO> foodFindListData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodFindListData(map);
	}

	@Override
	public int foodFindTotalPage(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodFindTotalPage(map);
	}

	@Override
	public List<FoodVO> foodTypeListData(String type) {
		// TODO Auto-generated method stub
		return fDao.foodTypeListData(type);
	}
  
  
}
