
public class 기사단원의_무기 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += find(i, limit, power);
        }
        
        return answer;
    }
    
    private int find(int num, int limit, int power) {
        int cnt = 0;
        for (int i = 1; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i * i == num) cnt++;
                else cnt += 2;
            }
        }
        
        if (cnt > limit) return power;
        else return cnt;
    }
}
