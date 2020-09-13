package arrays_and_strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MaximumNumberSubstrings {
    public static List<String> maxNumOfSubstrings(String s) {
        var letters = new int[25][2];
        for (int i = 0; i < s.length(); i++) {
            int charIdx = (int) s.charAt(i) - 97;
            if (letters[charIdx][0] == 0) {
                letters[charIdx] = new int[]{i + 1, i + 1};
            } else {
                letters[charIdx][1] = i + 1;
            }
        }
        var maxSet = new HashSet<String>();
        var minLength = 0;
        for (int i = 0; i < letters.length; i++){
            var set = new HashSet<String>();
            if (letters[i][0]!=0){
                int start = letters[i][0] - 1;
                int end = letters[i][1];
                while (start < s.length() && end <= s.length()){
                    if (end >= s.length()){
                        set.add(s.substring(start));
                        break;
                    } else {
                        set.add(s.substring(start, end));
                        var nextChar = (int) s.charAt(end) - 97;
                        var step = 1;
                        while (letters[nextChar][0] < end && end + step < s.length()){
                            nextChar = (int) s.charAt(end + step++) - 97;
                        }
                        start = letters[nextChar][0] - 1;
                        end = letters[nextChar][1];
                    }
                }
            }
            var setLength = set.stream()
                               .mapToInt(String::length)
                               .sum();
            if (set.size() > maxSet.size()){
                minLength = setLength;
                maxSet = set;
            } if (set.size() == maxSet.size()){
                if (minLength > setLength) {
                    maxSet = set;
                }
            }
        }
        return new ArrayList<>(maxSet);
    }

    public static void main(String[] args) {
        System.out.println(maxNumOfSubstrings("abab"));
    }
}
