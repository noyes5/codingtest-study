import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	int n;
		do {
			int cnt = 0;
			n = sc.nextInt();
			if(n == 0) {
				break;
			}
			for(int i=n+1;i<=2*n;i++) {
				boolean isPrime = true;
				
				if(1 == i) {
					continue;
				}
				
				for(int j=2;j<=Math.sqrt(i);j++) {
					if(i%j == 0) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) {
					cnt++;
				}
			}
			System.out.println(cnt);
    	} while(n != 0);
    	
    	
    }
}