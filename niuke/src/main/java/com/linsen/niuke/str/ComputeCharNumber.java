package com.linsen.niuke.str;

import java.util.Scanner;

public class ComputeCharNumber {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char charWord = scanner.nextLine().charAt(0);
        int number = 0;
        for(int i = 0; i < str.length(); i++){
            if(charWord == str.charAt(i)){
                number++;
            }
        }
        System.out.println(number);
    }
}
