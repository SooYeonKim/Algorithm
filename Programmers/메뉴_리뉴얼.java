import java.util.*;

public class 메뉴_리뉴얼 {
    
    String[] orders;
    int target;
    Map<String ,Integer> map;
    TreeSet<String> result;
    
    public String[] solution(String[] orders, int[] course) {
        this.orders = orders;
        result = new TreeSet<>();
        
        for (int i = 0; i < course.length; i++) {
            target = course[i];
            map = new HashMap<>();
            
            for (int j = 0; j < orders.length; j++) {
                char[] cArray = orders[j].toCharArray();
                Arrays.sort(cArray);
                combination(0, 0, cArray, "");
            }
            
            if (map.size() > 0) {
                int max = 0;
                for (String s : map.keySet()) {
                    if (map.get(s) > max) max = map.get(s);
                }
                
                for (String s : map.keySet()) {
                    if (map.get(s) >= 2 && map.get(s) == max) {
                        result.add(s);
                    }
                }
            }
        }
        
        String[] answer = new String[result.size()];
        int idx = 0;
        for (String s : result) {
            answer[idx++] = s;
        }
        return answer;
    }
    
    private void combination(int cnt, int start, char[] cArray, String str) {
        if (cnt == target) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        
        for (int i = start; i < cArray.length; i++) {
            combination(cnt + 1, i + 1, cArray, str + cArray[i]);
        }
    }
}
