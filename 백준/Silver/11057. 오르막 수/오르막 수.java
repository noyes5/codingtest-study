import java.io.*;

public class Main {

    final static long MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(calAscNum(N));
    }

    static long calAscNum(int n) {
        long[] dp = new long[10];
        long[] newDp = new long[10];

        for (int i = 0; i < 10; i++) {
            dp[i] = 1;
        }

        for (int digit = 2; digit <= n; digit++) {
            long sum = 0;
            for (int i = 9; i >= 0; i--) {
                sum = (sum + dp[i]) % MOD;
                newDp[i] = sum;
            }

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
