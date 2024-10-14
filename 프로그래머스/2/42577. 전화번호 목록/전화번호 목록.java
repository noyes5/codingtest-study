import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> phoneHash = new HashMap<>();
        for (String data : phone_book) {
            phoneHash.put(data, 1);
        }
        
        for (String data : phone_book) {
            String temp = "";
            for (char number : data.toCharArray()) {
                temp += number;
                
                if (phoneHash.containsKey(temp) && !temp.equals(data)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}