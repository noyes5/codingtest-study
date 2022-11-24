import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] numberArr = new int[N];

        for (int i = 0; i < N; i++) {
            numberArr[i] = sc.nextInt();
        }

        int standardNumber = sc.nextInt();
        int count = 0;
        for (int val : numberArr) {
            if (val == standardNumber) {
                count++;
            }
        }
        System.out.println(count);
    }
}
