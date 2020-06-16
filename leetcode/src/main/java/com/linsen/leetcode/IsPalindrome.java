package com.linsen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    public boolean solution(int x){
        if(x < 0){
            return false;
        }else if(x < 10){
            return true;
        }

        List<Integer> remainder = new ArrayList<>();
        while(x != 0){
            remainder.add(x % 10);
            x = x / 10;
        }
        int size = remainder.size();
        for(int i = 0; i <= size / 2; i++){
            if(remainder.get(i).intValue() != remainder.get(size - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public boolean solution_2(int x){
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }




}
