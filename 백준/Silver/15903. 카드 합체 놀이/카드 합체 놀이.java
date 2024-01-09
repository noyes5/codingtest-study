import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndM = br.readLine().split(" ");
        int n = Integer.parseInt(nAndM[0]);
        int m = Integer.parseInt(nAndM[1]);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            Long card = Long.parseLong(input[i]);
            pq.add(card);
        }

        while (m-- > 0) {
            long firstCard = pq.poll(); 
            long secondCard = pq.poll(); 
            long gameSum = firstCard + secondCard; 
            pq.add(gameSum);
            pq.add(gameSum);
        }
        long answer = 0;

        while (!pq.isEmpty()) {
            answer += pq.poll(); 
        }

        System.out.println(answer);
    }
}