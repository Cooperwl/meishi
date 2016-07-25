package com.melody.meishi.authority.vo;

import com.meishi.metadata.ws.meta.dto.UserDTO;

import java.io.Serializable;

/**
 * 登录用户vo对象
 */
public class LoginUserVo implements Serializable{

	private static final long serialVersionUID = 1712657881565366725L;
	private String id;
	private String userAccount;
	private String userFullname;
	private String roleId;
	private Short roleType;
	private Short userLevel;

	public LoginUserVo(UserDTO userDTO){
		this.id = userDTO.getId();
		this.userAccount = userDTO.getUserAccount();
		this.userFullname = userDTO.getUserFullname();
		this.roleId = userDTO.getRoleID();
		this.roleType = userDTO.getRoleType();
		this.userLevel = userDTO.getUserLevel();
	}

	public Short getRoleType() {
		return roleType;
	}
	public void setRoleType(Short roleType) {
		this.roleType = roleType;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserFullname() {
		return userFullname;
	}
	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public Short getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Short userLevel) {
		this.userLevel = userLevel;
	}
}
