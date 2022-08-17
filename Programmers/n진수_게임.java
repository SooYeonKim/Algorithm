
public class n진수_게임 {
    public String solution(int n, int t, int m, int p) {
        String str = "";
        for (int i = 0; i < t * m; i++) {
            str += Integer.toString(i, n);
        }
        str = str.toUpperCase();
        
        String answer = "";
        int idx = p - 1;
        for (int i = 0; i < t; i++) {
            answer += str.charAt(idx);
            idx += m;
        }
        return answer;
    }
}
