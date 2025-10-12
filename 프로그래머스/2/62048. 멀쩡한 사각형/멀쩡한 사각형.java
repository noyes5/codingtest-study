class Solution {
    public long solution(int w, int h) {
        // ** w와 h를 각각 최대공약수로 나눈 크기만큼의 대각선이 최대공약수만큼 반복된다.
        // 1. w와 h를 각각 최대공약수로 나눈다.   
        // 예시에서 w = 8, h = 12 이므로 최대공약수는 4 
        // [w' = 2, h' = 3인 사각형] 이 * 4번 반복되는 구조다.
        
        // 2. w' * h' 로된 사각형에서 대각선은 (h' - 1)개의 가로선과 (w' - 1)개의 세로선을 만난다(처음과 끝점 제외)
        // 만나는 선 = 사용할수 없는 사각형이 된다.
        // 처음 사각형을 포함해야 하므로 w' * h' 에서 사용할수 없는 사각형 = (w' - 1) + (h' - 1) + 1
        // = w' + h' - 1
        
        // 3. 이것이 최대공약수만큼 반복되어야 하므로 최대공약수가 필요하겠지...
        // (w' + h' - 1) * gcd = w'*gcd + h'gcd - gcd...
        // = w + h - gcd가 된다.(;;)
        
        // 4. (X) return w * h - (w + h - getGcd(w, h)); 로 하니까 귀신같이 실패
        // 역시 w * h 에서 Integer 오버플로가 난다.
        
        long total = (long) w * (long) h;
        long sub = (long) w + (long) h - getGcd(w,h);
        
        return total - sub;
    }
    
    // 유클리드 호제법
    private int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b; 
            a = b;
            b = temp;
        }
        return a;
    }
}