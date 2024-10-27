<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px
}
.row{
   margin: 0px auto;
   width: 600px
}
</style>
</head>
<body>
  <div class="container">
    <h3 class="text-center">Emp(멀티 SQL수행)</h3>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
          <th class="text-center">비고</th>
        </tr>
        <c:forEach var="vo" items="${list }">
            <tr>
	          <td class="text-center">${vo.empno }</td>
	          <td class="text-center">${vo.ename }</td>
	          <td class="text-center">${vo.job }</td>
	          <td class="text-center">${vo.dbday }</td>
	          <td class="text-center">${vo.sal }</td>
	          <td class="text-center"><a href="../emp/delete.do?empno=${vo.empno }" class="btn btn-sm btn-danger">삭제</a></td>
	        </tr>
        </c:forEach>
      </table>
    </div>
    <h3 class="text-center">Emp_5</h3>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
          
        </tr>
        <c:forEach var="vo" items="${list5 }">
            <tr>
	          <td class="text-center">${vo.empno }</td>
	          <td class="text-center">${vo.ename }</td>
	          <td class="text-center">${vo.job }</td>
	          <td class="text-center">${vo.dbday }</td>
	          <td class="text-center">${vo.sal }</td>
	        </tr>
        </c:forEach>
      </table>
    </div>
    <h3 class="text-center">Emp_6</h3>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
          
        </tr>
        <c:forEach var="vo" items="${list6 }">
            <tr>
	          <td class="text-center">${vo.empno }</td>
	          <td class="text-center">${vo.ename }</td>
	          <td class="text-center">${vo.job }</td>
	          <td class="text-center">${vo.dbday }</td>
	          <td class="text-center">${vo.sal }</td>
	        </tr>
        </c:forEach>
      </table>
    </div>
    <h3 class="text-center">Emp_7</h3>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
          
        </tr>
        <c:forEach var="vo" items="${list7 }">
            <tr>
	          <td class="text-center">${vo.empno }</td>
	          <td class="text-center">${vo.ename }</td>
	          <td class="text-center">${vo.job }</td>
	          <td class="text-center">${vo.dbday }</td>
	          <td class="text-center">${vo.sal }</td>
	        </tr>
        </c:forEach>
      </table>
    </div>
    <h3 class="text-center">Emp_8</h3>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
          
        </tr>
        <c:forEach var="vo" items="${list8 }">
            <tr>
	          <td class="text-center">${vo.empno }</td>
	          <td class="text-center">${vo.ename }</td>
	          <td class="text-center">${vo.job }</td>
	          <td class="text-center">${vo.dbday }</td>
	          <td class="text-center">${vo.sal }</td>
	        </tr>
        </c:forEach>
      </table>
    </div>
    <h3 class="text-center">Emp_9</h3>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
          
        </tr>
        <c:forEach var="vo" items="${list9 }">
            <tr>
	          <td class="text-center">${vo.empno }</td>
	          <td class="text-center">${vo.ename }</td>
	          <td class="text-center">${vo.job }</td>
	          <td class="text-center">${vo.dbday }</td>
	          <td class="text-center">${vo.sal }</td>
	        </tr>
        </c:forEach>
      </table>
    </div>
    <h3 class="text-center">Emp_10</h3>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center">사번</th>
          <th class="text-center">이름</th>
          <th class="text-center">직위</th>
          <th class="text-center">입사일</th>
          <th class="text-center">급여</th>
          
        </tr>
        <c:forEach var="vo" items="${list10 }">
            <tr>
	          <td class="text-center">${vo.empno }</td>
	          <td class="text-center">${vo.ename }</td>
	          <td class="text-center">${vo.job }</td>
	          <td class="text-center">${vo.dbday }</td>
	          <td class="text-center">${vo.sal }</td>
	        </tr>
        </c:forEach>
      </table>
    </div>
  </div>
</body>
</html>