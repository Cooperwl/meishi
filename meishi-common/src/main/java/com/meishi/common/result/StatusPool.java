/**
 * @Copyright (C) 2016 本内容属于商业秘密，易微行(北京)科技有限公司保留版权等所有权利.
 */
package com.meishi.common.result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StatusPool {
	private static Logger log = LoggerFactory.getLogger(Status.class);
	private static  StatusPool instance = new StatusPool();
	static Map<String,Status> statusMap = new HashMap<String,Status>();

	private StatusPool(){

	}
	@SuppressWarnings("rawtypes")
	public void init(String filePath) {

		try {
			Properties properties = new Properties();
			InputStream inputStream = (new StatusPool()).getClass().getResourceAsStream(filePath);
			BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "utf8"));
			properties.load(bf);
			for(Enumeration e = properties.propertyNames(); e.hasMoreElements();){
			    String key=(String) e.nextElement();
			    String value = properties.getProperty(key);
			    Status status = new Status();
			    status.setCode(key);
			    String[] split = value.split(",");
				if ("true".equals(split[0].toString())) {
			    	status.setSuccess(true);
			    } else {
			    	status.setSuccess(false);
			    }
			    status.setMsg(split.length>1?split[1].toString():"");
			    statusMap.put(key, status);
			}
		} catch (IOException e) {
			log.error("status-message.properties加载错误：",e);
			throw new RuntimeException();
		}

	}

	public static StatusPool getPool(){
		return instance;
	}

	public Status getStatus(String code){
		if(statusMap.get(code) != null){
			try {
				return (Status) BeanUtils.cloneBean(statusMap.get(code));
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

		return null;
	}
}
