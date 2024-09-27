package com.sist.vo;
import java.util.*;

import lombok.Data;
@Data

public class DeptVO {
  private int deptno;
  private String dname,loc;
  private List<EmpVO> empList=new ArrayList<EmpVO>();
}
