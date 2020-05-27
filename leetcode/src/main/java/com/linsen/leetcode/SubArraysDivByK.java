package com.linsen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 * 解题思路：
 * 1.用双指针  会超时
 * 2.同余定理
 */
public class SubArraysDivByK {


    public int subarraysDivByK(int[] A, int K) {
        int nums = 0;
        for(int i = 0; i < A.length; i++){
            int sum = A[i];
            if (sum % K == 0){
                nums++;
            }
            for(int j = i + 1; j < A.length; j++){
                sum += A[j];
                if(sum % K == 0){
                    nums++;
                }
            }
        }
        return nums;
    }

    public int subArraysDivByK_2(int[] A, int K){
        Map<Integer,Integer> record = new HashMap<>();
        record.put(0,1);
        int sum = 0;
        for(int elem:A){
            sum += elem;
            int modules = (sum % K + K) % K;
            record.put(modules, record.getOrDefault(modules, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return ans;
    }
}
