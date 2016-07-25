/**
 * @Copyright (C) 2016 本内容属于商业秘密，易微行(北京)科技有限公司保留版权等所有权利.
 */
package com.meishi.common.result;

public class Status {
	private String code;
	private String msg;
	private Boolean success;
	
	public Status() {
		super();
	}
	public Status(String msg, Boolean success) {
		super();
		this.msg = msg;
		this.success = success;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
	
}
