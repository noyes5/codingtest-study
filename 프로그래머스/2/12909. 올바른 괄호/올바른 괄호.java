import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> blankStack = new Stack<Character>();
        
        boolean answer = false;

        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            
            if (now == ')') {
                if (blankStack.size() == 0) {
                    answer = false;
                    return answer;    
                }
                blankStack.pop();
            }
            
            if (now == '(') {
                blankStack.push(now);    
            }
        }
        
        if (blankStack.size() == 0) {
            answer = true;
        }

        return answer;
    }
}