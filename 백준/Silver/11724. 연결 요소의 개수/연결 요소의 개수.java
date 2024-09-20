import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;
    static boolean[] visited;
    static int N;
    static int M;

    static void dfs(int n, boolean[] visited) {
        visited[n] = true;
        for (int i = 0; i < graph[n].length; i++) {
            if (graph[n][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[n][v] = 1;
            graph[v][n] = 1;
        }
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        System.out.println(count);
    }
}
