import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[length];
    
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int left = 0;
        int right = length - 1;
        int resultLeft = 0;
        int resultRight = 0;
        int minSum = Integer.MAX_VALUE;
    
        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum);
            
            if (diff < minSum) {
                minSum = diff;
                resultLeft = left;
                resultRight = right;
            }
            if (sum > 0) {
                right--;
            } else {
                left++;    
            }
        }
        System.out.printf("%d %d", arr[resultLeft], arr[resultRight]);
    }
}