import java.util.*;

public class 가장_가까운_같은_글자 {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = map.getOrDefault(c, -1);
            
            if (value == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - value;
            }
            
            map.put(c, i);
        }
        
        return answer;
    }
}
