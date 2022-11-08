import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int scoreIdx = sc.nextInt();
		
		Integer[] studentScore = new Integer[N];
		
		for (int i = 0;i < N; i++) {
			studentScore[i] = sc.nextInt(); 
		}
		
		Arrays.sort(studentScore, Collections.reverseOrder());
		
		System.out.println(studentScore[scoreIdx-1]);		
		
	}
}