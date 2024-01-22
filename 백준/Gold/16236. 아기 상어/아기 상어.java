import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Position {
    int x;
    int y;
    int time;

    public Position(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Position shark = findShark();

        int size = 2;
        int eat = 0;
        int move = 0;

        while (true) {
            PriorityQueue<Position> q = new PriorityQueue<>((a, b) -> {
                if (a.time != b.time) {
                    return Integer.compare(a.time, b.time);
                } else if (a.x != b.x) {
                    return Integer.compare(a.x, b.x);
                } else {
                    return Integer.compare(a.y, b.y);
                }
            });

            boolean[][] visited = new boolean[n][n];

            q.add(new Position(shark.x, shark.y, 0)); 
            visited[shark.x][shark.y] = true;

            boolean chk = false;  // 상어가 물고기 먹었는지 확인

            while (!q.isEmpty()) {
                Position cur = q.poll();
                int x = cur.x;
                int y = cur.y;

                if (board[x][y] > 0 && board[x][y] < size) {
                    board[x][y] = 0;
                    eat++;
                    move += cur.time;
                    shark = new Position(x, y, 0);
                    chk = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || board[nx][ny] > size) {
                        continue;
                    }

                    q.add(new Position(nx, ny, cur.time + 1));
                    visited[nx][ny] = true;
                }
            }

            if (!chk) {
                break;
            }

            if (size == eat) { 
                size++;
                eat = 0;
            }
        }

        System.out.println(move);

    }

    public static Position findShark() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 9) {
                    board[i][j] = 0;
                    return new Position(i, j, 0);
                }
            }
        }
        return null;
    }
}