import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Edge implements Comparable<Edge> {
    int w;
    int cost;

    public Edge(int w, int cost) {
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static List<Edge>[] graph;


    public static void prim(int start, int houseSize) {
        boolean[] visited = new boolean[houseSize + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        int total = 0;
        int max = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if (visited[v]) {
                continue;
            }

            visited[v] = true;

            total += cost;
            max = Math.max(max, cost);

            for (Edge e : graph[v]) {
                if (!visited[e.w]) {
                    pq.add(e);
                }
            }
        }
        System.out.println(total - max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int houseSize = Integer.parseInt(st.nextToken());
        int repeat = Integer.parseInt(st.nextToken());
        graph = new ArrayList[houseSize + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < repeat; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Edge(w, cost));
            graph[w].add(new Edge(v, cost));
        }

        prim(1, houseSize);
    }
}