import java.util.*;

public class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < timetable.length; i++) {
            String[] sArray = timetable[i].split(":");
            int time = Integer.parseInt(sArray[0]) * 60 + Integer.parseInt(sArray[1]);
            pq.offer(time);
        }
        
        int time = 540;
        int cnt = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            
            while (!pq.isEmpty()) {
                if (pq.peek() <= time && cnt < m) {
                    last = pq.poll();
                    cnt++;
                } else {
                    break;
                }
            }
            
            time += t;
        }
        
        int result = 0;
        if (cnt < m) {
            result = time - t;
        } else {
            result = last - 1;
        }
        
        String hour = String.format("%02d", result / 60);
        String minute = String.format("%02d", result % 60);
        String answer = hour + ":" + minute;
        return answer;
    }
}
