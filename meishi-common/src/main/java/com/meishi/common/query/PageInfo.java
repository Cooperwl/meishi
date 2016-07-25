/**
 * @Title:  PageInfo.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.query;

import java.io.Serializable;


public class PageInfo implements Serializable{
	private static final long serialVersionUID = -6961515725005820725L;

	private long totalRowCount; 

	private int start; 
	
	private int limit;
	
	/**排序字段*/
	private String sortFile;
	/**排序方式*/
	private String sortType;
	/**升序*/
	public static final  String OrderASC = "ASC";
	/**降序*/
	public static final  String OrderDESC = "DESC";
	
	public int getCurrentPageNum() {
		if(limit>0){
			return (start / limit)+1;
		}
		
		return 0;
	}

	
	public long getTotalPageCount() {
		if(limit<1){
			return 0;
		}
		if (totalRowCount %limit > 0){
			return totalRowCount / limit + 1;
		}else{
			return totalRowCount / limit;
		}
	}
	
	
	
	public int getLimit() {
		return this.limit;
	}

	public void setLimit(int limit) {
		if(limit>=0){
			this.limit = limit;
		}
	}


	public long getTotalRowCount() {
		return this.totalRowCount;
	}

	public void setTotalRowCount(long totalRowCount) {
		if(totalRowCount>=0){
			this.totalRowCount = totalRowCount;
		}
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		if(start>=0){
			this.start = start;
		}
	}


	public String getSortFile() {
		return sortFile;
	}


	public void setSortFile(String sortFile) {
		this.sortFile = sortFile;
	}


	public String getSortType() {
		if(sortType == null || sortType.trim().equals("") 
			|| (!OrderASC.equals(sortType) && !OrderDESC.equals(sortType))){
			sortType = OrderASC;
		}
		return sortType;
	}


	public void setSortType(String sortType) {
		
		this.sortType = sortType;
	}

	
}
