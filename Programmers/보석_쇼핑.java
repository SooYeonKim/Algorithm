import java.util.*;

public class 보석_쇼핑 {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        int result = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for (int i = 0; i < gems.length; i++) {
            String str = gems[i];
            q.offer(str);
            map.put(str, map.getOrDefault(str, 0) + 1);
            
            while (map.get(q.peek()) > 1) {
                map.put(q.peek(), map.get(q.peek()) - 1);
                q.poll();
                idx++;
            }
            
            if (map.size() == set.size()) {
                if (result > i - idx + 1) {
                    result = i - idx + 1;
                    answer[0] = idx + 1;
                    answer[1] = i + 1;
                }
            }
        }
        
        return answer;
    }
}
