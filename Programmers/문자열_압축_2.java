
public class 문자열_압축_2 {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String str = "";
            String target = s.substring(0, i);
            int cnt = 1;
            for (int j = i; j < s.length(); j += i) {
                String temp = "";
                if (j + i < s.length()) {
                    temp = s.substring(j, j + i);
                } else {
                    temp = s.substring(j);
                }
                
                if (target.equals(temp)) {
                    cnt++;
                } else if (cnt == 1) {
                    str += target;
                    target = temp;
                } else {
                    str += Integer.toString(cnt) + target;
                    target = temp;
                    cnt = 1;
                }
            }
            
            if (cnt == 1) {
                str += target;
            } else {
                str += Integer.toString(cnt) + target;
            }
            
            answer = Math.min(answer, str.length());
        }
        
        return answer;
    }
}
