package com.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeDAO rDao;

	@Override
	public RecipeVO recipeMaxHitData() {
		// TODO Auto-generated method stub
		return rDao.recipeMaxHitData();
	}
	
	@Override
	public List<RecipeVO> recipeHitTop8() {
		// TODO Auto-generated method stub
		return rDao.recipeHitTop8();
	}
   
   
}
