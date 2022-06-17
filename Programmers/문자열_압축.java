
public class 문자열_압축 {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String result = "";
            String target = s.substring(0, i);
            int cnt = 1;
            for (int j = i; j < s.length(); j += i) {
                String temp = "";
                if (j + i >= s.length()) {
                    temp = s.substring(j);
                } else {
                    temp = s.substring(j, j + i);
                }
                
                if (target.equals(temp)) {
                    cnt++;
                } else if (cnt == 1) {
                    result += target;
                    target = temp;
                } else {
                    result += cnt + target;
                    target = temp;
                    cnt = 1;
                }
            }
            
            if (cnt == 1) {
                result += target;
            } else {
                result += cnt + target;
            }
            
            answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
}
