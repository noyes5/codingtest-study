
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] keypad = {{3, 1}, {0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};

        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftPos = keypad[num];
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightPos = keypad[num];
            } else {
                int[] target = keypad[num];
                int lDist = Math.abs(leftPos[0] - target[0]) + Math.abs(leftPos[1] - target[1]);
                int rDist = Math.abs(rightPos[0] - target[0]) + Math.abs(rightPos[1] - target[1]);
                
                if (lDist < rDist) {
                    answer.append("L");
                    leftPos = target;
                } else if (rDist < lDist) {
                    answer.append("R");
                    rightPos = target;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = target;
                    } else {
                        answer.append("R");
                        rightPos = target;
                    }
                }
            }
        }
    
        return answer.toString();
    }
}