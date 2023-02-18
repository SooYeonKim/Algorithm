import java.util.*;

public class 카드_뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        for (int i = 0; i < cards1.length; i++) {
            q1.offer(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            q2.offer(cards2[i]);
        }
        
        String answer = "Yes";
        for (int i = 0; i < goal.length; i++) {
            if (!q1.isEmpty() && q1.peek().equals(goal[i])) {
                q1.poll();
            } else if (!q2.isEmpty() && q2.peek().equals(goal[i])) {
                q2.poll();
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}
