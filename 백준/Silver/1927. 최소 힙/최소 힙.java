import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0) {
                Integer pollNumber = heap.poll();
                if (pollNumber == null) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(pollNumber).append("\n");
                }
            } else {
                heap.add(number);
            }
        }

        System.out.println(sb);
    }
}