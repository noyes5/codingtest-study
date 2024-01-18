import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // vertex와 cost 배열 입력 받기
        long[] cost = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] vertex = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long minVertex = Integer.MAX_VALUE;
        long totalCost = 0;

        for (int i = 0; i < N - 1; i++) {
            if (minVertex > vertex[i]) {
                minVertex = vertex[i];
            }
            totalCost += minVertex * cost[i];
        }
        System.out.println(totalCost);
    }
}
