import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 누적합, 구간합
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = 0;
        int y = 0;
        int[] arr = new int[n];
        int[] sumArr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sumArr[i + 1] += sumArr[i] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            x = sc.nextInt();
            y = sc.nextInt();

            System.out.println(sumArr[y] - sumArr[x - 1]);
        }
    }
}