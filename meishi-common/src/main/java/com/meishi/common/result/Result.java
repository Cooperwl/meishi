package com.meishi.common.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 调用service层方法返回的对象
 * @date: 2016年7月7日 上午11:26:51
 */
@XmlRootElement
public class Result extends BaseResult implements Serializable {
	private static final long serialVersionUID = -212271622516078317L;
	private List<String> errors;
	private Object returnValue;
	
    public static Result successResult() {
        Result successInstance = new Result();
        successInstance.setSuccess(true);
        successInstance.setErrors(new ArrayList<String>());

        return successInstance;
    }

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Object getReturnValue() {
		return  returnValue;
	}
	
	public void setReturnValue(Object returnValue) {
		this.returnValue = returnValue;
	}
	
}
