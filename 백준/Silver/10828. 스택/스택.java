import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class MyStack {
    private Stack<Integer> stack;

    public MyStack() {
        this.stack = new Stack<>();
    }

    public void empty() {
        if (stack.empty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public void push(int data) {
        stack.push(data);
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.pop());
        }
    }

    public void size() {
        System.out.println(stack.size());
    }

    public void top() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.peek());
        }
    }
}

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        MyStack myStack = new MyStack();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            switch(command[0]) {
                case "empty":
                    myStack.empty();
                    break;
                case "push":
                    myStack.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    myStack.pop();
                    break;
                case "top":
                    myStack.top();
                    break;
                case "size":
                    myStack.size();
                    break;
            }
        }
    }
}