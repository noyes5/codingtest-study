import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        int nanMAX1 = 0;
        int nanMAX2 = 0;
        
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        List<Integer> dataOri = Arrays.stream(arr)
                                    .boxed()
                                    .collect(Collectors.toList());
        
        for (int i = 0; i < dataOri.size() - 1; i++) {
            for (int j = i + 1; j < dataOri.size(); j++) {
                if (sum - dataOri.get(i) -  dataOri.get(j) == 100) {
                    nanMAX1 = i; 
                    nanMAX2 = j; 
                    break;
                } 
            }
        }
        
        for (int i = 0; i < dataOri.size(); i++) {
            if (i == nanMAX1 || i == nanMAX2) {
                continue;
            } 
            System.out.println(dataOri.get(i));
        }
    }
}