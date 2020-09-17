package arrays_and_strings;

public class GcdString {
    public static void main(String[] args) {
        System.out.println(new GcdString().gcdOfStrings("ABABAB", "ABAB"));
    }

    public String gcdOfStrings(String str1, String str2) {
        int M = str1.length();
        int N = str2.length();
        int m = Math.min(N, M);

        for (int i = m; i >= 1; i--) {
            if (M % i == 0 && N % i == 0 && check(str1, str2, i)) {
                return str2.substring(0, i);
            }
        }
        return "";
    }

    private boolean check(String str1, String str2, int x) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i % x) != str1.charAt(i) ||
                    str1.charAt(i) != str2.charAt(i % x)) {
                return false;
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i % x) != str2.charAt(i) ||
                    str2.charAt(i) != str1.charAt(i % x)) {
                return false;
            }
        }
        return true;
    }
}
