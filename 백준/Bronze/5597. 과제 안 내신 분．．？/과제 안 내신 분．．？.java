import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] classStudents = new int[30];

        for (int i = 0; i < 28; i++) {
            classStudents[sc.nextInt() - 1] += 1;
        }

        for (int i = 0; i < 30; i++) {
            if (classStudents[i] == 0) {
                System.out.println(i + 1);
            }
        }
    }
}