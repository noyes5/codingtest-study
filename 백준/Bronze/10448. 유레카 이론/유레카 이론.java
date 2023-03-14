import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] triNumList = new int[1000];

        int data = 0;

        for (int i = 0; i < 44; i++) {
            data = ((i + 1) * (i + 2)) / 2;
            triNumList[i] = data;
        }

        boolean[] isSum = new boolean[10000];
        for (int i = 0; i < 44; i++) {
            for (int j = 0; j < 44; j++) {
                for (int k = 0; k < 44; k++) {
                    int sum = triNumList[i] + triNumList[j] + triNumList[k];
                    isSum[sum] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());

            if (isSum[M] == true) {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        for (int numList : list) {
            System.out.println(numList);
        }
    }
}
