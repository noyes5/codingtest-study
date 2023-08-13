class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] isPainted = new boolean[n];
        int paintingCount = 0;

        for (int i = 0; i < n; i++) {
            isPainted[i] = true;
        }

        for (int notPaintedlNumber : section) {
            isPainted[notPaintedlNumber - 1] = false;
        }

        for (int i = 0; i < n; i++) {
            if (!isPainted[i]) {
                paintingCount++;
                int count = Math.min(m, n - i);
                for (int j = 0; j < count; j++) {
                    isPainted[i + j] = true;
                }
            }
        }

        return paintingCount;
    }
}
