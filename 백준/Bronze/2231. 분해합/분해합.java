import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 방법 1
        String input = br.readLine();
        int N = Integer.parseInt(input);
        
        int result = 0;
//        for (int i = 0; i < N; i++) {
//            int number = i;
//            int sum = 0;
//            
//            while (number != 0) {
//                sum += number % 10;
//                number /= 10;
//            }
//            
//            if (sum + i == N) {
//                result = i;
//                break;
//            }
        
//        System.out.println(result);
//        }
        
        // 방법 2
        int len = input.length();

        for (int i = N - len * 9; i < N; i++) {
            int number = i;
            int sum = 0;
              
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }
            
            if (sum + i == N) {
                result = i;
                break;
            }
            
        }
        System.out.println(result);
    }
}