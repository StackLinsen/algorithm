package com.linsen.leetcode;

import java.util.Random;

/**
 * @author lane.lin
 * @Description TODO
 * @since 2020/6/29
 */
public class FindKthLargest {
    static Random random = new Random();


    public static void main(String[] args) {

    }

    /**
     * 快排
     * @param nums
     * @param k
     * @return
     */
    public static int solution(int[] nums, int k){
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    /**
     * 随机分区位置
     * @param a
     * @param l
     * @param r
     * @return
     */
    public static int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    /**
     * 分区
     * @param a
     * @param l
     * @param r
     * @return
     */
    public static int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    /**
     * 交换元素
     * @param a
     * @param i
     * @param j
     */
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
