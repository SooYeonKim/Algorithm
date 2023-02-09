import java.util.*;

public class 호텔_대실 {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            } 
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < book_time.length; i++) {
            String[] sArr = book_time[i][0].split(":");
            String[] eArr = book_time[i][1].split(":");
            int start = Integer.parseInt(sArr[0]) * 60 + Integer.parseInt(sArr[1]);
            int end = Integer.parseInt(eArr[0]) * 60 + Integer.parseInt(eArr[1]);
            
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            pq.offer(end + 10);
        }
        
        return pq.size();
    }
}
