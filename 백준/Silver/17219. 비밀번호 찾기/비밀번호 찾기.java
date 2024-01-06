import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int saveSiteSize = Integer.parseInt(st.nextToken());
        int showSiteSize = Integer.parseInt(st.nextToken());
        
        Map<String, String> map = new HashMap<>();
        
        while (saveSiteSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }
        
        while (showSiteSize-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(map.getOrDefault(st.nextToken(),"none"))
                .append("\n");
        }
        
        System.out.println(sb);
    }
}