
public class 문자열_나누기 {
    public int solution(String s) {
        int answer = 1;
        while (s.length() != 1) {
            char c = s.charAt(0);
            int same = 1;
            int diff = 0;
            int idx = 1;
            for (; idx < s.length(); idx++) {
                if (s.charAt(idx) == c) same++;
                else diff++;
                
                if (same == diff) break;
            }
            
            if (idx + 1 < s.length()) s = s.substring(idx + 1);
            else break;
            
            answer++;
        }
        
        return answer;
    }
}
