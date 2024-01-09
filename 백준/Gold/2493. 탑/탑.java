import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] inputNumbers = new int[N];
        List<Integer> answer = new ArrayList<>();
        Deque<int[]> q = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            inputNumbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            int number = inputNumbers[i];

            if (number > max) {
                max = number;

                while (!q.isEmpty() && q.peek()[0] < number) {
                    q.pollFirst();
                }
                q.offerFirst(new int[] {number, i + 1});
                answer.add(0);
            } else {
                if (!q.isEmpty()) {
                    int neighborTop = q.peek()[0];
                    while (neighborTop < number) {
                        q.poll();
                        neighborTop = q.peek()[0];
                    }

                    answer.add(q.peek()[1]);
                    q.offerFirst(new int[] {number, i + 1});
                }
            }
        }
        String result = answer.toString()
                .replace("[","")
                .replace("]","")
                .replace(",","");

        System.out.println(result);
    }
}
