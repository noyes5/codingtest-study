class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int stand = prices[i];
            int count = 0;
            for (int j = i + 1; j < N; j++) {
                count++;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}