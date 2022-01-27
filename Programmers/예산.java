import java.util.*;

public class 예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            if (sum + d[i] <= budget) {
                answer++;
                sum += d[i];
            } else {
                break;
            }
        }
        return answer;
    }
}
