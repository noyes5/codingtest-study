import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> alphabetMinClick = new HashMap<>();
        int[] result = new int[targets.length];
        
        for (String key : keymap) {
            for (int i = 0 ; i < key.length() ; i++) {
                char c = key.charAt(i);
                if (!alphabetMinClick.containsKey(c) || i < alphabetMinClick.get(c)) {
                    alphabetMinClick.put(c, i + 1);
                }
            }
        }
        
        for (int i = 0 ; i < targets.length ; i++) {
            int count = 0;
            for (int j = 0; j < targets[i].length() ; j++) {
                char c = targets[i].charAt(j);
                if (!alphabetMinClick.containsKey(c)) {
                    count = 0;
                    break;
                } else {
                    count += alphabetMinClick.get(c);
                }
            }
            
            if (count == 0) { 
                result[i] = -1;
            } else {
                result[i] = count;
            }
        }
        return result;
    }
}