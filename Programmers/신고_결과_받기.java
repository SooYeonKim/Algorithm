import java.util.*;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }
        
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < report.length; i++) {
            set.add(report[i]);
        }
        
        HashMap<String, Integer> reportMap = new HashMap<>();
        List<String>[] list = new ArrayList[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (String s : set) {
            String[] sArray = s.split(" ");
            list[map.get(sArray[0])].add(sArray[1]);
            reportMap.put(sArray[1], reportMap.getOrDefault(sArray[1], 0) + 1);
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            int cnt = 0;
            for (int j = 0; j < list[i].size(); j++) {
                String temp = list[i].get(j);
                if (reportMap.getOrDefault(temp, 0) >= k) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
