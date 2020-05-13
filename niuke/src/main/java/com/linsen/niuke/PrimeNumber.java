package com.linsen.niuke;

import java.util.Scanner;

/**
 * 列出一个数的所有质数因子
 * 如何判断一个数是质数
 */
public class PrimeNumber {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long value = scanner.nextLong();
        if(value < 2){
            scanner.close();
            return;
        }
        System.out.println(getResult(value));
        scanner.close();
    }


    private static String getResult(long ulDataInput){
        StringBuilder stringBuilder = new StringBuilder();
        int index = 2;
        while(index <= ulDataInput){
            if(ulDataInput % index == 0){
                stringBuilder.append(index).append(" ");
                if(index == ulDataInput){
                    break;
                }else{
                    ulDataInput=ulDataInput/index;
                }
            }else{
                index++;
            }
        }
        return stringBuilder.toString();
    }
}
