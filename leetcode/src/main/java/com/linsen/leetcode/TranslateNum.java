package com.linsen.leetcode;


/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum {

    /**
     * 利用递归的思想，把数字转换之后的字符串一直进行拆解
     * @param num
     * @return
     */
    public int solution(int num){
        if(num <= 9){
            return 1;
        }else if(num <= 25){
            return 2;
        }else if(num < 99){
            return 1;
        }else{
            int sum1 = 0;
            if(Integer.valueOf(String.valueOf(num).substring(0,1)) != 0){
                int num1 = Integer.valueOf(String.valueOf(num).substring(1));
                sum1 += solution(num1);
            }
            if(Integer.valueOf(String.valueOf(num).substring(0,2)) <= 25 && Integer.valueOf(String.valueOf(num).substring(0,2)) > 9){
                int num2 = Integer.valueOf(String.valueOf(num).substring(2));
                sum1 += solution(num2);
            }
            return sum1;
        }
    }


    /**
     * 简化版本
     * @param num
     * @return
     */
    public int solution_2(int num){
        if (num == 0) {
            return 1;
        }
        if (num < 10) {
            return 1;
        }
        if (num % 100 < 26 && num % 100 > 9) {
            return solution_2(num / 10) + solution_2(num / 100);
        } else {
            return solution_2(num / 10);
        }

    }


}
