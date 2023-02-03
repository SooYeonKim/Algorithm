
public class 점_찍기 {
    public long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i += k) {
            int y = (int)Math.sqrt((long)d * d - (long)i * i);
            answer += (y / k + 1);
        }
        return answer;
    }
}
