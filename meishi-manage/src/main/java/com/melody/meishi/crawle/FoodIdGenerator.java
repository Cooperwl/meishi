package com.melody.meishi.crawle;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/10 0010.
 */
public class FoodIdGenerator {

    private FoodIdGenerator(){}

    private FoodIdGenerator instance;
    /* 此处使用一个内部类来维护单例 */
    private static class ObjectHolder{
        public static final FoodIdGenerator holder = new FoodIdGenerator();
    }

    public static FoodIdGenerator getInstance(){
        return ObjectHolder.holder;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }

    public static Long generateID(){
        return new Date().getTime();
    }
}
