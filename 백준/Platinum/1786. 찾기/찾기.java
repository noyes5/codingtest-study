import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String T = bf.readLine();
        String P = bf.readLine();

        kmp(T, P);
    }

    private static void kmp(String T, String P) {
        int tLen = T.length();
        int pLen = P.length();
        int[] table = createTable(P);
        int idx = 0;
        int cntPattern = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < tLen; i++) {
            while (idx > 0 && T.charAt(i) != P.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (T.charAt(i) == P.charAt(idx)) {
                if (idx == pLen - 1) {
                    cntPattern++;
                    answer.add(i - pLen + 2);
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }
        System.out.println(cntPattern);
        answer.forEach(index -> System.out.print(index + " "));
    }

    private static int[] createTable(String P) {
        int[] idx = new int[P.length()];
        int j = 0;
        for (int i = 1; i < P.length(); i++) {
            while (j > 0 && P.charAt(i) != P.charAt(j)) {
                j = idx[j - 1];
            }

            if (P.charAt(i) == P.charAt(j)) {
                idx[i] = ++j;
            }
        }
        return idx;
    }
}