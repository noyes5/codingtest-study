import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        Stack<Integer> idxStack = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            while (!idxStack.isEmpty() && prices[idxStack.peek()] > prices[i]) {
                int top = idxStack.pop();
                answer[top] = i - top;
            }
            
            idxStack.push(i);
        }
        
        while (!idxStack.isEmpty()) {
            int top = idxStack.pop();
            answer[top] = (N - 1) - top;
        }
        
        return answer;
    }
}