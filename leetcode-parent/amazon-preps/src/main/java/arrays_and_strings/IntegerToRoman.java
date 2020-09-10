package arrays_and_strings;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

    private static final TreeMap<Integer, String> NUMS_TO_ROMAN = new TreeMap<>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };

    public static String intToRoman(int num) {
        var idx = 0;
        var restNum = num;
        var cnt = 0;
        var stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> currVal : NUMS_TO_ROMAN.descendingMap().entrySet()) {
            cnt = 0;
            if (idx % 2 == 0) {
                cnt = restNum / currVal.getKey();
                restNum -= (cnt * currVal.getKey());
            } else if (restNum >= currVal.getKey()){
                cnt = 1;
                restNum -= currVal.getKey();
            }
            for (int i = 0; i < cnt; i++) {
                stringBuilder.append(currVal.getValue());
            }
            idx++;
        }
        return stringBuilder.toString();
    }
}
