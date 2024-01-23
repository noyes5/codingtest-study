import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        dp[0] = graph[0];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                // dp에는 이전행의 선택되지 않은 열들의 최솟값의 합을 구한다.
                dp[i][j] = graph[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < 3; j++) {
            min = Math.min(min, dp[N - 1][j]);
        }
        System.out.println(min);
    }
}