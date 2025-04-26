import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[][] room;
    static int cnt = 0;
    
    // 북 동 남 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        room = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        clean(x, y, d);
        
        System.out.println(cnt);       
    }
    
    static void clean(int x, int y, int d) {
        if (room[x][y] == 0) {
            room[x][y] = 2;
            cnt++;
        }
        
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0) {
                clean(nx, ny, d);
                return;
            }
        }
        
        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        
        if (bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] != 1) {
                clean(bx, by, d);
        }
    }
}