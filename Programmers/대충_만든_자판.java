import java.util.*;

public class 대충_만든_자판 {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if (map.containsKey(keymap[i].charAt(j))) {
                    map.put(keymap[i].charAt(j), Math.min(map.get(keymap[i].charAt(j)), j + 1));
                } else {
                    map.put(keymap[i].charAt(j), j + 1);
                }
            }
        }
        
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            boolean flag = true;
            int result = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                if (!map.containsKey(targets[i].charAt(j))) {
                    flag = false;
                    break;
                }
                
                result += map.get(targets[i].charAt(j));
            }
            
            if (flag) answer[i] = result;
            else answer[i] = -1;
        }
        
        return answer;
    }
}
