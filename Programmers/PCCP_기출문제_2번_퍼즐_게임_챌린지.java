
public class PCCP_기출문제_2번_퍼즐_게임_챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            long time = calTime(mid, diffs, times);
            
            if (time <= limit) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
    
    private long calTime(int level, int[] diffs, int[] times) {
        long time = times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            int temp = diffs[i] - level;
            
            if (temp <= 0) {
                time += times[i];
            } else {
                time += (temp * (times[i] + times[i-1])) + times[i];
            }
        }
        
        return time;
    }
}
