package com.linsen.leetcode;

/**
 * @author lane.lin
 * @Description 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 2020/7/6
 */
public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        int index = 0;
        for(int num : nums){
            if(num != nums[index]){
                nums[++index] = num;
            }
        }
        return index + 1;
    }

}
