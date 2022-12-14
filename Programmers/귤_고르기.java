import java.util.*;

public class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int s = tangerine[i];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (Integer s : map.keySet()) {
            list.add(map.get(s));
        }
        
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        int answer = 0;
        int cnt = 0;
        for (int s : list) {
            answer++;
            cnt += s;
            
            if (cnt >= k) break;
        }
        
        return answer;
    }
}
