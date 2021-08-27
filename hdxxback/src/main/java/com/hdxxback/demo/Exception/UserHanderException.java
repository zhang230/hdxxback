package com.hdxxback.demo.Exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class UserHanderException {
   @ExceptionHandler(value = Exception.class)
   public Object userHandlerException(java.lang.Exception e){
       Map<String, Object> stringObjectMap = new HashMap<>();
       stringObjectMap.put("code",500);
       stringObjectMap.put("msg","服务器异常!!!!!!!");
       System.out.println(stringObjectMap);
       e.printStackTrace();
       return stringObjectMap;
   }
}
