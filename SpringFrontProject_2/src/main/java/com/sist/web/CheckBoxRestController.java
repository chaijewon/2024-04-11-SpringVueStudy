package com.sist.web;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CheckBoxRestController {
    @GetMapping(value="board/delete_vue.do",produces = "text/plain;charset=UTF-8")
    public String board_delete(@Param("arr[]") int[] arr) throws Exception
    {
    	 for(int i:arr)
    	 {
    		 System.out.println(i);
    	 }
    	 ObjectMapper mapper=new ObjectMapper();
    	 String json=mapper.writeValueAsString(arr);
    	 return json;
    }
}
