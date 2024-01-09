import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            boolean isEndSentence = true;

            for (char c : input.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                }
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isEndSentence = false;
                        break;
                    }
                    stack.pop();
                }
                if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isEndSentence = false;
                        break;
                    }
                    stack.pop();
                }
            }

            if (isEndSentence && stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}