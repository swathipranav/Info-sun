package com.SecureWatch;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class MapFunctionality {
	
	
	//Map  - HashMap
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashedMap<String,String>();
		
		map.put("Java", "Selenium");
		
		map.put("C#", "dotNet");
		
		
		System.out.println(map.get("C#"));
	}
	
	

}
