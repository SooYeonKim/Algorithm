import java.util.*;

public class 메뉴_리뉴얼_2 {
    
    Map<String, Integer> map;
    int target;
    char[] array;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            map = new HashMap<>();
            target = course[i];
            for (int j = 0; j < orders.length; j++) {
                array = orders[j].toCharArray();
                Arrays.sort(array);
                combination(0, 0, "");
            }
            
            int max = 0;
            for (String str : map.keySet()) {
                if (map.get(str) >= 2 && map.get(str) > max) {
                    max = map.get(str);
                }
            }
            
            if (max >= 2) {
                for (String str : map.keySet()) {
                    if (map.get(str) == max) {
                        list.add(str);
                    }
                }
            }
        }
        
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        
        return answer;
    }
    
    private void combination(int cnt, int start, String str) {
        if (cnt == target) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        
        for (int i = start; i < array.length; i++) {
            combination(cnt + 1, i + 1, str + array[i]);
        }
    }
}
