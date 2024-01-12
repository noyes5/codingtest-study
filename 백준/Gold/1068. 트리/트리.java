import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] graph;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int delete = Integer.parseInt(br.readLine());

        dfs(delete);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i] != -2 && hasNoChild(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int v) {
        graph[v] = -2;

        for (int i = 0; i < n; i++) {
            if (v == graph[i]) {
                dfs(i);
            }
        }
    }

    private static boolean hasNoChild(int node) {
        for (int v : graph) {
            if (v == node) {
                return false;
            }
        }
        return true;
    }

}