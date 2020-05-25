package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Integer> cache;
    private ArrayList<Integer> keyList;
    private Integer size;

    public LRUCache(int capacity){
        this.size = capacity;
        this.cache = new HashMap<Integer, Integer>(capacity);
        this.keyList = new ArrayList<Integer>(capacity);
    }

    public int get(int key) {
        if(this.cache.containsKey(key)){
            this.keyList.remove(Integer.valueOf(key));
            this.keyList.add(key);
            return cache.get(key);
        }else{
            return -1;
        }

    }

    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            this.keyList.remove(Integer.valueOf(key));
            this.keyList.add(key);
            this.cache.put(key, value);
        }else{
            if(this.cache.size() < this.size){
                this.cache.put(key, value);
                this.keyList.add(key);
            }else{
                //先删除，再插入
                Integer LRUKey = this.keyList.get(0);
                this.cache.remove(LRUKey);
                this.keyList.remove(0);
                this.cache.put(key, value);
                this.keyList.add(key);
            }
        }
    }
}
