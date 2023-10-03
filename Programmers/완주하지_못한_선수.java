import java.util.*;

public class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for (int i = 0; i < completion.length; i++) {
            if (map.get(completion[i]) >= 2) {
                map.put(completion[i], map.get(completion[i]) - 1);
            } else {
                map.remove(completion[i]);
            }
        }
        
        String answer = "";
        for (String str : map.keySet()) {
            answer = str;
        }
        return answer;
    }
}
