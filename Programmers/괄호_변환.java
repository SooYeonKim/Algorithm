
public class 괄호_변환 {
    public String solution(String p) {
        if (p.length() == 0) return p;
        
        int cnt = 0;
        String answer = "";
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt == 0) {
                if (check(p.substring(0, i+1))) {
                    answer = p.substring(0, i+1) + solution(p.substring(i+1));
                } else {
                    answer = "(" + solution(p.substring(i+1)) + ")";
                    for (int j = 1; j < i; j++) {
                        if (p.charAt(j) == '(') answer += ')';
                        else answer += '(';
                    }
                }
                
                break;
            }
        }
        
        return answer;
    }
    
    private boolean check(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            
            if (cnt < 0) return false;
        }
        
        return true;
    }
}
