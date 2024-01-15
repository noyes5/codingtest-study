import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int r;
    static int l;
    static int pl;

    // 1. 미세먼지는 4방향으로 퍼진다.
    // 2. 퍼지는 방향은 최소 2부터 4방향이다. 퍼질 때 주의할 것이 다른 배열의 값을 먼저 바꾸면 안됨.
    // 3. dx,dy 탐색으로 dfs 방식으로 탐색을 하여 미세먼지를 모두 퍼트린다.
    // 4. 방문 표시를 통해서 미세먼지를 퍼트릴지, 더할지 정한다.
    // 5. 미세먼지가 다 퍼졌으면 공기청정기로 바람을 이동시킨다.
    // 6. 위쪽방향은 반시계, 아래쪽 방향은 시계방향. 공청기에 들어온 먼지는 0으로 처리. 공청기 기준으로 바람의 역순으로 처리하는게 좋겠다.
    // 7. 최종 그래프를 출력한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        graph = new int[r][l];
        visited = new boolean[r][l];

        // 그래프 초기화
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < l; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == -1) {
                    pl = i;
                }
            }
        }


        while (t-- > 0) {
            spreadDust();
            purify();
        }

        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                count += graph[i][j];
            }
        }
        System.out.println(count + 2);
    }

    public static void spreadDust() {
        int[][] tempGraph = new int[r][l];

        for (int x = 0; x < r; x++) {
            for (int y = 0; y < l; y++) {
                int curDust = graph[x][y];

                if (curDust > 0) {
                    int spreadAmount = curDust / 5;
                    int count = 0;

                    for (int i = 0; i < 4; i++) {
                        int newX = x + dx[i];
                        int newY = y + dy[i];

                        if (canGo(newX, newY)) {
                            tempGraph[newX][newY] += spreadAmount;
                            count++;
                        }
                    }
                    tempGraph[x][y] += curDust - spreadAmount * count;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < l; j++) {
                if (graph[i][j] != -1) {
                    graph[i][j] = tempGraph[i][j];
                }
            }
        }

    }

    public static boolean canGo(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < r && dy < l && graph[dx][dy] != -1;
    }

    public static void purify() {

        for (int i = pl - 3; i >= 0; i--) {
            graph[i + 1][0] = graph[i][0];
        }
        for (int i = 0; i < l - 1; i++) {
            graph[0][i] = graph[0][i + 1];
        }
        for (int i = 0; i <= pl - 1; i++) {
            graph[i][l - 1] = graph[i + 1][l - 1];
        }
        for (int i = l - 2; i >= 1; i--) {
            graph[pl - 1][i + 1] = graph[pl - 1][i];
        }
        graph[pl - 1][1] = 0;

        for (int i = pl + 1; i < r - 1; i++) {
            graph[i][0] = graph[i + 1][0];
        }
        for (int i = 0; i < l - 1; i++) {
            graph[r - 1][i] = graph[r - 1][i + 1];
        }
        for (int i = r - 2; i >= pl; i--) {
            graph[i + 1][l - 1] = graph[i][l - 1];
        }
        for (int i = l - 2; i >= 1; i--) {
            graph[pl][i + 1] = graph[pl][i];
        }
        graph[pl][1] = 0;
    }
}