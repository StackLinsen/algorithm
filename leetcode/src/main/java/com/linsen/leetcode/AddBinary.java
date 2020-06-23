package com.linsen.leetcode;

/**
 * @author lane.lin
 * @Description TODO
 * @since 2020/6/23
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(solution(a, b));
    }



    public static String solution(String a, String b){
        //1.先将两个字符串通过前面补0变成长度一致
        int maxLength = a.length() < b.length() ? b.length() : a.length();
        StringBuilder zeroStringBuilder = new StringBuilder();
        for (int i = 0; i < maxLength; i++){
            zeroStringBuilder.append("0");
        }
        String zeroString = zeroStringBuilder.toString();
        if(a.length() < b.length()){
            a = zeroString.substring(0, b.length() - a.length()) + a;
        }
        if(a.length() > b.length()){
            b = zeroString.substring(0, a.length() - b.length()) + b;
        }

        //2.遍历a，b字符串
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for(int i = a.length() - 1; i >= 0; i--){
            int result1 = a.charAt(i) - 48;
            int result2 = b.charAt(i) - 48;
            int resultSingle = result1 + result2 + carry;
            if(resultSingle == 0){
                result.append(0);
                carry = 0;
            }else if(resultSingle == 1){
                result.append(1);
                carry = 0;
            }else if(resultSingle == 2){
                result.append(0);
                carry = 1;
            }else if(resultSingle == 3){
                result.append(1);
                carry = 1;
            }
        }
        if(carry > 0){
            return result.append(carry).reverse().toString();
        }else{
            return result.reverse().toString();
        }

    }
}
