/**
 * @Title:  QueryCriteria.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.query;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 查询条件类
 */
@XmlRootElement
@XmlType(name = "QueryCriteria") 
public class QueryCriteria {
	public static final String separator = ".";
	public enum Operator{EQ,LIKE,BETWEEN,IN,GE,LE,ISNULL,NOTNULL,NE};
	public enum Order{NoN, ASC, DESC};

	private List<Criterion> criteria;
	
	private List<OrderBy> orderBy;
	
	public QueryCriteria(){
		criteria = new ArrayList<Criterion>();
		orderBy = new ArrayList<OrderBy>();
	}
	
	/**
	 * 通过属性名称 等于 属性值做查询 
	 * @param propertyName
	 * @param propertyValue
	 */
	public void addCriteria(String propertyName, Object propertyValue){
		addCriteria(propertyName, propertyValue, Operator.EQ);
	}
	
	/**
	 * 按照属性名称 属性值做查询 按指定的方式做查询
	 * @param propertyName
	 * @param propertyValue
	 * @param operator
	 */
	public void addCriteria(String propertyName, Object propertyValue, Operator operator){
		addCriteria(new Criterion(propertyName, propertyValue, operator));
	}
	
	
	/**
	 * operator 只接受isnull 和 notNull方式
	 * @param propertyName
	 * @param operator
	 */
	public void addCriteria(String propertyName, Operator operator){
		if(!operator.equals(Operator.ISNULL) && !operator.equals(Operator.NOTNULL)){
			throw  new IllegalArgumentException("只接受 isnull和notnull比较方式");
		}
		addCriteria(new Criterion(propertyName, null, operator));
	}
	
	
	public void addCriteria(Criterion criterion){
		criteria.add(criterion);
	}


	public void addOrderBy(String propertyName, Order order){
		orderBy.add(new OrderBy(propertyName, order));
	}
	
	public void addOrderBy(OrderBy order){
		orderBy.add(order);
	}
	
	
	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}

	public List<Criterion> getCriteria(){
		return criteria;
	}
	
	public void setOrderBy(List<OrderBy> orderBy) {
		this.orderBy = orderBy;
	}

	public List<OrderBy> getOrderBy(){
		return orderBy;
	}
}
