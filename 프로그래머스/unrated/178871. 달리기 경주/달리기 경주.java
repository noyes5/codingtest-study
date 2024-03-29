import java.util.*;
import java.util.stream.*;

public class Solution {
    private static Map<String, Integer> playerInfo = new HashMap<>();

    public String[] solution(String[] players, String[] callings) {
        currentRanking(players);
	    
	    Arrays.stream(callings).forEach(player -> {
	    	int idx = playerInfo.get(player);
	    	String frontPlayer = players[idx - 1];
	    	players[idx] = frontPlayer;
	    	players[idx - 1] = player;
	    	
	    	playerInfo.put(frontPlayer, idx);
	    	playerInfo.put(player, idx -1);
	    });
	    
	    return players;
	}
	
	private static void currentRanking(String[] players) {
		IntStream.range(0, players.length).forEach(index -> {
			playerInfo.put(players[index], index);
		});
	}
}