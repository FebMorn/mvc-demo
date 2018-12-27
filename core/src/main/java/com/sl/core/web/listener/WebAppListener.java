package com.sl.core.web.listener;

import com.sl.core.util.ObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 * @Desc:WEB工程监听器
 * @author Nick	
 * @date 2017年7月21日
 */
public class WebAppListener extends ContextLoaderListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAppListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
        LOGGER.info("Spring容器初始化...");
		super.contextInitialized(event);
		ServletContext sc = event.getServletContext();
		if (sc != null) {
			ObjectFactory.init(sc);
			//Consts.PATH = sc.getContextPath();
		}
	}

}
