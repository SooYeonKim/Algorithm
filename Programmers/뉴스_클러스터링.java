import java.util.*;

public class 뉴스_클러스터링 {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            if (str1.charAt(i) < 'a' || str1.charAt(i) > 'z') continue;
            if (str1.charAt(i+1) < 'a' || str1.charAt(i+1) > 'z') continue;
            
            list1.add("" + str1.charAt(i) + str1.charAt(i+1));
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            if (str2.charAt(i) < 'a' || str2.charAt(i) > 'z') continue;
            if (str2.charAt(i+1) < 'a' || str2.charAt(i+1) > 'z') continue;
            
            list2.add("" + str2.charAt(i) + str2.charAt(i+1));
        }
        
        List<String> intersection = new ArrayList<>();
        List<String> union;
        
        for (int i = 0; i < list1.size(); i++) {
            String str = list1.get(i);
            if (list2.remove(str)) {
                intersection.add(str);
            }
        }
        
        union = new ArrayList<>(list1);
        for (int i = 0; i < list2.size(); i++) {
            union.add(list2.get(i));
        }
        
        if (union.size() == 0) {
            return 65536;
        } else {
            return intersection.size() * 65536 / union.size();
        }
    }
}
