import java.util.*;
import java.io.*;

class Solution {
    
    static int m, n;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] maps) {
        m = maps.length;
        n = maps[0].length;
        
        boolean[][] visited = new boolean[m][n];      
        Queue<int[]> q = new LinkedList<>();
    
        q.add(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 ||  ny >= n || maps[nx][ny] == 0) {
                    continue;
                }
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                maps[nx][ny] = maps[x][y] + 1;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return maps[m - 1][n - 1] == 1 ? -1 : maps[m - 1][n - 1];        
    }
}