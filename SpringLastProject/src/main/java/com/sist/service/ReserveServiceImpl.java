package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class ReserveServiceImpl implements ReserveService{
    @Autowired
    private ReserveDAO rDao;

	@Override
	public List<FoodVO> reserveFoodInfoData(Map map) {
		// TODO Auto-generated method stub
		return rDao.reserveFoodInfoData(map);
	}
	
	@Override
	public int reserveFoodTotalPage(Map map) {
		// TODO Auto-generated method stub
		return rDao.reserveFoodTotalPage(map);
	}

	@Override
	public void reserveInsert(ReserveVO vo) {
		// TODO Auto-generated method stub
		rDao.reserveInsert(vo);
	}

	@Override
	public List<ReserveVO> reserveMyPageListData(String id) {
		// TODO Auto-generated method stub
		return rDao.reserveMyPageListData(id);
	}

	@Override
	public List<ReserveVO> reserveAdminListData() {
		// TODO Auto-generated method stub
		return rDao.reserveAdminListData();
	}

	@Override
	public void reserveOk(int rno) {
		// TODO Auto-generated method stub
		rDao.reserveOk(rno);
	}

	@Override
	public ReserveVO reserveInfoData(int rno) {
		// TODO Auto-generated method stub
		return rDao.reserveInfoData(rno);
	}
   
   
}
