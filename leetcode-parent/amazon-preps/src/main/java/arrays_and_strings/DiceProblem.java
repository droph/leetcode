package arrays_and_strings;

public class DiceProblem {
    public static void main(String[] args) {
        System.out.println(new DiceProblem().numRollsToTarget(30, 30, 500));
    }

    public int numRollsToTarget(int d, int f, int target) {
        var mod = 1_000_000_000 + 7;
        var memory = new int[d][target + 1];
        for (int diceCnt = 0; diceCnt < d; diceCnt++) {
            for (int currSum = 1; currSum <= target; currSum++) {
                if (diceCnt == 0) {
                    memory[diceCnt][currSum] = currSum >= 1 && currSum <= f ? 1 : 0;
                } else {
                    for (int face = 1; face <= f; face++) {
                        if (currSum - face > 0) {
                            memory[diceCnt][currSum] += memory[diceCnt - 1][currSum - face];
                            memory[diceCnt][currSum] %= mod;
                        }
                    }
                }
            }
        }
        return memory[d - 1][target] % mod;
    }
}
