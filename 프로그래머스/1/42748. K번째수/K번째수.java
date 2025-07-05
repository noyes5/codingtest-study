import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
            .mapToInt(cmd -> {
                int start = cmd[0] - 1;
                int end = cmd[1];
                int k = cmd[2] - 1;
                return Arrays.stream(array, start, end)
                    .sorted()
                    .toArray()[k];
            })
            .toArray();
    }
}