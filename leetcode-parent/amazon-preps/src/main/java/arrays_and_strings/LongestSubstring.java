package arrays_and_strings;

import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String str) {
        var positions = new HashMap<Character, Integer>();
        var size = str.length();
        var ans = 0;
        for(int i = 0, j = 0; j < size; j++) {
            var currChar = str.charAt(j);
            if (positions.containsKey(currChar)){
                i = Math.max(positions.get(currChar), i);
            }
            positions.put(currChar, j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
    //idvedf
}
