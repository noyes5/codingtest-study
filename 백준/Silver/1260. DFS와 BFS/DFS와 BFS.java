import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<Integer> dfs = new ArrayList<>();
    static List<Integer> bfs = new ArrayList<>();
    static int[][] graph;
    static int n;
    static int m;
    static int start;

    static boolean[] visited;

    public static void dfs(int number) {
        dfs.add(number);
        visited[number] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[number][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int number) {
        Queue<Integer> q = new LinkedList<>();
        q.add(number);
        visited[number] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            for (int nv = 1; nv <= n; nv++) {
                if (graph[node][nv] == 1 && !visited[nv]) {
                    visited[nv] = true;
                    q.add(nv);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        start = Integer.parseInt(input[2]);

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int first = Integer.parseInt(input2[0]);
            int second = Integer.parseInt(input2[1]);
            graph[first][second] = 1;
            graph[second][first] = 1;
        }

        dfs(start);
        Arrays.fill(visited, false);
        bfs(start);

        System.out.println(dfs.toString()
                .replace(",","")
                .replace("[","")
                .replace("]",""));


        System.out.println(bfs.toString()
                .replace(",","")
                .replace("[","")
                .replace("]",""));

    }
}