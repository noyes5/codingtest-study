import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Edge implements Comparable<Edge> {
    int v;
    int w;
    int weight;

    Edge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int[] parent;

    public static int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]);
        }
        return parent[vertex];
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        parent[bParent] = aParent;
    }

    public static long getMinimumCost(Edge[] edges, int n) {
        Arrays.sort(edges);

        long minSum = 0;
        int usedEdges = 0;

        for (Edge edge : edges) {
            if (find(edge.v) != find(edge.w)) {
                union(edge.v, edge.w);
                minSum += edge.weight;
                usedEdges++;

                if (usedEdges == n - 1) {
                    break;
                }
            }
        }

        return minSum;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Edge[] edges = new Edge[n * (n - 1) / 2];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int edgeCount = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int weight = Integer.parseInt(input[j]);

                if (i < j) {
                    edges[edgeCount++] = new Edge(i, j, weight);
                }
            }

        }

        System.out.println(getMinimumCost(edges, n));
    }
}