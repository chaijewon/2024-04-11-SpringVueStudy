package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface ReserveService {
	public List<FoodVO> reserveFoodInfoData(Map map);
	public int reserveFoodTotalPage(Map map);
}
