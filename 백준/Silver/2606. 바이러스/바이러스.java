import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int[][] nodes;
    static boolean[] visited;
    static int n;
    static int m;
    static int count = 0;

    public static int dfs(int number) {
        visited[number] = true;

        for (int i = 1; i <= n; i++) {
            if (nodes[number][i] == 1 && !visited[i]) {
                count++;
                dfs(i);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        nodes = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);

            nodes[first][second] = 1;
            nodes[second][first] = 1;
        }

        System.out.println(dfs(1));

    }
}
