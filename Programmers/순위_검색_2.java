import java.util.*;

public class 순위_검색_2 {
    
    Map<String, List<Integer>> map;
    
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            String[] array = info[i].split(" ");
            make(0, array, "");
        }
        
        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
        }
        
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] array = query[i].replace(" and ", "").split(" ");
            if (map.containsKey(array[0])) {
                answer[i] = binarySearch(array[0], Integer.parseInt(array[1]));
            }
        }
        return answer;
    }
    
    private void make(int cnt, String[] array, String str) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(Integer.parseInt(array[4]));
            return;
        }
        
        make(cnt + 1, array, str + array[cnt]);
        make(cnt + 1, array, str + "-");
    }
    
    private int binarySearch(String str, int score) {
        List<Integer> list = map.get(str);
        int left = 0;
        int right = list.size() - 1;
        int result = list.size();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= score) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return list.size() - result;
    }
}
