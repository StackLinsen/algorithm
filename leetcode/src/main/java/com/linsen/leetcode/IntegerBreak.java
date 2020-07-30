package com.linsen.leetcode;

/**
 * @author lane.lin
 * @Description 整数拆分
 * @since 2020/7/30
 */
public class IntegerBreak {

    public static void main(String[] args) {

    }


    public int solution(int n){
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 0;
        for(int i = 2; i < n + 1; i++){
            int curMax = 0;
            for(int j = 1; j < i; j++){
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
