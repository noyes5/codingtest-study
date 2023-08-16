import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 누적합, 구간합
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] sumArr = new int[n + 1];
        int[] mArr = new int[n + 1 - m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sumArr[i + 1] = sumArr[i] + arr[i];
        }

        for (int i = 0; i < n + 1 - m; i++) {
            mArr[i] = sumArr[i + m] - sumArr[i];
        }

        System.out.println(maxInt(mArr));
    }

    static int maxInt(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        return max;
    }
}