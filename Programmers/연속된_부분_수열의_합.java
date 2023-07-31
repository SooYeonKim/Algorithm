import java.util.*;

public class 연속된_부분_수열의_합 {
    public int[] solution(int[] sequence, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = 0;
        int sum = 0;
        boolean flag = false;
        int[] answer = new int[2];

        for (int i = 0; i < sequence.length; i++) {
            pq.offer(sequence[i]);
            sum += sequence[i];
            
            while (sum > k) {
                start++;
                sum -= pq.poll();
            }
            
            if (sum == k) {
                if (flag) {
                    if (answer[1] - answer[0] > pq.size() - 1) {
                        answer[0] = start;
                        answer[1] = start + pq.size() - 1;
                    }
                } else {
                    flag = true;
                    answer[0] = start;
                    answer[1] = start + pq.size() - 1;
                }
            }
        }
        
        return answer;
    }
}
