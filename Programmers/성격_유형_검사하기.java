import java.util.*;

public class 성격_유형_검사하기 {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < survey.length; i++) {
            String str = survey[i];
            char c1 = str.charAt(0);
            char c2 = str.charAt(1);
            
            if (choices[i] < 4) {
                map.put(c1, map.getOrDefault(c1, 0) + 4 - choices[i]);
            } else if (choices[i] > 4) {
                map.put(c2, map.getOrDefault(c2, 0) + choices[i] - 4);
            }
        }
        
        String answer = "";
        if (map.getOrDefault('R', 0) >= map.getOrDefault('T', 0)) answer += "R";
        else answer += "T";
        if (map.getOrDefault('C', 0) >= map.getOrDefault('F', 0)) answer += "C";
        else answer += "F";
        if (map.getOrDefault('J', 0) >= map.getOrDefault('M', 0)) answer += "J";
        else answer += "M";
        if (map.getOrDefault('A', 0) >= map.getOrDefault('N', 0)) answer += "A";
        else answer += "N";
        
        return answer;
    }
}
