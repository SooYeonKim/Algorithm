
public class 마법의_엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        while (storey != 0) {
            int a = storey % 10;
            int b = (storey / 10) % 10;
            
            if (a > 5 || (a == 5 && b >= 5)) {
                answer += (10 - a);
                storey += 10;
            } else {
                answer += a;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
