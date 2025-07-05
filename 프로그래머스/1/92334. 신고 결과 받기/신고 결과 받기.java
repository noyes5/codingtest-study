import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> userReportMap = new HashMap<>();
        Map<String, Set<String>> reportedMap = new HashMap<>();
        
        for (String id : id_list) {
            userReportMap.put(id, new HashSet<>());
            reportedMap.put(id, new HashSet<>());
        }
        
        
        for (String reportInfo : report) {
            String[] reportArr = reportInfo.split(" ");
            String reportUser = reportArr[0];
            String reportedUser = reportArr[1];
            
            userReportMap.get(reportUser).add(reportedUser);
            reportedMap.get(reportedUser).add(reportUser);
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < id_list.length; i++) {
            // report user의 key값으로 set을 만듬
            // set에는 신고당한 리스트가 들어있음
            Set<String> set = userReportMap.get(id_list[i]);
            int count = 0;
            for (String reportedUser : set) {
                if (reportedMap.get(reportedUser).size() >= k) {
                    count++;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}