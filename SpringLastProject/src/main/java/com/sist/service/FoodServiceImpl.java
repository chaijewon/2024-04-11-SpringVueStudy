package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    private FoodDAO fDao;

	@Override
	public List<FoodVO> foodHitTop5() {
		// TODO Auto-generated method stub
		return fDao.foodHitTop5();
	}
  
  
}
