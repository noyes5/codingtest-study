class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c = (char) ((c - 'A' + n) % 26 + 'A');
            }
            
            if (c >= 'a' && c <= 'z') {
                c = (char) ((c - 'a' + n) % 26 + 'a');
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}