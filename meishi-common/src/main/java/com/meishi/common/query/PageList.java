/**
 * @Title:  PageList.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageList<T> implements Serializable{
	private static final long serialVersionUID = 4114664349273266074L;

	private PageInfo pageInfo = new PageInfo();

	private List<T> list = new ArrayList<T>();

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public PageInfo getPageInfo() {
		return this.pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}
}