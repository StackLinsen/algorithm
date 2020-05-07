package com.linsen.niuke.str;

import java.util.Scanner;

/**
 * 进制转换
 * 将十六进制转换成10进制
 * 知识点：1.进制转换的计算  2.ascii码的使用   3.字符串的遍历
 */
public class ConvertHEX {

    public static void main(String[] args){
        //十六进制转换十进制  直接按照十进制计算 1*16^1 + 2*16^2
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine().substring(2);
            int index = 0;
            int n = 0;
            char c;
            int temp = 0;
            while(index < str.length()){
                c = str.charAt(str.length() - index - 1);
                if(c >= '0' && c <= '9'){
                    temp = c - '0';
                }else if(c >= 'A' && c <= 'F'){
                    temp = c - 'A' + 10;
                }else if(c >= 'a' && c <= 'f'){
                    temp = c - 'a' + 10;
                }
                n += temp * Math.pow(16, index);
                index++;
            }
            System.out.println(n);
        }
    }
}
