package basic;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
        int index = 0;
        int temp = 0;
        for (int i = 0; i < 10; i++) {
            int min = 9999;
            for (int j = i; j < 10; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", array[i]);
        }
    }

}
