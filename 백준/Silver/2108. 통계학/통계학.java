import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers.add(num);
            sum += num;
        }

        double average = (double) sum / N;

        Collections.sort(numbers);
        int median = numbers.get(N / 2);

        Map<Integer, Integer> fre = new HashMap<>();
        for (int num : numbers) {
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }

        int highestFrequency = Collections.max(fre.values());
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {
            if (entry.getValue() == highestFrequency) {
                modes.add(entry.getKey());
            }
        }

        int secondSmallestMode = 0;
        if (modes.size() > 1) {
            Collections.sort(modes);
            secondSmallestMode = modes.get(1);
        } else {
            secondSmallestMode = modes.get(0);
        }

        int rangeValue = Collections.max(numbers) - Collections.min(numbers);

        System.out.println((int) Math.round(average));
        System.out.println(median);
        System.out.println(secondSmallestMode);
        System.out.println(rangeValue);
    }
}