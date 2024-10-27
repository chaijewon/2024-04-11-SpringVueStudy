package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
public interface EmpMapper {
  // <delete id="allDelete" parameterType="int">
  public void allDelete(int empno);
  //<select id="empListData" resultType="com.sist.vo.EmpVO">
  public List<EmpVO> empListData();
  // <select id="empDeleteList" resultType="com.sist.EmpVO" parameterType="hashmap">
  public List<EmpVO> empDeleteList(Map map);
}
