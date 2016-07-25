/**
 * @Title:  OrderBy.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.query;

public class OrderBy {
	private String propertyName;
	
	private QueryCriteria.Order order;

	public OrderBy(){
		
	}
	
	public OrderBy(String propertyName, QueryCriteria.Order order) {
		super();
		this.propertyName = propertyName;
		this.order = order;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public QueryCriteria.Order getOrder() {
		return order;
	}

	public void setOrder(QueryCriteria.Order order) {
		this.order = order;
	}

	
	
}
