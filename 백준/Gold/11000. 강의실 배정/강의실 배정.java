import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


// 1. 강의 시작 시간 기준으로 정렬한다.
// 2. 강의 시작 시간이 앞에서 구한 끝나는 시간 이상인 것을 고른다.
// 3. 2의 과정으로 계속 붙이는데, 만약 T가 10^9를 초과하면 붙이지 않는다.
// 4. 완성되었으면 cnt +1
// 5. 1의 과정을 반복한다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] lectureTime = new int[N][2];
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            lectureTime[i][0] = Integer.parseInt(input[0]);
            lectureTime[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(lectureTime, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> endTimeQ = new PriorityQueue<>();

        for (int[] lecture : lectureTime) {
            if (!endTimeQ.isEmpty() && endTimeQ.peek() <= lecture[0]) {
                endTimeQ.poll();
            }
            endTimeQ.add(lecture[1]);
        }
        System.out.println(endTimeQ.size());
    }
}