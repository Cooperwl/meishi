/**
 * @Title: ReadProperties.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 * YWX CONFIDENTIAL AND TRADE SECRET
 * @author:
 * @data:
 */
package com.meishi.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * 读取资源文件工具类
 */
public class ReadProperties {

    /**
     * 读取指定的properties文件
     * @param propertiesName 文件名
     * @return
     */
    public static Map read(String propertiesName) {
        InputStream inputStream = null;
        inputStream = ReadProperties.class.getClassLoader().getResourceAsStream(propertiesName);
        Properties prop = new Properties();
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "UTF8"));
            prop.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (Map) prop;
    }

    /**
     * 获取指定的properties文件中的某个属性的value
     * @param property 属性名
     * @param propertyFileName 资源文件名称
     * @return
     */
    public static String getProperty(String property, String propertyFileName) {
        Map map = read(propertyFileName);
        Collection keys = map.keySet();
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (key.equalsIgnoreCase(property)) {
                return (String) map.get(key);
            }
        }
        return null;
    }
}
