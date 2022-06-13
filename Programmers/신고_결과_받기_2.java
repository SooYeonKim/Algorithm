import java.util.*;

public class 신고_결과_받기_2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            orderMap.put(id_list[i], i);
        }
        List<String>[] list = new ArrayList[id_list.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        Set<String>[] set = new HashSet[id_list.length];
        for (int i = 0; i < list.length; i++) {
            set[i] = new HashSet<>();
        }
        Map<String, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] sArray = report[i].split(" ");
            if (!set[orderMap.get(sArray[0])].contains(sArray[1])) {
                list[orderMap.get(sArray[0])].add(sArray[1]);
                cntMap.put(sArray[1], cntMap.getOrDefault(sArray[1], 0) + 1);
                set[orderMap.get(sArray[0])].add(sArray[1]);
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < list.length; i++) {
            int cnt = 0;
            for (int j = 0; j < list[i].size(); j++) {
                if (cntMap.get(list[i].get(j)) >= k) cnt++;
            }
            
            answer[i] = cnt;
        }
        return answer;
    }
}
