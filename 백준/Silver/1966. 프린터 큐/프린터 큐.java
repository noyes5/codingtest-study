import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                pq.offer(new int[] {i, priority});
                q.offer(new int[] {i, priority});
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] current = q.poll();

                if (current[1] == pq.peek()[1]) {
                    count++;
                    pq.poll();

                    if (current[0] == M) {
                        break;
                    }
                } else {
                    q.add(current);
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}