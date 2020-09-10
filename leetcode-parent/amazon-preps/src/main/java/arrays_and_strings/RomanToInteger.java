package arrays_and_strings;

import java.util.TreeMap;

public class RomanToInteger {

    private static final TreeMap<String, Integer> ROMAN_TO_NUMS = new TreeMap<>() {
        {
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }
    };

    public static int romanToInt(String s) {
        var result = 0;
        for (int i = 0; i < s.length(); i++) {
            var romanChar = s.substring(i, i + 1);
            if (ROMAN_TO_NUMS.containsKey(romanChar)) {
                if (s.length() > i + 1 && ROMAN_TO_NUMS.containsKey(s.substring(i, i + 2))){
                    result += ROMAN_TO_NUMS.get(s.substring(i, i + 2));
                    i++;
                } else {
                    result += ROMAN_TO_NUMS.get(romanChar);
                }
            }
        }
        return result;
    }
}
