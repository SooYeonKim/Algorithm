
public class n진수_게임_2 {
    public String solution(int n, int t, int m, int p) {
        String temp = "";
        for (int i = 0; i < t * m; i++) {
            temp += Integer.toString(i, n);
        }
        temp = temp.toUpperCase();
        
        String answer = "";
        int idx = p - 1;
        int cnt = t;
        while (cnt-- > 0) {
            answer += temp.charAt(idx);
            idx += m;
        }
        return answer;
    }
}
