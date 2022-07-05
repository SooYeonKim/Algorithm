import java.util.*;

public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < cities.length; i++) {
            String str = cities[i].toLowerCase();
            if (!q.isEmpty() && q.contains(str)) {
                q.remove(str);
                q.offer(str);
                answer++;
            } else {
                if (q.size() < cacheSize) {
                    q.offer(str);
                } else if (cacheSize != 0) {
                    q.poll();
                    q.offer(str);
                }
                
                answer += 5;
            }
        }

        return answer;
    }
}
