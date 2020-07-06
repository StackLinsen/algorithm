package com.linsen.leetcode;

import java.util.Arrays;

/**
 * @author lane.lin
 * @Description :
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 2020/6/24
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(solution_2(nums, target));
    }


    /**
     * 暴力破解
     * @param nums
     * @param target
     * @return
     */
    public static int solution(int[] nums, int target){
        int closetSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for (int k = j + 1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == target){
                        return sum;
                    }
                    if(Math.abs(target - sum) < Math.abs(target - closetSum)){
                        closetSum = sum;
                    }
                }
            }
        }
        return closetSum;
    }

    /**
     * [双指针]优化
     * @param nums
     * @param target
     * @return
     */
    public static int solution_2(int[] nums, int target){
        Arrays.sort(nums);
        int closetSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(closetSum - target)) {
                    closetSum = sum;
                }

                if(sum < target){
                    j++;
                }
                if(sum > target){
                    k--;
                }
            }
        }
        return closetSum;
    }
}
