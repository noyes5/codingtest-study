import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class MyStack {
    private Stack<Integer> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    public int empty() {
        if (stack.empty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void push(int data) {
        stack.push(data);
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.pop();
        }
    }

    public int size() {
        return stack.size();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.peek();
        }
    }
}

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        MyStack myStack = new MyStack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch(command[0]) {
                case "empty":
                    sb.append(myStack.empty() + "\n");
                    break;
                case "push":
                    myStack.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    sb.append(myStack.pop() + "\n");
                    break;
                case "top":
                    sb.append(myStack.top() + "\n");
                    break;
                case "size":
                    sb.append(myStack.size() + "\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
