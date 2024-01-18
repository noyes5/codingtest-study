import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


// 1. 강의 시작 시간 기준으로 배열을 정렬한다.
// 2. 강의 종료시간을 담을 우선순위 큐를 만든다.
// 3. 배열을 순회한다.
// 4. 큐가 비어있으면 꺼낸 배열의 강의 종료시간 값을 넣는다.
// 4-1. 만약 비어있지 않으면 peek하여 배열의 시작시간 >= 종료시간인 경우 poll한다.
// 5. 꺼낸 배열의 종료시간을 add한다.
// 3의 과정을 반복한다음 큐의 크기를 구하면 답.
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