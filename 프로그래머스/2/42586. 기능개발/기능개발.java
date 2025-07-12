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
            
            while (!waitJob.isEmpty()) {
                int now = waitJob.poll();
                now += speeds[idx++];

                progressJob.offer(now);     
            }
            
            int count = 0;
            
            while (!progressJob.isEmpty()) {
                if (progressJob.peek() < 100) {
                    waitJob = progressJob;
                    progressJob = new LinkedList<>();
                    break;
                }
                
                int now = progressJob.poll();
                
                if (now >= 100) {
                    count++;
                    completedJob.add(now);
                    startIdx++;
                }
            }
            
            if (count != 0) {
                list.add(count);    
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}