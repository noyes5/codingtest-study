class Solution {
    public int[] solution(String[] park, String[] routes) {
int x = 0;
        int y = 0;

        //1. park에서 시작지점을 찾는다.
        char[][] arr = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            arr[i] = park[i].toCharArray();

            if (park[i].contains("S")) {
                y = i;
                x = park[i].indexOf("S");
            }
        }

        //2. route의 요소를 읽는다.
        for (String route : routes) {
            String way = route.split(" ")[0];
            int length = Integer.parseInt(route.split(" ")[1]);

            int nowX = x;
            int nowY = y;

            for (int i = 0; i < length; i++) {
                if (way.equals("E")) {
                    nowX++;
                }
                if (way.equals("W")) {
                    nowX--;
                }
                if (way.equals("S")) {
                    nowY++;
                }
                if (way.equals("N")) {
                    nowY--;
                }
                //3. 만약 범위를 벗어나거나
                if (nowX >= 0 && nowY >= 0 && nowY < arr.length && nowX < arr[0].length) {
                    // 중간에 x가 있으면 멈춘다.
                    if (arr[nowY][nowX] == 'X') {
                        break;
                    }
                    // 그렇지 않으면 이동한다.
                    if (i == length - 1) {
                        x = nowX;
                        y = nowY;
                    }
                }
            }
        }
        //7. 모든 route요소를 다 읽었으면 result를 출력한다.
        int[] answer = {y, x};
        return answer;
    }
}