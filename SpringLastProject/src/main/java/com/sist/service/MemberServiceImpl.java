package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberDAO mDao;

	@Override
	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return mDao.idCheck(userId);
	}

	@Override
	public void memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		mDao.memberInsert(vo);
	}

	@Override
	public void memberAuthorityInsert(String userId) {
		// TODO Auto-generated method stub
		mDao.memberAuthorityInsert(userId);
	}

	@Override
	public MemberVO memberSessionData(String userId) {
		// TODO Auto-generated method stub
		return mDao.memberSessionData(userId);
	}

	@Override
	public MemberVO memberInfoData(String userId) {
		// TODO Auto-generated method stub
		return mDao.memberInfoData(userId);
	}
    
}
