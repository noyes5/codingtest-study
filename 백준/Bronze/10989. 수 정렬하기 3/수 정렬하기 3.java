import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] numberAll = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            numberAll[Integer.parseInt(br.readLine())] += 1;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            while (numberAll[i] > 0) {
                sb.append(i).append("\n");
                numberAll[i]--;
            }
        }
        System.out.println(sb);
    }
}