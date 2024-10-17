package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Service
public class SeoulServiceImpl implements SeoulService{
    @Autowired
    private SeoulDAO sDao;

	@Override
	public List<SeoulVO> seoulLocationListData(Map map) {
		// TODO Auto-generated method stub
		return sDao.seoulLocationListData(map);
	}

	@Override
	public List<SeoulVO> seoulNatureListData(Map map) {
		// TODO Auto-generated method stub
		return sDao.seoulNatureListData(map);
	}

	@Override
	public List<SeoulVO> seoulShopListData(Map map) {
		// TODO Auto-generated method stub
		return sDao.seoulShopListData(map);
	}

	@Override
	public int seoulNatureTotalPage() {
		// TODO Auto-generated method stub
		return sDao.seoulNatureTotalPage();
	}

	@Override
	public int seoulLocationTotalPage() {
		// TODO Auto-generated method stub
		return sDao.seoulLocationTotalPage();
	}

	@Override
	public int seoulShopTotalPage() {
		// TODO Auto-generated method stub
		return sDao.seoulShopTotalPage();
	}
    
    
}
