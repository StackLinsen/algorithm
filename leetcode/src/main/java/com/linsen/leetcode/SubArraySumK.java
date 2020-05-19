package com.linsen.leetcode;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class SubArraySumK {


    public static void main(String[] args){
        int[] nums = {28,54,7,-70,22,65,-6};
        int k = 100;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = nums[i];
            if(sum == k){
                result += 1;
            }
            for(int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    result += 1;
                }
            }
        }
        return result;
    }


}
