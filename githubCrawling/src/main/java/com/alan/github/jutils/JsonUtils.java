package com.alan.github.jutils;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {
	private static ObjectMapper objectMapper = new ObjectMapper();
	public static String toJson(Object object) {
		String s ="";
		try {
			s=objectMapper.writeValueAsString(object);
		}catch (Exception e) {
			
			e.printStackTrace();// TODO: handle exception
		}
		return s;
	}
}
