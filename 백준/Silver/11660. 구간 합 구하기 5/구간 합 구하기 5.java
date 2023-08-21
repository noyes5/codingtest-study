import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 누적합, 부분합
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] arrSum = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 부분합
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arrSum[i][j] = arr[i - 1][j - 1] + arrSum[i - 1][j] + arrSum[i][j - 1] - arrSum[i - 1][j - 1];
            }
        }

        while (m > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            System.out.println(arrSum[c][d] - arrSum[c][b - 1] - arrSum[a - 1][d] + arrSum[a - 1][b - 1]);

            m--;
        }
    }
}