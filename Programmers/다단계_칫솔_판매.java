import java.util.*;

public class 다단계_칫솔_판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            idxMap.put(enroll[i], i);
        }
        
        int[] answer = new int[enroll.length];
        for (int i = 0; i < seller.length; i++) {
            String s = seller[i];
            int a = amount[i] * 100;
            while (!s.equals("-")) {
                if (a * 10 / 100 < 1) {
                    answer[idxMap.get(s)] += a;
                    break;
                } else {
                    answer[idxMap.get(s)] += (a - a * 10 / 100);
                    s = referral[idxMap.get(s)];
                    a = a * 10 / 100;
                }
            }
        }
        
        return answer;
    }
}
