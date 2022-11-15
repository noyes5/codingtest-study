import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		
		//
		List<Integer> numberArray = new ArrayList<>();
		
		for (int i = 0;i < N; i++) {
			numberArray.add(sc.nextInt());
		}
		
		Collections.sort(numberArray);

		for (int number : numberArray) {
			sb.append(number).append("\n");
		}
		System.out.println(sb);
	}
}