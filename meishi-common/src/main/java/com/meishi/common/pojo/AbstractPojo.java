package com.meishi.common.pojo;

import com.meishi.common.convert.JavaBeanXMLConvertor;
import com.meishi.common.util.ObjectUtils;

import java.io.Serializable;

/**
 * 基本javabean对象
 * @author fangyi
 */@SuppressWarnings("serial")
public abstract class AbstractPojo implements Serializable {
	public String toXml() {
		return new JavaBeanXMLConvertor().objToXml(this);
	}

	public String toString() {
		return toXml();
	}

	public Object clone() {
		return ObjectUtils.serializaClone(this);
	}
}
