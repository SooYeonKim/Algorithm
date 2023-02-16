import java.util.*;

public class 압축_2 {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put("" + (char)('A' + i), i + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while (idx < msg.length()) {
            int temp = idx + 1;
            while (temp <= msg.length() && map.containsKey(msg.substring(idx, temp))) {
                temp++;
            }
            
            list.add(map.get(msg.substring(idx, temp - 1)));
            if (temp <= msg.length()) {
                map.put(msg.substring(idx, temp), map.size() + 1);
            }
            
            idx = temp - 1;
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
