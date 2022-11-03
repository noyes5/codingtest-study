import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        int j = 0;

        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            numbers[i] = number;
        }
        while (j < numbers.length) {
            int a = numbers[j];
            for (int i=j+1; i<numbers.length; i++) {
                if (a > numbers[i]) {
                    a = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = a;
                }
            }
            j++;
        }
        for (int val : numbers) {
            System.out.println(val);
        }
    }
}