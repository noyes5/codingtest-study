import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
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
    static final int INF = Integer.MAX_VALUE;
    static int[] dist;
    static ArrayList<Edge>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(br.readLine());
        dist = new int[v + 1];
        adjList = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList[v1].add(new Edge(v2, w));
        }

        Arrays.fill(dist, INF);
        dijkstra(startV);

        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curV = cur.v;

            if (dist[curV] < cur.w) {
                continue;
            }

            for (Edge edge : adjList[curV]) {
                int next = edge.v;
                int nextDist = dist[curV] + edge.w;

                if (dist[next] > nextDist) {
                    dist[next] = nextDist;
                    pq.add(new Edge(next, nextDist));
                }
            }
        }
    }
}