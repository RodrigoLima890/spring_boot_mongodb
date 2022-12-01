package com.spring.mongodb.domain.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLDecoding {
	
	public static String decodingUrl(String text){
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
