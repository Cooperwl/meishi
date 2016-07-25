/**
 * @Copyright (C) 2016 本内容属于商业秘密，易微行(北京)科技有限公司保留版权等所有权利.
 */
package com.meishi.common.result;


public class RequestResult<T> {
	private Status status;
	private T data;

	public static RequestResult<Object> successResult(){
		RequestResult<Object> success = new RequestResult<Object>();
		success.setStatus(StatusUtils.getSuccessStatus());
		return success;
	}
	
	public static RequestResult<Object> buildRequestFromResult(Result result){
	    RequestResult<Object> requestResult = successResult();
	    if (!result.isSuccess()) {
	        requestResult.status.setCode(StatusConstant.PARAM_ERROR);
	        requestResult.status.setMsg(result.getErrors().get(0));
	        requestResult.status.setSuccess(false);
        }
        return requestResult;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
