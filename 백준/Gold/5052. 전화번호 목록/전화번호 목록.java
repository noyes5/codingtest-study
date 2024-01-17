import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            String[] numbers = new String[M];
            for (int j = 0; j < M; j++) {
                numbers[j] = br.readLine().trim();
            }

            Arrays.sort(numbers);

            String result = "YES";
            for (int j = 0; j < M - 1; j++) {
                if (numbers[j + 1].startsWith(numbers[j])) {
                    result= "NO";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}