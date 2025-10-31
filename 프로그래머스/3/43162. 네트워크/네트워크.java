import java.util.*;

class Solution {
    static int[][] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                count++;
            }
        }
        
        return count;
    }   
    
    private void dfs(int cur, int[][] computers) {
        visited[cur] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[cur][i] == 1 && !visited[i]) {
                dfs(i, computers);
            }
        }
    }
}
    
//     // BFS 풀이
//     // private void bfs(int start, int[][] computers) {
//         Deque<Integer> q = new ArrayDeque<>();
//         q.offer(start);
//         visited[start] = true;
        
//         while (!q.isEmpty()) {
//             int cur = q.poll();
//             for (int i = 0; i < computers.length; i++) {
//                 if (computers[cur][i] == 1 && !visited[i]) {
//                     q.offer(i);
//                     visited[i] = true;
//                 }
//             }
//         }
//     }


    
//     // DFS -> 깊이로 들어가서 트리 노드를 visited true 로 바꿔주는게 핵심
//     private void dfs(int cur, int[][] computers) {
//         visited[cur] = true;
        
//         for (int i = 0; i < computers.length; i++) {
//             if (computers[cur][i] == 1 && !visited[i]) {
//                 dfs(i, computers);
//             }
//         }
//     }
// }