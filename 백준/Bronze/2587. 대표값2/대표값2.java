import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numberArr = new int[5];
        int sum = 0;
        int MIN = 0;

        for (int i= 0; i < 5; i++) {
            numberArr[i] = sc.nextInt();
            sum += numberArr[i];
        }

        for (int j = 1; j < 4; j++) {
            MIN = numberArr[j-1];
            for (int i = j-1; i < 5; i++) {
                if (MIN > numberArr[i]) {
                    MIN = numberArr[i];
                    numberArr[i] = numberArr[j-1];
                    numberArr[j-1] = MIN;

                }
            }
        }
        System.out.println(sum/5);
        System.out.println(numberArr[2]);
    }
}