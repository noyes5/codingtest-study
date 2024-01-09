import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<String> inCars = new LinkedList<>();
        Queue<String> outCars = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            inCars.offer(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            outCars.offer(br.readLine());
        }

        int count = 0;

        while (!outCars.isEmpty()) {
            String outCar = outCars.poll();

            if (inCars.peek().equals(outCar)) {
                inCars.poll(); 
            } else {
                count++;
                removeCar(inCars, outCar);
            }
        }

        System.out.println(count);
    }
    
    private static void removeCar(Queue<String> queue, String car) {
        Queue<String> temp = new LinkedList<>();
        while (!queue.isEmpty()) {
            String currentCar = queue.poll();
            if (!currentCar.equals(car)) {
                temp.offer(currentCar);
            }
        }
        queue.addAll(temp);
    }
}