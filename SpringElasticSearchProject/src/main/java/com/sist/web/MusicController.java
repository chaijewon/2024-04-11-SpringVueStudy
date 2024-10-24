package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {
   @GetMapping("music/find.do")
   public String music_find()
   {
	   return "music/find";
   }
}
