package com.sist.service;
import java.util.*;
import com.sist.vo.*;
public interface GoodsService {
	public List<GoodsVO> goodsListData(Map map);
	public int goodsTotalPage();
	public void hitIncrement(int no);
	public GoodsVO goodsDetailData(int no);
	public MemberVO memberInfodData(String userId);
	public void goodsCartInsert(CartVO vo);
	public void goodsCartAccountUpdate(CartVO vo);
	public int goodsCartGnoCount(int gno);
	public List<CartVO> goodsCartListData(String id);
	public void goodsCartCancel(int cno);
	public void goodsBuy(int cno);
	public List<CartVO> goodsBuyListData(String id);
	 
}
