import java.util.*;

public class 할인_행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        int answer = 0;
        int cnt = 10;
        for (int i = 0; i < 10; i++) {
            String goods = discount[i];
            if (map.containsKey(goods)) {
                map.put(goods, map.get(goods) - 1);
                if (map.get(goods) >= 0) cnt--;
            }
        }
        if (cnt == 0) answer++;
        
        if (discount.length > 10) {
            for (int i = 10; i < discount.length; i++) {
                String prev = discount[i-10];
                if (map.containsKey(prev)) {
                    map.put(prev, map.get(prev) + 1);
                    if (map.get(prev) > 0) cnt++;
                }
                
                String goods = discount[i];
                if (map.containsKey(goods)) {
                    map.put(goods, map.get(goods) - 1);
                    if (map.get(goods) >= 0) cnt--;
                }
                
                if (cnt == 0) answer++;
            }
        }
        
        return answer;
    }
}
