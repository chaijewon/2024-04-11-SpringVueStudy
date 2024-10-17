package com.sist.task;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sist.dao.NaverDAO;

import java.util.*;
// Task => 스케쥴러 (원하는 시간마다 수행이 가능)
// 실시간 데이터를 읽어서 데이터베이스 저장  
@Component
public class NaverDataLabTask {
   @Autowired
   private NaverDAO nDao;
   
   //@Scheduled(fixedRate = 5000)
   public void dataLab() {
	   try
	   {
		   nDao.naverDelete();
		   Set<String> set=new HashSet();   
		   Document doc=Jsoup.connect("https://datalab.naver.com").get();
		   Elements datas=doc.select("ul.rank_list span.title");
		   for(int i=0;i<datas.size();i++)
		   {
			   set.add(datas.get(i).text());
		   }
		   
		   List<String> list=new ArrayList<String>(set);
		   Collections.shuffle(list);
		   for(int i=0;i<list.size();i++)
		   {
			   //System.out.println((i+1)+"."+list.get(i));
			   nDao.naverInsert(list.get(i));
		   }
		   System.out.println("==============");
	   }catch(Exception ex) {}
   }
}
