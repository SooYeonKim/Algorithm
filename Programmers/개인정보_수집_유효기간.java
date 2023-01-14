import java.util.*;

public class 개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] sArr = terms[i].split(" ");
            map.put(sArr[0], Integer.parseInt(sArr[1]) * 28);
        }
        
        String[] todayArr = today.split("\\.");
        int[] tArr = new int[3];
        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = Integer.parseInt(todayArr[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] sArr = privacies[i].split(" ");
            String[] date = sArr[0].split("\\.");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]) + map.get(sArr[1]) - 1;
            
            while (day > 28) {
                day -= 28;
                month += 1;
            }
            
            while (month > 12) {
                month -= 12;
                year += 1;
            }
            
            if (year < tArr[0]) {
                list.add(i+1);
            } else if (year == tArr[0]) {
                if (month < tArr[1]) {
                    list.add(i+1);
                } else if (month == tArr[1]) {
                    if (day < tArr[2]) {
                        list.add(i+1);
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
