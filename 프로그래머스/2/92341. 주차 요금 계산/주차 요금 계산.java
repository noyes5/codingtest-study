import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, Integer> carInTime = new HashMap<>();
        Map<String, Integer> carTime = new HashMap<>();
        Set<String> cars = new HashSet<>();
        
        int defaultTime = fees[0];
        int defaultFee = fees[1];
        int time = fees[2];
        int extraFee = fees[3];
        
        for (String record : records) {
            String[] recordArr = record.split(" ");
            String cTime = recordArr[0];
            String carNum = recordArr[1];
            String type = recordArr[2];
            
            String[] times = cTime.split(":"); 
            
            int h = Integer.parseInt(times[0]);
            int m = Integer.parseInt(times[1]);
            int timeToMinute = h * 60 + m;
            
            if (type.equals("IN")) {
                cars.add(carNum);
                carInTime.put(carNum, timeToMinute);
            }
            
            if (type.equals("OUT")) {
                cars.remove(carNum);
                int diffTime = timeToMinute - carInTime.get(carNum);
                carTime.put(carNum, carTime.getOrDefault(carNum, 0) + diffTime);
            }           
        }
        
        for (String carNum : cars) {
            carTime.put(carNum, carTime.getOrDefault(carNum, 0) + (23 * 60 + 59 - carInTime.get(carNum)));

        }
        
        List<Integer> answer = new ArrayList<>();
        
        for (String carNum : carTime.keySet()) {
            int totalTime = carTime.get(carNum);
            int totalFee = 0;
            
            totalFee += defaultFee;
            
            int finalTime = totalTime - defaultTime;
            int extraFeeTime = 0;
            if (finalTime % time != 0) {
                extraFeeTime += 1;
            }
            extraFeeTime += (finalTime / time);
            totalFee += extraFeeTime * extraFee;
            
            answer.add(totalFee);
        }
        
        int N = answer.size();
        int[] answers = new int[N]; 
        
        for (int i = 0; i < answer.size(); i++) {
            answers[i] = answer.get(i);
        }
        
        return answers;
    }
}   