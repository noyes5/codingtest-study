import java.util.ArrayList;
import java.util.List;

public class Main {
    boolean[] visit;
    List<Integer>[] adj;

    int child(int now, int N) {
        if (visit[now]) {
            return 0;
        }
        visit[now] = true;

        int c = 1;
        for (int i : adj[now]) {
            c += child(i, N);
        }

        return c;
    }

    boolean checking(int N) {
        visit = new boolean[N];
        for (int k = 0; k < N; k++) {
            if (!visit[k] && child(k, N) != N / 3) {
                return false;
            }
        }
        return true;
    }

    public int[] solution(int N, int[][] roads) {
        adj = new ArrayList[N];
        for (int k = 0; k < N; k++) {
            adj[k] = new ArrayList<>();
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = 0; k < N - 1; k++) {
                    if (i != k && j != k) {
                        adj[roads[k][0]].add(roads[k][1]);
                        adj[roads[k][1]].add(roads[k][0]);
                    }
                }
                if (checking(N)) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }
}
