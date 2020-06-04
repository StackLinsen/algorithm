package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class SumNums {

    /**
     * 利用短路来替代if的判断控制递归的出口
     * @param n
     * @return
     */
    public int solution(int n){
        boolean flag = n > 0 && (n += solution(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        Integer[] integers = list.toArray(new Integer[0]);
        Integer[] integers1 = new Integer[0];
        System.out.println(integers1.length);
        System.out.println(integers[0] + "" + integers[1]);
    }
}
