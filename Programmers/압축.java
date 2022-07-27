import java.util.*;

public class 압축 {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < 26; i++) {
            char c = (char)('A' + i);
            map.put("" + c, idx++);
        }
        
        List<Integer> list = new ArrayList<>();
        String temp = "" + msg.charAt(0);
        for (int i = 1; i < msg.length(); i++) {
            if (map.containsKey(temp + msg.charAt(i))) {
                temp += msg.charAt(i);
                continue;
            }
            
            list.add(map.get(temp));
            map.put(temp + msg.charAt(i), idx++);
            temp = "" + msg.charAt(i);
        }
        list.add(map.get(temp));
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
