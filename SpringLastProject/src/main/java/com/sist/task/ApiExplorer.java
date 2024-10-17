package com.sist.task;
import java.io.InputStreamReader;
import java.util.*;
import com.sist.vo.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
public class ApiExplorer {
 private static double[] lngs= {0.0,127.07,126.87,127.69,127.01,127.43,128.68,128.58,129.06,126.89};
 private static double[] lats= {0.0,37.51,37.50,37.44,37.30,36.32,35.84,35.22,35,19,35,17};
 public static List<CctvVO> cctvData(int no) throws IOException {
     double lng=lngs[no];
     double lat=lats[no];
     double minX = lng - 1;
     double maxX = lng + 1;
     double minY = lat - 1;
     double maxY = lat + 1;

  StringBuilder urlBuilder = new StringBuilder("https://openapi.its.go.kr:9443/eventInfo"); /*URL*/
  urlBuilder.append("?" + URLEncoder.encode("apiKey", "UTF-8") + "=" + URLEncoder.encode("8cc24a9744ae41148fed6bbc7975d37f", "UTF-8")); /*공개키*/
  urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("all", "UTF-8")); /*도로유형*/
  urlBuilder.append("&" + URLEncoder.encode("eventType","UTF-8") + "=" + URLEncoder.encode("all", "UTF-8")); /*이벤트유형*/
  urlBuilder.append("&" + URLEncoder.encode("minX","UTF-8") + "=" + URLEncoder.encode(String.valueOf(minX), "UTF-8")); /*최소경도영역*/
  urlBuilder.append("&" + URLEncoder.encode("maxX","UTF-8") + "=" + URLEncoder.encode(String.valueOf(maxX), "UTF-8")); /*최대경도영역*/
  urlBuilder.append("&" + URLEncoder.encode("minY","UTF-8") + "=" + URLEncoder.encode(String.valueOf(minY), "UTF-8")); /*최소위도영역*/
  urlBuilder.append("&" + URLEncoder.encode("maxY","UTF-8") + "=" + URLEncoder.encode(String.valueOf(maxY), "UTF-8")); /*최대위도영역*/
  urlBuilder.append("&" + URLEncoder.encode("getType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*출력타입*/
  URL url = new URL(urlBuilder.toString());
  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
  conn.setRequestMethod("GET");
  conn.setRequestProperty("Content-type", "text/xml;charset=UTF-8");
  System.out.println("Response code: " + conn.getResponseCode());
  BufferedReader rd;
  if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
   rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
  } else {
   rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
  }
  StringBuilder sb = new StringBuilder();
  String line;
  while ((line = rd.readLine()) != null) {
   sb.append(line);
  }
  rd.close();
  conn.disconnect();
  //System.out.println(sb.toString());
  Document doc=Jsoup.parse(sb.toString());
  Elements et=doc.select("eventType");
  Elements st=doc.select("startDate");
  Elements rn=doc.select("roadName");
  Elements lb=doc.select("lanesBlocked");
  Elements ms=doc.select("message");
  List<CctvVO> list=new ArrayList<CctvVO>();
  for(int i=0;i<et.size();i++)
  {
	  System.out.println(et.get(i).text()+" "
			  +st.get(i).text()+" "
			  +rn.get(i).text()+" "
			  +lb.get(i).text()+" "
			  +ms.get(i).text());
	  CctvVO vo=new CctvVO();
	  vo.setEventType(et.get(i).text());
	  vo.setStartDate(st.get(i).text());
	  vo.setLanesBlocked(lb.get(i).text());
	  vo.setRoadName(rn.get(i).text());
	  vo.setMessage(ms.get(i).text());
	  list.add(vo);
  }
  return list;
 }
}
