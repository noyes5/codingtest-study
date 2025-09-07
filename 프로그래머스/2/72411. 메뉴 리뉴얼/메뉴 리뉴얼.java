import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 모든 경우의 수
        // A~Z까지. 26개. 26C10는...엄청난 수
        // Map을 만들어서 각각 경우의 수 key로 넣어서 더하고, 그때 value를 비교하면 되지 않을까?
        Map<Integer, Map<String, Integer>> countByLen = new HashMap<>();
        for (int r : course) {
            countByLen.put(r, new HashMap<>());
        }
        
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            
            for (int r : course) {
                if (r > arr.length) {
                    continue;
                }
                List<String> combi = combinations(arr, r);
                Map<String, Integer> map = countByLen.get(r);
                for (String c : combi) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
        }
        
        // 코스 길이별 2이상인 최빈값들 선별
        List<String> answer = new ArrayList<>();
        for (int r : course) {
            Map<String, Integer> map = countByLen.get(r);
        
            int max = 0;
            for (int v : map.values()) {
                max = Math.max(max, v);
            }
            if (max < 2) {
                continue;
            }
        
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                if (e.getValue() == max) {
                    answer.add(e.getKey());
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
    
    // r개 조합을 모두 반환
    private List<String> combinations(char[] arr, int r) {
        List<String> out = new ArrayList<>();
        backtrack(arr, 0, r, new StringBuilder(), out);
        return out;
    }

    private void backtrack(char[] arr, int start, int r, StringBuilder pick, List<String> out) {
        if (pick.length() == r) {
            out.add(pick.toString());
            return;
        }
        
        for (int i = start; i < arr.length; i++) {
            pick.append(arr[i]);
            backtrack(arr, i + 1, r, pick, out);
            pick.deleteCharAt(pick.length() - 1);
        }
    }
}