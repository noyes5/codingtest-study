import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] sb = new StringBuilder[201];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < 201; i++) {
            sb[i] = new StringBuilder();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            sb[age].append(age).append(" ").append(st.nextToken()).append("\n");
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder temp : sb) {
            result.append(temp);
        }
        System.out.println(result);
    }
}
