package arrays_and_strings;

import java.util.Arrays;
import java.util.HashSet;

public class PrisonCells {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new PrisonCells().prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000)));
        System.out.println(Arrays.toString(new PrisonCells().prisonAfterNDays(new int[]{0,0,0,1,1,0,1,0}, 574)));
//        System.out.println(Arrays.toString(new PrisonCells().prisonAfterNDays(new int[]{1,1,0,1,1,0,1,1}, 6)));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        var result = cells;
        var cycle = false;
        var calculatedResults = new HashSet<String>();
        var results = new int[20][cells.length];
        for (int day = 0; day < N; day++) {
            result = getNextDay(result);
            var resultKey = Arrays.toString(result);
            System.out.println(day + " " + resultKey);
            if (!calculatedResults.add(resultKey)) {
                cycle = true;
                break;
            }
            results[day] = result;
        }
        if (cycle) {
            return results[(N - 1) % calculatedResults.size()];
        }
        return result;
    }

    private int[] getNextDay(int[] lastDay) {
        var nextDay = new int[lastDay.length];
        for (int idx = 1; idx < lastDay.length - 1; idx++) {
            if (lastDay[idx - 1] == lastDay[idx + 1]) {
                nextDay[idx] = 1;
            } else {
                nextDay[idx] = 0;
            }
        }
        return nextDay;
    }
}
