package com.linsen.leetcode;

/**
 * @author lane.lin
 * @Description TODO
 * @since 2020/6/22
 */
public class PatternMatching {

    public static void main(String[] args) {
        String value = "dogcatcatdog";
        String pattern = "aaaa";
        System.out.println(solution(pattern, value));
    }


    public static boolean solution(String pattern, String value){
        if(pattern.contains("a") && pattern.contains("b")){
            //既包含a，又包含b
            // TODO: 2020/6/22  
            return false;
        }else{
            //只包含其中一项
            int strLength = value.length();
            int parLength = pattern.length();
            if(strLength % parLength != 0){
                //除不尽，直接返回false
                return false;
            }
            int group = strLength / parLength;
            String startStr = value.substring(0, parLength);
            for(int i = 1; i < strLength - parLength; i++){
                String subString = value.substring(i * parLength, i * parLength + parLength);
                if(!startStr.equalsIgnoreCase(subString)){
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean solution_2(String pattern, String value){
        int count_a = 0, count_b = 0;
        for (char ch: pattern.toCharArray()) {
            if (ch == 'a') {
                ++count_a;
            } else {
                ++count_b;
            }
        }
        if (count_a < count_b) {
            int temp = count_a;
            count_a = count_b;
            count_b = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        if (value.length() == 0) {
            return count_b == 0;
        }
        if (pattern.length() == 0) {
            return false;
        }
        for (int len_a = 0; count_a * len_a <= value.length(); ++len_a) {
            int rest = value.length() - count_a * len_a;
            if ((count_b == 0 && rest == 0) || (count_b != 0 && rest % count_b == 0)) {
                int len_b = (count_b == 0 ? 0 : rest / count_b);
                int pos = 0;
                boolean correct = true;
                String value_a = "", value_b = "";
                for (char ch: pattern.toCharArray()) {
                    if (ch == 'a') {
                        String sub = value.substring(pos, pos + len_a);
                        if (value_a.length() == 0) {
                            value_a = sub;
                        } else if (!value_a.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_a;
                    } else {
                        String sub = value.substring(pos, pos + len_b);
                        if (value_b.length() == 0) {
                            value_b = sub;
                        } else if (!value_b.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += len_b;
                    }
                }
                if (correct && !value_a.equals(value_b)) {
                    return true;
                }
            }
        }
        return false;
    }
}
