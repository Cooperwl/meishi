/**
 * @Copyright (C) 2016 本内容属于商业秘密，易微行(北京)科技有限公司保留版权等所有权利.
 */
package com.meishi.common.result;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestResult<T> {
	private boolean success;
	private List<String> errors = new ArrayList<String>();
	private T data;

	public static RequestResult<Object> successResult(){
		RequestResult<Object> success = new RequestResult<Object>();
		success.setSuccess(true);
		return success;
	}

	public static RequestResult<Object> buildErrorRequest(String errMsg){
		RequestResult errorResult = new RequestResult();
		errorResult.setSuccess(false);
		errorResult.setErrors(Arrays.asList(errMsg));
		return errorResult;
	}
	
	public static RequestResult<Object> buildRequestFromResult(Result result){
	    RequestResult<Object> requestResult = successResult();
	    if (!result.isSuccess()) {
	        requestResult.setSuccess(false);
			requestResult.setErrors(result.getErrors());
        }else {
			requestResult.setData(result.getReturnValue());
		}
        return requestResult;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
