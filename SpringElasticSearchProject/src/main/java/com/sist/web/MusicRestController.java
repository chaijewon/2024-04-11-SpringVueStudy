package com.sist.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.io.*;
import java.net.*;
// http://localhost:9200/music/_search?q=singer=%EC%95%84%EC%9D%B4%EB%B8%8C
@RestController
public class MusicRestController {
    @GetMapping(value="music/find_vue.do",produces = "text/plain;charset=UTF-8")
    public String music_find(String singer) throws Exception
    {
    	String strUrl="http://localhost:9200/music/_search?q=singer="
    			     +URLEncoder.encode(singer,"UTF-8");
    	URL url=new URL(strUrl);
    	// url연결 
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    	StringBuffer sb=new StringBuffer();// 데이터를 모아둔다 
    	if(conn!=null) // 사이트에 연결이 된 경우
    	{
    	   BufferedReader in=
    			  new BufferedReader(
    					  new InputStreamReader(conn.getInputStream(),"UTF-8"));
    	   while(true)
    	   {
    		   String data=in.readLine();
    		   if(data==null) break;
    		   sb.append(data);
    	   }
    	   in.close();
    	}
    	return sb.toString();
    }
}
