/**
 * @Title:  StartupListener.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.melody.meishi.base;

import com.meishi.common.result.StatusPool;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 系统启动时，初始化相关数据
 * @author
 */
public class StartupListener implements ServletContextListener {
	private static Logger log = Logger.getLogger(StartupListener.class);
	
	public void contextDestroyed(ServletContextEvent arg0) {
	}
	
	public void contextInitialized(ServletContextEvent event) {
		if(log.isInfoEnabled()){
			log.info("Initialization Start");
		}
		ServletContext servletContext = event.getServletContext();
		
		// 安装全局context和加载静态数据
		setupContext(servletContext);
		
		if (log.isInfoEnabled()) {
			log.info("Initialization Complete");
		}
	}

	public static void setupContext(ServletContext context) {
		ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		// 加载静态数据.

		initData(applicationContext);
		
	}

	/**
	 * 加载静态数据和基础数据
	 */
	private static void initData(ApplicationContext applicationContext) {
//		StatusPool.getPool().init("status-message.properties");
	}

}
