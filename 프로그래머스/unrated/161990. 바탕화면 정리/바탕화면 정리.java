class Solution {
    public int[] solution(String[] wallpaper) {
        int sizeX = wallpaper.length;
        int sizeY = wallpaper[0].length();
        int minX = sizeX;
        int minY = sizeY;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < sizeX; i++) {
            int a = i;
            int b = wallpaper[i].indexOf("#"); 
            int c = wallpaper[i].lastIndexOf("#");
           
            if (b != -1) {
                if (minX > a) {
                    minX = a;
                }
                if (minY > b) {
                    minY = b;
                }    
            }
            if (c != -1) {
                if (maxX < a + 1) {
                    maxX = a + 1;
                }
                if (maxY < c + 1) {
                    maxY = c + 1;
                }
            }
        }
        int[] result = {minX, minY, maxX, maxY};
        return result;
    }
    
}