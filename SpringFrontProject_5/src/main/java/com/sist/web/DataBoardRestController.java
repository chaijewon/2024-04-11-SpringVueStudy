package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.DataBoardDAO;
import com.sist.vo.DataBoardVO;

import java.net.*;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Vue와 연결
@RestController
public class DataBoardRestController {
  @Autowired
  private DataBoardDAO dao;
  
  @GetMapping(value="databoard/list_vue.do",produces = "text/plain;charset=UTF-8")
  public String databoard_list(int page) throws Exception
  {
	  int rowSize=10;
	  int start=(rowSize*page)-(rowSize-1);
	  int end=rowSize*page;
	  
	  List<DataBoardVO> list=dao.databoardListData(start, end);
	  int count=dao.databoardCount();
	  int totalpage=(int)(Math.ceil(count/10.0));
	  count=count-((rowSize*page)-rowSize);
	  
	  // Vue로 데이터 전송 
	  Map map=new HashMap();
	  map.put("list", list);
	  map.put("count", count);
	  map.put("totalpage", totalpage);
	  map.put("curpage",page);
	  
	  // 자바스크립트 연결 => Map을 JSON => Kotlin , Flutter
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(map);
	  
	  return json;
  }
  /*
   *   C:\\springDev\\springStudy2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\SpringFrontProject_5\\upload
   */
  @PostMapping(value="databoard/insert_vue.do",produces = "text/plain;charset=UTF-8")
  public String databoard_insert(DataBoardVO vo,HttpServletRequest request)
  {
	  /*System.out.println(vo.getName());
	  System.out.println(vo.getSubject());
	  System.out.println(vo.getContent());
	  System.out.println(vo.getPwd());
	  System.out.println(vo.getFiles().size());
	  if(vo.getFiles().size()>0)
	  {
		  for(int i=0;i<vo.getFiles().size();i++)
		  {
			  System.out.println(vo.getFiles().get(i).getOriginalFilename());
		  }
	  }*/
	  String result="";
	  try
	  {
		 String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
		 File dir=new File(path);
		 if(!dir.exists())
		 {
			 dir.mkdir();
		 }
		 path=path.replace("\\", File.separator); // 맥,리눅스: / , 윈도우: \\
		 //System.out.println(path);
		 List<MultipartFile> list=vo.getFiles();
		 if(list==null) // 업로드가 없는 경우
		 {
			 vo.setFilename("");
			 vo.setFilesize("");
			 vo.setFilecount(0);
		 }
		 else // 업로드가 있는 상태 
		 {
			 String filename="";
			 String filesize="";
			 for(MultipartFile mf:list)
			 {
				 String name=mf.getOriginalFilename();
				 File file=new File(path+name);
				 mf.transferTo(file); // 업로드 
				 filename+=name+",";
				 filesize+=file.length()+",";
			 }
			 
			 filename=filename.substring(0,filename.lastIndexOf(","));
			 filesize=filesize.substring(0,filesize.lastIndexOf(","));
			 vo.setFilecount(list.size());
			 vo.setFilename(filename);
			 vo.setFilesize(filesize);
		 }
		 dao.databoardInsert(vo);
		 result="yes";  
	  }catch(Exception ex)
	  {
		  result=ex.getMessage();
	  }
	  return result;
  }
  
  @GetMapping(value="databoard/detail_vue.do",produces = "text/plain;charset=UTF-8")
  public String databoard_detail(int no) throws Exception
  {
	  DataBoardVO vo=dao.databoardDetailData(no);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(vo);
	  return json;
  }
  @GetMapping(value="databoard/download.do",produces = "text/plain;charset=UTF-8")
  public void databoard_download(String fn,HttpServletResponse response,
		  HttpServletRequest request)
  {
	  try
	  {
		  String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
		  path=path.replace("\\", File.separator);
		  File file=new File(path+fn);
		  
		  response.setHeader("Content-Disposition", "attachment;filename="
				       +URLEncoder.encode(fn, "UTF-8"));
		  response.setContentLength((int)file.length());
		  // 서버에서 값을 읽는다 
		  BufferedInputStream bis=
				  new BufferedInputStream(new FileInputStream(file));
		  // 사용자에게 데이터 전송 
		  BufferedOutputStream bos=
				  new BufferedOutputStream(response.getOutputStream());
		  
		  int i=0; // 읽은 바이트 수 
		  byte[] buffer=new byte[1024];
		  while((i=bis.read(buffer, 0, 1024))!=-1)
		  {
			  bos.write(buffer, 0, i);
		  }
		  bis.close();
		  bos.close();
	  }catch(Exception ex) {}
  }
  @GetMapping(value="databoard/delete_vue.do",produces = "text/plain;charset=UTF-8")
  public String databoard_delete(int no,String pwd,HttpServletRequest request)
  {
	  DataBoardVO vo=dao.databoardFileInfoData(no);
	  String result=dao.databoardDelete(no, pwd);
	  // 파일삭제 
	  if(result.equals("yes"))
	  {
		  String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
		  path=path.replace("\\", File.separator);
		  if(vo.getFilecount()>0)// 파일이 존재시 
		  {
			  StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
			  while(st.hasMoreTokens())// 파일명 만큼 
			  {
				  File file=new File(path+st.nextToken());
				  file.delete();// 파일 삭제 
			  }
		  }
	  }
	  return result;
  }
  @GetMapping(value="databoard/update_vue.do",produces = "text/plain;charset=UTF-8")
  public String databoard_update(int no) throws Exception
  {
	  DataBoardVO vo=dao.databoardUpdateData(no);
	  ObjectMapper mapper=new ObjectMapper();
	  String json=mapper.writeValueAsString(vo);
	  return json;
  }
  @PostMapping(value="databoard/update_ok_vue.do",produces = "text/plain;charset=UTF-8")
  public String databoard_update_ok(DataBoardVO vo,HttpServletRequest request)
  {
	  String result="";
	  try
	  {
		  System.out.println("비밀번호:"+vo.getPwd());
		  System.out.println("이름:"+vo.getName());
		  // 수정전에 파일 정보 읽기 
		  DataBoardVO fvo=dao.databoardFileInfoData(vo.getNo());
		  String path=request.getSession().getServletContext().getRealPath("/")+"upload\\";
		  path=path.replace("\\", File.separator);
		  if(fvo.getFilecount()>0)
		  {
			  StringTokenizer st=new StringTokenizer(fvo.getFilename(),",");
			  while(st.hasMoreTokens())
			  {
				  File file=new File(path+st.nextToken());
				  file.delete();
			  }
		  }
		  List<MultipartFile> list=vo.getFiles();
		  if(list==null)
		  {
			  vo.setFilename("");
			  vo.setFilesize("");
			  vo.setFilecount(0);
		  }
		  else
		  {
			  String filenames="";
			  String filesizes="";
			  
			  for(MultipartFile mf:list)
			  {
				  String name=mf.getOriginalFilename();
				  File file=new File(path+name);
				  mf.transferTo(file);// 파일 업로드 
				  
				  filenames+=name+",";
				  filesizes+=file.length()+",";
			  }
			  
			  filenames=filenames.substring(0,filenames.lastIndexOf(","));
			  filesizes=filesizes.substring(0,filesizes.lastIndexOf(","));
			  vo.setFilename(filenames);
			  vo.setFilesize(filesizes);
			  vo.setFilecount(list.size());
		  }
		  result=dao.databoardUpdate(vo);
	  }catch(Exception ex) {}
	  return result;
  }
}
