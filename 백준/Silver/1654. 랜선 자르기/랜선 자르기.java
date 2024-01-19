import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        long[] cables = new long[K];

        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }

        long start = 1;
        long end = 0;

        for (long cable : cables) {
            end = Math.max(cable, end);
        }

        long ans = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (long cable : cables) {
                count += cable / mid;
            }

            if (count >= N) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}