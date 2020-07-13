package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author lane.lin
 * @Description 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集
 * @since 2020/7/13
 */
public class Intersect {

    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect.solution_3(nums1, nums2)));
    }

    /**
     * 不考虑有序
     * 维护一个额外的空间来记录已经配对的下表
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] solution(int[] nums1, int[] nums2){
        //遍历数组容量小的哪一个
        int size1 = nums1.length;
        int size2 = nums2.length;
        List<Integer> indexList = new ArrayList<>();
        int[] result = new int[size1 > size2 ? size2 : size1];
        int m = 0;
        if(size1 > size2){
            for(int i = 0; i < size1; i++){
                for(int j = 0; j < size2; j++){
                    if(indexList.contains(j)){
                        continue;
                    }
                    if(nums1[i] == nums2[j]){
                        indexList.add(j);
                        result[m++] = nums1[i];
                        break;
                    }
                }
            }
        }else{
            for(int i = 0; i < size2; i++){
                for(int j = 0; j < size1; j++){
                    if(indexList.contains(j)){
                        continue;
                    }
                    if(nums2[i] == nums1[j]){
                        indexList.add(j);
                        result[m++] = nums2[i];
                        break;
                    }
                }
            }
        }
        return Arrays.copyOfRange(result, 0, m);
    }


    /**
     * 用hashmap先记录
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] solution_2(int[] nums1, int[] nums2){
        if (nums1.length > nums2.length) {
            return solution_2(nums2, nums1);
        }
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }
        int nums = 0;
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) >= 1){
                result[nums++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOfRange(result, 0, nums);
    }


    /**
     * 先进行排序
     * 再利用双指针进行遍历
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] solution_3(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]){
                //相等 都加1
                nums1[index++] = nums1[index1];
                index1++;
                index2++;
                continue;
            }
            if(nums1[index1] < nums2[index2]){
                index1++;
            }else{
                index2++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }


}
