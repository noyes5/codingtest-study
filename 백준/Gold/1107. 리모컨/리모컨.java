import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int targetChn = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] disableButton = new boolean[10];

        if (targetChn == 100) {
            System.out.println(0);
            return;
        }

        if (N == 10) {
            System.out.println(Math.abs(100 - targetChn));
            return;
        }

        int min = Math.abs(targetChn - 100);

        StringTokenizer st;
        if (N != 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int chn = Integer.parseInt(st.nextToken());
                disableButton[chn] = true;
            }
        }

        for (int i = 0; i < 1000000; i++) {
            int tmp = i;
            boolean isDisable = false;

            if (tmp == 0) {
                if (disableButton[0]) continue;
                min = Math.min(min, Math.abs(targetChn - i) + 1);
                continue;
            }

            while (tmp > 0) {
                if (disableButton[tmp % 10]) {
                    isDisable = true;
                    break;
                }
                tmp /= 10;
            }

            if (!isDisable) {
                int buttonPresses = String.valueOf(i).length();
                min = Math.min(min, Math.abs(targetChn - i) + buttonPresses);
            }
        }
        
        System.out.println(min);
    }
}
