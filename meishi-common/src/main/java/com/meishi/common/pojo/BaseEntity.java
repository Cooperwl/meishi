/**
 * @Title:  BaseEntity.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本domain对象
 */
public abstract class BaseEntity extends AbstractPojo{
	private static final long serialVersionUID = 8299863755141680910L;

	/**
	 * Default equality implementation 
	 * from the model point of view, if two objects have the 
	 * same id (ids are equal ) then the objects are the same 
	 * object. This equal method checks for equal ids.
	 * 
	 * Note: if you put un-initalized entities ( null id )in a collection,
	 * you will get indeterminate behavior
	 * @return
	 */
	@Override
	public boolean equals(Object ob) {
		String id = getId();
		if (id == null) {
			return super.equals(ob);
		}
		boolean rc = false;
		if (ob instanceof BaseEntity) {
			String obId = ((BaseEntity) ob).getId();
			if (obId != null && id != null) {
				rc = id.equals(obId);
			}
		}
		return rc;
	}

	/**
	 * Overridden hashcode method. if the object has an id, use the id as the
	 * hash else use default hash of the parent .
	 */
	@Override
	public int hashCode() {
		String id = getId();
		int hash = super.hashCode();
		if (id != null) {
			hash = id.hashCode();
		}
		return hash;
	}
	
	public abstract String getId();
	
	public abstract void setId(String id);
	
	public String getPrefix(){
		return "";
	}
	
	/**
	 * 把源对象转换成目标对象，并实现同名属性数据复制
	 * @param source		原对象
	 * @param targetClass	目的类
	 * @return
	 * @throws Exception 
	 */@Deprecated
	public static <A,B> B convert(A source, Class<B> targetClass) throws Exception{
		try {
			B target = targetClass.newInstance();
			org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
			return target;
		} catch (Exception e) {
			throw new Exception("cannot convert to " + targetClass.getName());
		} 
	}
	
	/**
	 * 把源对象转换成目标对象，并实现同名属性数据复制
	 * @param sourceList	原对象列表
	 * @param targetClass	目的类
	 * @return
	 * @throws Exception 
	 */@Deprecated
	public static <A,B> List<B> convert(List<A> sourceList, Class<B> targetClass) throws Exception{
		if(sourceList == null)
			return null;

		List<B> targetList = new ArrayList<B>();
		for(A source:sourceList){
			try{
				B target = targetClass.newInstance();
				org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
				targetList.add(target);
			} catch (Exception e) {
				throw new Exception("cannot convert to " + targetClass.getName());
			} 
		}
		return targetList;
	}
}
