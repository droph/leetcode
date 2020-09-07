package arrays_and_strings;

public class Atoi {
    public static int calculateMyAtoi(String str) {
        var start = 0;
        var end = 0;
        var multiplier = 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
            end++;
        }
        if (start == str.length()) {
            return 0;
        }
        if (str.charAt(start) == '-') {
            multiplier = -1;
            start++;
            end++;
        } else if (str.charAt(start) == '+') {
            start++;
            end++;
        }
        while (start < str.length() && str.charAt(start) == '0') {
            start++;
            end++;
        }
        while (end < str.length() && Character.isDigit(str.charAt(end))) {
            end++;
        }
        if (start == end) {
            return 0;
        }
        if (end - start > 10) {
            if (multiplier == -1) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        var substr = str.substring(start, end);
        var result = Long.parseLong(substr) * multiplier;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
