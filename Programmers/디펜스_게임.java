import java.util.*;

public class 디펜스_게임 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] > n) {
                if (k > 0) {
                    k--;
                    if (!pq.isEmpty() && enemy[i] < pq.peek()) {
                        pq.offer(enemy[i]);
                        n = n - enemy[i] + pq.poll();
                    }
                } else {
                    break;
                }
            } else {
                n -= enemy[i];
                pq.offer(enemy[i]);
            }
            
            answer++;
        }
        
        return answer;
    }
}
