/**
 * @Title:  Criterion.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.query;

public class Criterion {
	private String propertyName;
	
	private Object propertyValue;
	
	private QueryCriteria.Operator operator;

	
	public Criterion(){
		
	}
	
	
	public Criterion(String propertyName, Object propertyValue, QueryCriteria.Operator operator) {
		super();
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.operator = operator;
	}



	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Object getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(Object propertyValue) {
		this.propertyValue = propertyValue;
	}

	public QueryCriteria.Operator getOperator() {
		return operator;
	}

	public void setOperator(QueryCriteria.Operator operator) {
		this.operator = operator;
	}
	
	
}
