class Solution {
    public int solution(String name) {
        // AOOOO 4번
        // OAOOO 3번
        // OOAOO 4번
        // OOOAO 4번
        // OOOOA 3번
        // AAOOO 3번
        // AOAOO 4번
        // OAAOO 2번
        // OAOAO 3번.....
        // OAOOA 3번
        // OOAAO 3번
        // OOAOA 3번
        // OOOAA 2번
        // AAAOO 2번
        // OAAAO 1번
        // OOAAA 1번
        // AAAAO 1번
        // OAAAA 0번
        int len = name.length();
        int fi = name.indexOf("A");
        int answer = 0;
        
        for (int i = 0; i < len; i++) {
            char now = name.charAt(i);
            
            int upDown = Math.min(now - 'A', 'Z' - now + 1);
            answer += upDown;  
        } 
        
        int move = len - 1;
        
        for (int i = 0; i < len; i++) {
            int next = i + 1;

            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            // i는 현재까지 이동한 거리
            // next는 A 이후 다시 바꿔야 하는 문자의 위치
            // i까지 갔다가 되돌아와서 next로 가는 경우
            int lr = i * 2 + (len - next);
            // 끝까지 갔다가 되돌아와서 i까지 다시 오는 경우
            int rl = (len - next) * 2 + i;

            move = Math.min(move, Math.min(lr, rl));
        } 

        return answer + move;
    }
}