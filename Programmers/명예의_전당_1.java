import java.util.*;

public class 명예의_전당_1 {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            pq.offer(score[i]);
            if (pq.size() > k) pq.poll();
            
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}
