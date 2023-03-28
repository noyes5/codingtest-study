import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class MyStack {
    Stack<Integer> stack;
    
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
        if(stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.pop());
        }
    }
    
    public void size() {
        System.out.println(stack.size());
    }
    
    public void top() {
        if(stack.isEmpty()) {
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
            String command = "";
            int data = 0;
            String[] strArr = br.readLine().split(" ");
            if (strArr.length == 1) {
                command = strArr[0];
            }
            if (strArr.length == 2) {
                command = strArr[0];
                data = Integer.parseInt(strArr[1]);
            }
            if (command.equals("empty")) {
                myStack.empty();
            }
            if (command.equals("push")) {
                myStack.push(data);
            }
            if (command.equals("pop")) {
                myStack.pop();
            }
            if (command.equals("top")) {
                myStack.top();
            }
            if (command.equals("size")) {
                myStack.size();
            }
            
        }
    
    }
}



