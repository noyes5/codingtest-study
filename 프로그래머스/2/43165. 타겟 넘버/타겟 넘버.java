import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // BFS에서 사용할 큐를 생성 (초기값 0)
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        for (int num : numbers) {
            int size = queue.size();
            // 큐에 있는 현재의 모든 값을 처리
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                queue.add(cur + num);
                queue.add(cur - num);
            }
        }
        
        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                answer++;
            }
        }

        return answer;
    }
}