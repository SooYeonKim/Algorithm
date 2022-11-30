import java.util.*;

public class 택배상자 {
    public int solution(int[] order) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= order.length; i++) {
            q.offer(i);
        }
        
        Stack<Integer> temp = new Stack<>();
        int idx = 1;
        int answer = 0;
        while (idx <= order.length) {
            if (!temp.isEmpty() && temp.peek() == order[idx-1]) {
                temp.pop();
                idx++;
                answer++;
            } else if (!q.isEmpty() && q.peek() == order[idx-1]) {
                q.poll();
                idx++;
                answer++;
            } else if (!q.isEmpty() && order[idx-1] > q.peek()) {
                while (!q.isEmpty() && q.peek() < order[idx-1]) {
                    temp.push(q.poll());
                }
                
                if (q.peek() == order[idx-1]) {
                    q.poll();
                    idx++;
                    answer++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        
        return answer;
    }
}
