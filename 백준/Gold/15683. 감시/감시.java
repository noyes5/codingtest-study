import java.io.*;
import java.util.*;

public class Main {
    static class Cctv {
        int x;
        int y;
        int cctvNum;

        Cctv(int x, int y, int cctvNum) {
            this.x = x;
            this.y = y;
            this.cctvNum = cctvNum;
        }
    }

    static int[] dx = {0, -1, 0, 1};  // 좌, 상, 우, 하
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board;
    static int[][] tempBoard;
    static int N;
    static int M;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        List<Cctv> cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6) {
                    cctvs.add(new Cctv(i, j, board[i][j]));
                }
            }
        }
        dfs(0, board, cctvs);
        System.out.println(min);
    }

    static void dfs(int index, int[][] board, List<Cctv> cctvs) {
        if (index == cctvs.size()) {
            min = Math.min(min, countUnwatched(board));
            return;
        }

        Cctv cctv = cctvs.get(index);
        tempBoard = new int[N][M];

        if (cctv.cctvNum == 1) {
            for (int dir = 0; dir < 4; dir++) {
                tempBoard = copyMap(board);
                fill(dir, cctv.x, cctv.y);
                dfs(index + 1, tempBoard, cctvs);
            }
        } else if (cctv.cctvNum == 2) {
            for (int dir = 0; dir < 2; dir++) {
                tempBoard = copyMap(board);
                fill(dir, cctv.x, cctv.y);
                fill(dir + 2, cctv.x, cctv.y);
                dfs(index + 1, tempBoard, cctvs);
            }
        } else if (cctv.cctvNum == 3) {
            for (int dir = 0; dir < 4; dir++) {
                tempBoard = copyMap(board);
                fill(dir, cctv.x, cctv.y);
                fill(dir + 1, cctv.x, cctv.y);
                dfs(index + 1, tempBoard, cctvs);
            }
        } else if (cctv.cctvNum == 4) {
            for (int dir = 0; dir < 4; dir++) {
                tempBoard = copyMap(board);
                fill(dir, cctv.x, cctv.y);
                fill(dir + 1, cctv.x, cctv.y);
                fill(dir + 2, cctv.x, cctv.y);
                dfs(index + 1, tempBoard, cctvs);
            }
        } else if (cctv.cctvNum == 5) {
            tempBoard = copyMap(board); // 4방향 모두 처리
            for (int dir = 0; dir < 4; dir++) {
                fill(dir, cctv.x, cctv.y);
            }
            dfs(index + 1, tempBoard, cctvs);
        }
    }

    static void fill(int dir, int x, int y) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || x >= N || y < 0 || y >= M || tempBoard[x][y] == 6) {
                break;
            }

            if (tempBoard[x][y] == 0) {
                tempBoard[x][y] = -1;
            }
        }
    }

    static int countUnwatched(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static int[][] copyMap(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }
}
