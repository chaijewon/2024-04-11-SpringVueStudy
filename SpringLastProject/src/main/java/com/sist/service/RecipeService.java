package com.sist.service;
import java.util.*;
import com.sist.vo.*;
// Recipe와 관련된 기능을 모아서 관리 => 결합성(의존성) 낮은 프로그램 
// 수정시에 다른 클래스에 영향이 없게 만드는 프로그램 
// 개발자 독립적 개발 , 유지보수가 가능하게 
public interface RecipeService {
	public RecipeVO recipeMaxHitData();
	public List<RecipeVO> recipeHitTop8();
	public ChefVO chefToday();
	public List<RecipeVO> recipeListData(Map map);
	public int recipeTotalPage();
	public RecipeDetailVO recipeDetailData(int no);
	 
}
