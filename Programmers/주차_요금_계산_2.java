import java.util.*;

public class 주차_요금_계산_2 {
    
    class Car implements Comparable<Car> {
        String num;
        int fee;
        
        public Car(String num, int fee) {
            this.num = num;
            this.fee = fee;
        }
        
        @Override
        public int compareTo(Car o) {
            return this.num.compareTo(o.num);
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> total = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String temp = record[0];
            String[] tempArr = temp.split(":");
            int time = Integer.parseInt(tempArr[0]) * 60 + Integer.parseInt(tempArr[1]);
            String num = record[1];
            
            if (record[2].equals("IN")) {
                map.put(num, time);
            } else {
                int sTime = map.get(num);
                int diff = time - sTime;
                total.put(num, total.getOrDefault(num, 0) + diff);
                map.remove(num);
            }
        }
        
        for (String s : map.keySet()) {
            int sTime = map.get(s);
            int diff = 23 * 60 + 59 - sTime;
            total.put(s, total.getOrDefault(s, 0) + diff);
        }
        
        List<Car> list = new ArrayList<>();
        for (String num : total.keySet()) {
            int diff = total.get(num);
            int fee = fees[1];
            if (diff > fees[0]) {
                diff -= fees[0];
                fee += (diff / fees[2]) * fees[3];
                if (diff % fees[2] != 0) fee += fees[3];
            }
            
            list.add(new Car(num, fee));
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).fee;
        }
        return answer;
    }
}
