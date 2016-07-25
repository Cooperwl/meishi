package com.melody.meishi.crawle;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangliang on 2016/7/11.
 */
public class MaterialMap {
    private static ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

    private MaterialMap() {
    }

    private MaterialMap instance;

    private static class Holder {
        public static MaterialMap map = new MaterialMap();
    }

    public static MaterialMap getinstance() {
        return Holder.map;
    }

    public Long put(String key) {
        if (!map.contains(key)) {
            map.put(key, FoodIdGenerator.generateID());
        }
        return map.get(key);
    }
}
