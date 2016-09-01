/**
 * @Title:  JavaBeanXMLConvertor.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * pojo到xml, xml到pojo之间的转换
 * @author fangyi
 */
public class JavaBeanXMLConvertor implements XMLObjConvertor{
	private static Logger log = LoggerFactory.getLogger(JavaBeanXMLConvertor.class);

	public String objToXml(Object source) {
		if (source == null){
			return "";
		}

		OutputStream out = new ByteArrayOutputStream();
		XMLEncoder de = new XMLEncoder(out);
		de.writeObject(source);
		de.close();
		String result = out.toString();
		try {
			out.close();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return result;
	}

	
	
	public Object xmlToObj(String source) {
		if ((source == null) || ("".equals(source)))
			return null;

		InputStream in = new ByteArrayInputStream(source.getBytes());
		XMLDecoder de = new XMLDecoder(in);
		Object result = de.readObject();
		de.close();
		try {
			in.close();
		} catch (IOException e) {
		}
		return result;
	}
	
}
