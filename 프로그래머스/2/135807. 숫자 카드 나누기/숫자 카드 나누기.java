class Solution {
    
    private int getArrGcd(int[] arr) {
        int gcd = arr[0];
        for (int i = 0; i < arr.length; i++) {
            gcd = getGcd(gcd, arr[i]);
        }
        
        return gcd;
    }
    
    private int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    private boolean valid(int a, int[] other) {
        for (int o : other) {
            if (o % a == 0) {
                return false;
            }
        }
        return true;
    }
    

    public int solution(int[] arrayA, int[] arrayB) {
        int gA = getArrGcd(arrayA);
        int gB = getArrGcd(arrayB);
        
        int answer = 0;
        
        if (valid(gA, arrayB)) {
            answer = Math.max(answer, gA);
        }
        if (valid(gB, arrayA)) {
            answer = Math.max(answer, gB);
        }
        
        return answer;
    }
}