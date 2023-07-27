public class Main {
    public static String solution(int N, int[] P, int[] C) {
        int stock = 0;
        int total = 0;
        int value = 100;

        for (int day = 0; day < N; day++) {
            stock += P[day];
            if (value == 0) {
                N = day;
                break;
            }
            if (stock >= C[day]) {
                stock -= C[day];
                total += C[day] * value;
                value = 100;
            } else {
                value -= 20;
            }
        }
        return String.format("%.2f", (double)total / N);
    }
}
