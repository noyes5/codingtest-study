import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] dx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] dy = {1, -1, 2, -2, -2, 2, -1, 1};
    static int n;
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int reachX = Integer.parseInt(st.nextToken());
            int reachY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(x, y, reachX, reachY));
        }
    }

    public static int bfs(int x, int y, int reachX, int reachY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        board[x][y] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (curX == reachX && curY == reachY) {
                return board[curX][curY] - 1;
            }
            for (int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (canMove(nx, ny)) {
                    q.add(new int[]{nx, ny});
                    board[nx][ny] = board[curX][curY] + 1;
                }
            }
        }
        return -1;
    }

    public static boolean canMove(int x, int y) {
        return x >= 0 && y >= 0 && x < l && y < l && board[x][y] == 0;
    }
}