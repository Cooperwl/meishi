/**
 * @Title:  UserContext.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.meishi.common.user;


import com.meishi.common.query.PageInfo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserContext implements Serializable{
	private static final long serialVersionUID = -1003578580038977596L;
	private String userId;
	private String companyId;
	private PageInfo pageInfo;
	private String roleId;
	private String userType;
	private Short userLevel;
	private String districtId;
	private String storeId;
	private Short roleType;
	private Map<String,Object> paramsMap = null;
	
	
	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Short getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Short userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Short getRoleType() {
		return roleType;
	}

	public void setRoleType(Short roleType) {
		this.roleType = roleType;
	}

	public Map<String, Object> getParamsMap() {
		return paramsMap == null?new HashMap<String,Object>():paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}	
}
