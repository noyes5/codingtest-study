import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        int idx = 0;
        int time = 0;
        int totalWeight = 0;
        while (!bridge.isEmpty()) {
            time++;
            
            totalWeight -= bridge.poll();
            
            if (idx < truck_weights.length) {
                if (totalWeight + truck_weights[idx] <= weight) {
                    bridge.add(truck_weights[idx]);
                    totalWeight += truck_weights[idx];
                    idx++;
                } else {
                    bridge.add(0);
                }
            }
        }
        return time;
    }
}