import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static char[][] swap(char[][] arr, int i, int j) {
        char temp = arr[i][j+1];
        arr[i][j+1] = arr[i][j];
        arr[i][j] = temp;
        return arr;
    }

    public static int count(char[][] originArr) {
        int lengthMax = 1;
        for (int i = 0; i < originArr.length; i++) {
            int count = 1;
            for (int j = 0; j < originArr[i].length - 1; j++) {
                if (originArr[i][j] == originArr[i][j + 1]) {
                    count++;
                    if (lengthMax <= count) {
                        lengthMax = count;
                    }                    
                } else {
                    count = 1;
                }
            }
        }
        return lengthMax;
    }

    public static char[][] rotate(char[][] originArr) {
        int N = originArr.length;
        int M = N;
                
        char[][] changeArr = new char[M][N];

        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr[i].length; j++) {
                changeArr[j][i] = originArr[i][j];
            }
        }

        return changeArr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 초기화
        char[][] array = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                array[i][j] = line.charAt(j);
            }
        }

        int answer = 0;
        int answerMax = 0;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                swap(array, i, j);
                answer = count(array);
                char[][] rotateArr = rotate(array);
                int rotateAnswer = count(rotateArr);
                if (answerMax < answer) {
                    answerMax = answer;
                }
                if (answerMax < rotateAnswer) {
                    answerMax = rotateAnswer;
                }
                array = rotate(rotateArr);
                swap(array, i, j);
            }
        }

        char[][] changeArray = rotate(array);

        int answer2 = 0;
        int answerMax2 = 0;
        for (int i = 0; i < changeArray.length; i++) {
            for (int j = 0; j < changeArray[i].length - 1; j++) {
                swap(changeArray, i, j);
                answer2 = count(changeArray);
                char[][] rotateArr = rotate(changeArray);
                int rotateAnswer = count(rotateArr);
                
                if (answerMax2 < answer2) {
                    answerMax2 = answer2;
                }
                if (answerMax2 < rotateAnswer) {
                    answerMax2 = rotateAnswer;
                }
                changeArray = rotate(rotateArr);
                swap(changeArray, i, j);
            }
        }
       

        if (answerMax < answerMax2) {
            answerMax = answerMax2;
        }

        System.out.println(answerMax);
    }
}