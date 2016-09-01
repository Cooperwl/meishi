/**
 * @Title:  XMLObjConvertor.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.convert;

/**
 * 
 * @author fangyi
 *
 */
public interface XMLObjConvertor{
	
	 public abstract String objToXml(Object paramObject);

	 public abstract Object xmlToObj(String paramString);
}
