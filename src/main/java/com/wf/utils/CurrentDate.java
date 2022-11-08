package com.wf.utils;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;    
public class CurrentDate {    
  
  public static String getCurrentDate() {
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now();  
	   return dtf.format(now);
  }
  
}