import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 10_000_000;
    static int[][] adj;
    static int v;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        adj = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(adj[i], INF);
            adj[i][i] = 0;
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[v1 - 1][v2 - 1] = cost;
        }

        floyd();

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, adj[end - 1][i] + adj[i][end -1]);
        }

        System.out.println(max);
    }

    public static void floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }
}