package com.linsen.leetcode;

public class Main {
    public static void main(String[] args) {
//        int capacity = 2;
//        LRUCache obj = new LRUCache(capacity);
//        obj.put(2,1);
//        obj.put(1,1);
//        obj.put(2,3);
//        obj.put(4,1);
//        System.out.println(obj.get(1));
//        System.out.println(obj.get(2));
        FindDuplicate findDuplicate = new FindDuplicate();
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate.findDuplicate(nums));
    }
}
