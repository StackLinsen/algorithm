package com.linsen.leetcode;


import static java.lang.Math.max;

public class Rob {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int Solution(int[] nums){
        if(null == nums || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length - 1];
        dp[0] = nums[0];
        dp[1] = max(nums[0], nums[1]);
        for(int i = 2; i<nums.length; i++){
            dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }


    /**
     * 滚动数组
     * @param nums
     * @return
     */
    public int Solution_2(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
