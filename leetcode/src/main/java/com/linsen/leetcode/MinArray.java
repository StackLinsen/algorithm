package com.linsen.leetcode;

/**
 * @author lane.lin
 * @Description 旋转数组最小的数字
 * @since 2020/7/22
 */
public class MinArray {

    public static void main(String[] args) {

    }

    public int solution(int[] numbers){
        for(int i = 0; i < numbers.length - 1; i++){
            if(numbers[i] > numbers[i + 1]){
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }


    public int solution_2(int[] numbers){
        int low = 0;
        int high = numbers.length - 1;
        while(low < high){
            int pivot = low + (high - low) / 2;
            if(numbers[pivot] > numbers[high]){
                low = pivot + 1;
            }else if(numbers[pivot] < numbers[high]){
                high = pivot;
            }else{
                high -= 1;
            }
        }
        return numbers[low];
    }

}
