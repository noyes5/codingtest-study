import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int v;
    int w;

    Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}


public class Main {
    static final int INF = 10_000_000;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        dist = new int[v + 1][v + 1];

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[v1][v2] = w;
        }


        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = INF;

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
               if (i != j && dist[i][j] != INF && dist[j][i] != INF) {
                   answer = Math.min(answer, dist[i][j] + dist[j][i]);
                }
            }
        }

        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
}