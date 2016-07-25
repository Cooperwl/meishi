/**
 * @Title: AppPage.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 * YWX CONFIDENTIAL AND TRADE SECRET
 * @author:
 * @data:
 */
package com.meishi.common.query;

import java.util.ArrayList;
import java.util.List;


/**
 * 内存分页组件
 * @param <T>
 */
public class AppPage<T> {


    /**
     * @author: luokui
     * @time:2015年1月14日 下午8:52:28
     * @param limit           页数
     * @param pageTotle       总记录数目
     * @param pageNum        当前页数
     * @param list            需要查询的List
     * @return List<T>               返回相应页数的记录
     */
    public List<T> getAppPageList(Integer limit, Integer pageTotle, Integer pageNum, List<T> list) {
        List<T> returnList = new ArrayList<T>();
        Integer limitInteger = limit;     // 每页显示数量
        Integer pageTotleInteger = pageTotle; // 缓存中的总条数
        Integer pageNumInteger = pageNum;   // 当页数
        if (null == pageNumInteger || pageNumInteger == 0) {
            pageNumInteger = 1;
        }
        if (pageTotleInteger == null || pageTotleInteger == 0) {
            return null;
        }

        int start = 1;
        if (pageNumInteger > 1) {
            start = (pageNumInteger - 1) * limitInteger + 1;     //计算开始条数
        }

        int end = start + limitInteger - 1;                    //计算结束条数
        if (end < pageTotleInteger) {
            for (int i = start - 1; i < end; i++) {
                T carRentDTO = list.get(i);
                if (null != carRentDTO) {
                    returnList.add(carRentDTO);
                }
            }
        } else {
            for (int i = start - 1; i < pageTotleInteger; i++) {
                T carRentDTO = list.get(i);
                if (null != carRentDTO) {
                    returnList.add(carRentDTO);
                }
            }
        }
        return returnList;
    }


}
