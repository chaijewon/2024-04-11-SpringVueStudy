package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface FoodService {
	public List<FoodVO> foodHitTop5();
	public List<FoodVO> foodListData(int start,int end);
	public int foodTotalPage();
	
}
