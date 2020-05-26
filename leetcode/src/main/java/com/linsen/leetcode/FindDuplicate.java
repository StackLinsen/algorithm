package com.linsen.leetcode;

import java.util.HashMap;

/**
 * 还可以使用快慢指针
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> supportMap = new HashMap<Integer, Integer>();
        for (int num : nums){
            supportMap.put(num, supportMap.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for(int num : nums){
            if(supportMap.get(num) >= 2){
                result = num;
            }
        }
        return result;
    }
}
