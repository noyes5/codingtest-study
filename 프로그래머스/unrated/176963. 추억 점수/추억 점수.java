import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {        
        // 스트림을 사용하여 배열을 맵으로 변환
        Map<String, Integer> nameMap = IntStream.range(0, yearning.length)
                .boxed()
                .collect(Collectors.toMap(i -> name[i], i -> yearning[i]));
        
        // 짧은 배열 길이 이후에 대해 0으로 값을 할당
        IntStream.range(yearning.length, name.length)
                .forEach(i -> nameMap.put(name[i], 0));
  
        // photo 배열을 맵의 key와 비교하여 점수로 바꾸고 더함
       int[] result = Arrays.stream(photo)
            .mapToInt(array -> Arrays.stream(array)
                    .mapToInt(value -> nameMap.getOrDefault(value, 0))
                    .sum())
            .toArray(); 
        
        return result;
    }
}