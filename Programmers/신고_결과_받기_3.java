import java.util.*;

public class 신고_결과_받기_3 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            set.add(report[i]);
        }
        
        Map<String, Integer> order = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            order.put(id_list[i], i);
        }
        
        List<String>[] list = new ArrayList[id_list.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : set) {
            String[] array = str.split(" ");
            map.put(array[1], map.getOrDefault(array[1], 0) + 1);
            list[order.get(array[0])].add(array[1]);
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < list.length; i++) {
            int cnt = 0;
            for (int j = 0; j < list[i].size(); j++) {
                if (map.get(list[i].get(j)) >= k) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
