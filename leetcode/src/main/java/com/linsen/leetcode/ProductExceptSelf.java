package com.linsen.leetcode;

public class ProductExceptSelf {

    public int[] solution(int[] nums){
        int[] result = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            int mult = 1;
            for(int j = 0; j < nums.length; j++){
                if(j != i){
                    mult *= nums[j];
                }
            }
            result[i] = mult;
        }
        return result;
    }


    public int[] solution_2(int[] nums){
        int[] result = new int[nums.length];
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        L[0] = 1;
        R[nums.length - 1] = 1;
        for(int i = 1; i < nums.length; i++){
            L[i] = L[i - 1] * nums[i -1];
        }

        for (int i = nums.length - 2; i >= 0; i--){
            R[i] = R[i + 1] * nums[i + 1];
        }
        for(int i = 0; i < nums.length; i++){
            result[i] = L[i] * R[i];
        }
        return result;
    }

    public int[] solution_3(int[] nums){
        int answer[] = new int[nums.length];
        answer[0] = 1;
        for(int i = 1; i < nums.length; i++){
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        //第二轮
        int R = 1;
        for(int i = nums.length - 1; i >=0; i--){
            answer[i] = answer[i] * R;
            R = R * nums[i];
        }
        return answer;
    }
}
