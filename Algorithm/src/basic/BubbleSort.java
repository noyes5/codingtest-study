package basic;
// 구현하기 가장 쉽지만 가장 효율이 떨어지는 알고리즘

// 선택정렬도 n^2 이고 버블정렬도 n^2 인데 버블정렬이 더 오래 걸리는 이유는
// counting을 할 떄마다 바꾸는 연산을 계속 하기 때문이다.
// (선택정렬은 가장 작은 값을 찾아 마지막에만 연산)
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
        int index = 0;
        int temp = 0;
        
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < 9 - i; j++) {
                if(array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", array[i]);
        }
    }
    
    
}
