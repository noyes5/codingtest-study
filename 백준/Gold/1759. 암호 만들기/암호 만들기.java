import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static char[] letters;
    static final String VOWELS = "aeiou";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int amountLetter = Integer.parseInt(st.nextToken());
        letters = new char[amountLetter];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < amountLetter; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);

        dfs(0, "", 0);

    }

    public static void dfs(int start, String curStr, int vowelCount) {
        if (curStr.length() == n) {
            if (vowelCount >= 1 && vowelCount <= n - 2) {
                System.out.println(curStr);
                return;
            }
        }
        for (int i = start; i < letters.length; i++) {
            char c = letters[i];

            if (VOWELS.indexOf(c) >= 0) {
                dfs(i + 1, curStr + c, vowelCount + 1);
            } else {
                dfs(i + 1, curStr + c, vowelCount);
            }
        }
    }
}