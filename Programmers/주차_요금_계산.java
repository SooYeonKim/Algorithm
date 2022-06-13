import java.util.*;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> totalMap = new TreeMap<>();
        Map<String, Integer> timeMap = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] sArray = records[i].split(" ");
            String[] tArray = sArray[0].split(":");
            int time = Integer.parseInt(tArray[0]) * 60 + Integer.parseInt(tArray[1]);
            
            if (sArray[2].equals("IN")) {
                timeMap.put(sArray[1], time);
            } else {
                int temp = time - timeMap.get(sArray[1]);
                timeMap.remove(sArray[1]);
                totalMap.put(sArray[1], totalMap.getOrDefault(sArray[1], 0) + temp);
            }
        }
        
        for (String str : timeMap.keySet()) {
            int temp = 23 * 60 + 59 - timeMap.get(str);
            totalMap.put(str, totalMap.getOrDefault(str, 0) + temp);
        }
        
        int[] answer = new int[totalMap.size()];
        int idx = 0;
        for (String str : totalMap.keySet()) {
            int time = totalMap.get(str);
            if (time <= fees[0]) {
                answer[idx++] = fees[1]; 
            } else {
                int total = fees[1];
                time -= fees[0];
                if (time % fees[2] == 0) {
                    total += time / fees[2] * fees[3];
                } else {
                    total += (time / fees[2] + 1) * fees[3];
                }
                answer[idx++] += total;
            }
        }
        return answer;
    }
}
