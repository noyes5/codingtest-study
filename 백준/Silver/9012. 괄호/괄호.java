import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            int count = 0;
            String[] strArr = br.readLine().split("");
            for (String str : strArr) {
                if (count < 0) {
                    count = -1;
                    break;
                }
                if (str.equals("(")) {
                    stack.push('(');
                    count++;
                }
                if (str.equals(")")) {
                    stack.push(')');
                    count--;
                }
            }
            if (count == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
