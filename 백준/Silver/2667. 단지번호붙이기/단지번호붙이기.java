import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static int n;
    private static int[][] arr;
    private static boolean[][] visited;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    cnt = 1;
                    dfs(i, j);
                    ans.add(cnt);
                }
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int data : ans) {
            System.out.println(data);
        }
    }

    // dfs에서는 visit만 계산
    public static void dfs(int x, int y) {
        int[] dxs = {-1, 0, 1, 0};
        int[] dys = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            int nx = x + dxs[d];
            int ny = y + dys[d];

            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                cnt++;
                dfs(nx, ny);
            }
        }
    }

    public static boolean canGo(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1 && !visited[nx][ny];
    }
}
