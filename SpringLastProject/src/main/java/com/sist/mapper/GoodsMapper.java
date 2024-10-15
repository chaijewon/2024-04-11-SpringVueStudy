package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.CartVO;
import com.sist.vo.GoodsVO;
import com.sist.vo.MemberVO;
public interface GoodsMapper {
   @Select("SELECT no,goods_price,goods_poster,goods_name,goods_delivery,hit,num "
		  +"FROM (SELECT no,goods_price,goods_poster,goods_name,goods_delivery,hit,rownum as num "
		  +"FROM (SELECT no,goods_price,goods_poster,goods_name,goods_delivery,hit "
		  +"FROM goods_all ORDER BY no ASC)) "
		  +"WHERE num BETWEEN #{start} AND #{end}")
   public List<GoodsVO> goodsListData(Map map);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
   public int goodsTotalPage();
   
   @Update("UPDATE goods_all SET "
		  +"hit=hit+1 "
		  +"WHERE no=#{no}")
   public void hitIncrement(int no);
  
   @Select("SELECT * FROM goods_all "
		  +"WHERE no=#{no}")
   public GoodsVO goodsDetailData(int no);
   
   @Select("SELECT userId,userName,sex,post,addr1,addr2,phone,email "
		  +"FROM spring_member "
		  +"WHERE userId=#{userId}")
   public MemberVO memberInfodData(String userId);
   /*
    *   CNO     NOT NULL NUMBER       
		GNO              NUMBER       
		ID               VARCHAR2(20) 
		ACCOUNT          NUMBER       
		ISBUY            NUMBER       
		REGDATE          DATE     
    */
   // 장바구니 저장 
   @Insert("INSERT INTO spring_cart(cno,gno,id,account) VALUES("
		  +"sc2_cno_seq.nextval,#{gno},#{id},#{account})")
   public void goodsCartInsert(CartVO vo);
   
   @Update("UPDATE spring_cart SET "
		  +"account=account+#{account} "
		  +"WHERE gno=#{gno}")
   public void goodsCartAccountUpdate(CartVO vo);
   
   @Select("SELECT COUNT(*) FROM spring_cart "
		  +"WHERE gno=#{gno}")
   public int goodsCartGnoCount(int gno);
   
   // 장바구니 보기 
   @Results({
	   @Result(property = "gvo.goods_name",column = "goods_name"),
	   @Result(property = "gvo.goods_poster",column = "goods_poster"),
	   @Result(property = "gvo.goods_price",column = "goods_price")
   })
   @Select("SELECT cno,gno,account,isBuy,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
		  +"goods_name,goods_poster,goods_price "
		  +"FROM spring_cart sc,goods_all ga "
		  +"WHERE sc.gno=ga.no "
		  +"AND id=#{id} AND isBuy=0 "
		  +"ORDER BY cno DESC")
   public List<CartVO> goodsCartListData(String id);
   
}
