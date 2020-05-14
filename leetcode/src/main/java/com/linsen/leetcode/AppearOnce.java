package com.linsen.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组中只出现一次的数字，只有一个数出现一次，其余的数字都是成对出现的
 */
public class AppearOnce {

    public static void main(String[] args){
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber_BitOperate(nums));
    }

    /**
     * O(N*N)
     * @param nums
     * @return
     */
    public static int singleNumber_1(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            int j = 0;
            while(j < nums.length){
                if(i == j){
                    j++;
                    continue;
                }
                if(nums[i] == nums[j]){
                    break;
                }
                j++;
            }
            if(j == nums.length){
                index = i;
                break;
            }
        }
        return nums[index];
    }

    /**
     * 用辅助集合实现：
     * 如果集合中存在对应的数字，则删除集合中的记录
     * 如果集合中不存在对应的数字，则加入集合
     * @param nums
     * @return
     */
    public static int singleNumber_Collections(int[] nums){
        List<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                list.remove(list.indexOf(nums[i]));
            }else{
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }

    /**
     * 用位运算中的异或运算
     * 任何数和0做异或运算，结果仍然是原来的数：a ^ 0 = a
     * 任何数和其自身做异或运算，结果是0，即 a ^ a = 0
     * 异或运算满足交换律和结合律，既 a ^ b ^ a = b ^ a ^ a = b ^ (a ^ a) = b ^ 0 = b
     * @param nums
     * @return
     */
    public static int singleNumber_BitOperate(int[] nums){
        int single = 0;
        for(int num : nums){
            single ^= num;
        }
        return single;
    }
}
