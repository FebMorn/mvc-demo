package com.sl.core.util;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

public class ObjectFactory {
	
	private static WebApplicationContext webApplicationContext = null;
	
	public static void init(ServletContext sc) {
		if (webApplicationContext == null) {
			webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
		}
	}
	
	public static Object getBean(String name) {
		if (webApplicationContext != null) {
			return webApplicationContext.getBean(name);
		} else {
			return null;
		}
	}

}
