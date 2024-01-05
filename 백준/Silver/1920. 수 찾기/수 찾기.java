import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new HashSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int number = Integer.parseInt(st.nextToken());
            if (set.contains(number)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}