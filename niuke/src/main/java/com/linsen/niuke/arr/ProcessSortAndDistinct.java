package com.linsen.niuke.arr;

import java.util.Scanner;

public class ProcessSortAndDistinct {


    /**
     * 将数组中的数字去重并且重新排序
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int[] arr = new int[1001];
            int arrayLength = scanner.nextInt();
            for(int i = 0; i< arrayLength; i++){
                int number = scanner.nextInt();
                arr[number] = 1;
            }

            for (int i = 0; i < arr.length; i++){
                if(arr[i] == 1){
                    System.out.println(i);
                }
            }
        }
    }
}
