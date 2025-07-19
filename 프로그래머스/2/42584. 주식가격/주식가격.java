public class Solution {
    public int[] solution(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    result[i] = j - i;
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[i] = n - i - 1;
            }
        }

        return result;
    }
}
