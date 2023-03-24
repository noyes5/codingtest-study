package basic;
// 반복문 안에 반복문이 있으므로 O(n^2)형태이고, 매우느린 알고리즘
// 정렬이 되어있으면 연산을 한번만 하게되므로 먼저 정렬이 되어 있으면 효율적이다.
public class InsertSort {
    public static void main(String[] args) {
        int[] array = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
        int index = 0;
        int temp = 0;
        int j = 0;
        
        for(int i = 0; i < array.length - 1; i++) {
            j = i;
            while (j >= 0 && array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    j--;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", array[i]);
        }
    }
}
