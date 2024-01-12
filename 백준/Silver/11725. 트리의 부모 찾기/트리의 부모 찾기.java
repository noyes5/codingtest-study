import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<Integer, List<Integer>> edges = new HashMap<>();
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        parents = new int[n + 1];

        for (int i = 0; i < n - 1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            edges.putIfAbsent(first, new ArrayList<>());
            edges.putIfAbsent(second, new ArrayList<>());
            edges.get(first).add(second);
            edges.get(second).add(first);
        }

        dfs(1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }

    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int v : edges.get(node)) {
            if (!visited[v]) {
                dfs(v);
                parents[v] = node;
            }
        }
    }
}