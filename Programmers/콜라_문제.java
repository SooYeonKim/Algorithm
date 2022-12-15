
public class 콜라_문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int empty = n;
        while (empty >= a) {
            int temp = empty / a;
            answer += temp * b;
            empty -= temp * a;
            empty += temp * b;
        }
        
        return answer;
    }
}
