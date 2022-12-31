import java.util.*;

public class 과일_장수 {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        
        int answer = 0;
        int idx = 1;
        for (int i = score.length - 1; i >= 0; i--) {
            if (idx++ % m == 0) {
                answer += (score[i] * m);
            }
        }
        return answer;
    }
}
