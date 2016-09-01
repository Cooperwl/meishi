/**
 * @Title:  ObjectUtils.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.util;

import java.io.Serializable;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对象操作类，取值、设值
 * @author fangyi
 *
 */
public class ObjectUtils {
	private static Logger log = LoggerFactory.getLogger(ObjectUtils.class);

	/**
	 * 对象克隆
	 * @param o
	 * @return
	 */
	public static Object serializaClone(Serializable o) {
		return SerializationUtils.clone(o);
	}

	public static Object setProperty(Object target, Object data,String propertyName) {
		if (target==null || data == null || StringUtils.isNullOrEmpty(propertyName)) {
			return target;
		}
		
		try {
			PropertyUtils.setProperty(target,propertyName, data);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(target.getClass().getName()+"中没有属性"+propertyName+"或没有get方法");
		} catch (Exception e){
			throw new RuntimeException("设置"+target.getClass().getName()+"."+propertyName+"的值出错");
		}
		
		return target;
	}

	public static Object getProperty(Object target, String propertyName){
		if (target == null || StringUtils.isNullOrEmpty(propertyName)) {
			return null;
		}
		
		try {
			return PropertyUtils.getProperty(target, propertyName);
		}catch (NoSuchMethodException e) {
			throw new RuntimeException(target.getClass().getName()+"中没有属性"+propertyName+"或没有get方法");
		} catch (Exception e){
			throw new RuntimeException("设置"+target.getClass().getName()+"."+propertyName+"的值出错");
		}
	}
	

    /**
     * 判断是否为空
     * @author fengxk
     * @param value
     * @return
     */
    public static boolean isNull(Object value) {
        if (value == null )
            return true;
        else
            return false;
    }
}
