package dp;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return "";
        }
        var start = 0;
        var end = 0;
        for(int i = 0; i < s.length(); i++) {
            var len1 = expandAroundCenter(s, i, i);
            var len2 = expandAroundCenter(s, i, i + 1);
            var len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        var l = left;
        var r = right;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
