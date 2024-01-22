import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return other.weight - this.weight;  // 무게 제한이 큰 순으로 정렬
    }
}

public class Main {
    static List<Edge>[] graph;

    public static int dijkstra(int start, int end, int houseSize) {
        int[] maxWeight = new int[houseSize + 1];
        Arrays.fill(maxWeight, -1);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, Integer.MAX_VALUE));
        maxWeight[start] = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;
            int currentWeight = current.weight;

            if (currentNode == end) {
                return currentWeight;
            }

            for (Edge e : graph[currentNode]) {
                int nextNode = e.node;
                int nextWeight = Math.min(currentWeight, e.weight);

                if (nextWeight > maxWeight[nextNode]) {
                    maxWeight[nextNode] = nextWeight;
                    pq.offer(new Edge(nextNode, nextWeight));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[h1].add(new Edge(h2, weight));
            graph[h2].add(new Edge(h1, weight));
        }

        System.out.println(dijkstra(start, end, n));
    }
}