import java.io.*;

public class Main {

    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(calStairs(N));
    }

    static long calStairs(int n) {
        long[] dp = new long[10];
        long[] newDp = new long[10];

        for (int i = 1; i < 10; i++) {
            dp[i] = 1;
        }

        for (int digit = 2; digit <= n; digit++) {
            newDp[0] = dp[1];

            for (int i = 1; i <= 8; i++) {
                newDp[i] = (dp[i - 1] + dp[i + 1]) % MOD;
            }

            newDp[9] = dp[8];

            long[] tmp = dp;
            dp = newDp;
            newDp = tmp;
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[i]) % MOD;
        }

        return result;
    }
}
