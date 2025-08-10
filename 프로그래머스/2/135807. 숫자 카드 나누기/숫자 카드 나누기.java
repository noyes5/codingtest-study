class Solution {
    
    private int arrGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        
        return result;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }
    
    private boolean valid(int g, int[] other) {
        for (int x : other) {
            if (x % g == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    public int solution(int[] arrayA, int[] arrayB) {
        int gA = arrGcd(arrayA);
        int gB = arrGcd(arrayB);
        
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