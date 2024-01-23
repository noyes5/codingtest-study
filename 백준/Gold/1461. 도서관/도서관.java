import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int pair = Integer.parseInt(st.nextToken());
        List<Integer> posArr = new ArrayList<>();
        List<Integer> negArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                negArr.add(-num);
            } else {
                posArr.add(num);
            }
        }
        Collections.sort(posArr);
        Collections.sort(negArr);

        int sum = 0;

        int max = 0;
        if (!posArr.isEmpty() && !negArr.isEmpty()) {
            max = Math.max(posArr.get(posArr.size() - 1), negArr.get(negArr.size() - 1));
        } else if (!posArr.isEmpty()) {
            max = Math.max(max, posArr.get(posArr.size() - 1));
        } else {
            max = Math.max(max, negArr.get(negArr.size() - 1));
        }

        if (negArr.contains(max)) {
            for (int i = negArr.size() - 1; i >= 0; i -= pair) {
                if (negArr.get(i) != max) {
                    sum += negArr.get(i) * 2;
                }
            }
            sum += max;
        } else {
            for (int i = negArr.size() - 1; i >= 0; i -= pair) {
                sum += negArr.get(i) * 2;
            }
        }

        if (posArr.contains(max)) {
            for (int i = posArr.size() - 1; i >= 0; i -= pair) {
                if (posArr.get(i) != max) {
                    sum += posArr.get(i) * 2;
                }
            }
            sum += max;
        } else {
            for (int i = posArr.size() - 1; i >= 0; i -= pair) {
                sum += posArr.get(i) * 2;
            }
        }
        System.out.println(sum);
    }
}