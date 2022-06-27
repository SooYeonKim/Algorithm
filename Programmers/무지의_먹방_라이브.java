import java.util.*;

public class 무지의_먹방_라이브 {
    
    class Food implements Comparable<Food> {
        int no;
        int time;
        
        public Food(int no, int time) {
            this.no = no;
            this.time = time;
        }
        
        @Override
        public int compareTo(Food o) {
            return this.time - o.time;
        }
    }
    
    public int solution(int[] food_times, long k) {
        long sum = 0;
        for (int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        if (sum <= k) return -1;
        
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }
        
        long prevTime = 0;
        long totalTime = 0;
        long foodCnt = food_times.length;
        while (totalTime + (pq.peek().time - prevTime) * foodCnt <= k) {
            totalTime += (pq.peek().time - prevTime) * foodCnt;
            prevTime = pq.poll().time;
            foodCnt--;
        }
        
        List<Food> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Food food = pq.poll();
            list.add(new Food(food.no, food.time));
        }
        
        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.no - o2.no;
            }
        });
        
        int answer = list.get((int)((k - totalTime) % foodCnt)).no;
        return answer;
    }
}
