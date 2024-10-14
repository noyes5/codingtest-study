import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            int count = map.getOrDefault(cloth[1], 1);
            map.put(cloth[1], ++count);
        }

        int count = 1;
        for (String key : map.keySet()) {
            count *= map.get(key);
        }

        return --count;
    }
}