import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int Size = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        int arrLen = arr.length;
        int[] data = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            data[i] = Integer.parseInt(arr[i]);
        }
        int answer = Math.max(data[0], N - data[arrLen - 1]);
        for (int i = 0; i < arrLen; i++) {
            if (i > 0) {
                while (data[i - 1] + answer < data[i] - answer) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}