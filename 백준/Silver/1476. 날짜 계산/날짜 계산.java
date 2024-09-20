import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 1;
        while (true) {
            if ((ans - 1) % 15 + 1 == E &&
                (ans - 1) % 28 + 1 == S &&
                (ans - 1) % 19 + 1 == M) {
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }
}
