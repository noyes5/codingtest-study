import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static int[] parent;
    static int N, M;
    static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        total = 0;
        int totalTree = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            total += cost;
            pq.add(new Edge(a, b, cost));
        }

        System.out.println(doKruskal(pq));
    }

    private static long doKruskal(PriorityQueue<Edge> pq) {
        long totalLength = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            int x = find(current.start);
            int y = find(current.end);

            if (x != y) {
                totalLength += current.cost;
                union(current.start, current.end);
                cnt++;
            }

            if (cnt == N - 1) {
                return total - totalLength;
            }
        }
        return -1;
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        }
        if (x >= y) {
            parent[x] = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge order) {
            return this.cost - order.cost;
        }
    }
}