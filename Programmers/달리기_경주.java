import java.util.*;

public class 달리기_경주 {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            answer[i] = players[i];
            map.put(players[i], i);
        }
        
        for (int i = 0; i < callings.length; i++) {
            String str1 = callings[i];
            int p1 = map.get(str1);
            String str2 = answer[p1 - 1];
            int p2 = p1 - 1;
            
            answer[p1] = str2;
            answer[p2] = str1;
            map.put(str1, p2);
            map.put(str2, p1);
        }
        
        return answer;
    }
}
