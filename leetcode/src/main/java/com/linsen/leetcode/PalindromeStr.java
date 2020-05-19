package com.linsen.leetcode;

/**
 * 回文字符串
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class PalindromeStr {


    public static void main(String[] args){
        String s = "abc";
        System.out.println(validPalindrome(s));
    }


    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                //需要判断去除左边元素之后的字符串是否回文或者删除右边元素之后的字符串是否回文
                //判断左边的元素
                //判断右边的元素
                return validPalindromeRange(s, i, j - 1) || validPalindromeRange(s, i+1, j);
            }
        }
        return true;
    }

    public static boolean validPalindromeRange(String s, int i, int j){
        boolean result = true;
        for(int m = i, n = j; m < n; m++,n--){
            if(s.charAt(m) != s.charAt(n)){
                result = false;
                break;
            }
        }
        return result;
    }

}
