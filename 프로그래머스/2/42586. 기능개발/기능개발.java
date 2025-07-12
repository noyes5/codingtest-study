import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> waitJob = new LinkedList<>();
        Arrays.stream(progresses).forEach(waitJob::offer);
        // 완료된 작업의 크기를 계산해서, 반복문을 종료
        Queue<Integer> progressJob = new LinkedList<>();
        Stack<Integer> completedJob = new Stack<>();
        int N = progresses.length;
        int startIdx = 0;
        List<Integer> list = new ArrayList<>();
        
        while (completedJob.size() != N) {
            int idx = startIdx;
            
            int size = waitJob.size();
            
            for (int i = 0; i < size; i++) {
                int now = waitJob.poll();
                now += speeds[idx++];
                progressJob.offer(now);
            }
            
            int count = 0;
            
            int size2 = progressJob.size();
            
            for (int i = 0; i < size2; i++) {
                if (progressJob.peek() < 100) {
                    waitJob = progressJob;
                    progressJob = new LinkedList<>();
                    break;
                }
                
                int now = progressJob.poll();
                count++;
                completedJob.add(now);
                startIdx++;
            }
            
            if (count != 0) {
                list.add(count);    
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}