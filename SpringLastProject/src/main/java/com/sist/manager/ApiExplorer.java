package com.sist.manager;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
/*
 *   https://openapi.its.go.kr:9443/cctvInfo?apiKey=8cc24a9744ae41148fed6bbc7975d37f&type=ex&cctvType=1&minX=126.756&maxX=126.7936&minY=37.48135&maxY=37.5843&getType=json
 */
public class ApiExplorer {
 public static void main(String[] args) throws IOException {
  StringBuilder urlBuilder = new StringBuilder("https://openapi.its.go.kr:9443/eventInfo"); /*URL*/
  urlBuilder.append("?" + URLEncoder.encode("apiKey", "UTF-8") + "=" + URLEncoder.encode("8cc24a9744ae41148fed6bbc7975d37f", "UTF-8")); /*공개키*/
  urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("all", "UTF-8")); /*도로유형*/
  urlBuilder.append("&" + URLEncoder.encode("eventType","UTF-8") + "=" + URLEncoder.encode("acc", "UTF-8")); /*이벤트유형*/
  urlBuilder.append("&" + URLEncoder.encode("minX","UTF-8") + "=" + URLEncoder.encode("126.800000", "UTF-8")); /*최소경도영역*/
  urlBuilder.append("&" + URLEncoder.encode("maxX","UTF-8") + "=" + URLEncoder.encode("127.890000", "UTF-8")); /*최대경도영역*/
  urlBuilder.append("&" + URLEncoder.encode("minY","UTF-8") + "=" + URLEncoder.encode("34.900000", "UTF-8")); /*최소위도영역*/
  urlBuilder.append("&" + URLEncoder.encode("maxY","UTF-8") + "=" + URLEncoder.encode("35.100000", "UTF-8")); /*최대위도영역*/
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
  System.out.println(sb.toString());
 }
}
