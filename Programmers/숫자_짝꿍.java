import java.util.*;

public class 숫자_짝꿍 {
    public String solution(String X, String Y) {
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();
        
        for (int i = 0; i < X.length(); i++) {
            int num = X.charAt(i) - '0';
            mapX.put(num, mapX.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < Y.length(); i++) {
            int num = Y.charAt(i) - '0';
            mapY.put(num, mapY.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (Integer num : mapX.keySet()) {
            int cnt1 = mapX.get(num);
            int cnt2 = mapY.getOrDefault(num, 0);
            
            for (int i = 0; i < Math.min(cnt1, cnt2); i++) {
                list.add(num);
            }
        }
        
        if (list.size() == 0) return new String("-1");
        
        Collections.sort(list, Collections.reverseOrder());
        
        if (list.get(0) == 0) return new String("0");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }
}
