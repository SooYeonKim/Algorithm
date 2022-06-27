import java.util.*;

public class 실패율_2 {
    
    class Stage implements Comparable<Stage> {
        int no;
        double failureRate;
        
        public Stage(int no, double failureRate) {
            this.no = no;
            this.failureRate = failureRate;
        }
        
        @Override
        public int compareTo(Stage o) {
            return Double.compare(o.failureRate, this.failureRate);
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] cnt = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            cnt[stages[i]]++;
        }
        
        int[] sum = new int[N+2];
        sum[N+1] = cnt[N+1];
        for (int i = N; i >= 0; i--) {
            sum[i] = sum[i+1] + cnt[i];
        }
        
        Stage[] array = new Stage[N];
        for (int i = 0; i < N; i++) {
            int no = i + 1;
            double failureRate = 0;
            if (sum[i+1] != 0) {
                failureRate = (double)cnt[i+1] / sum[i+1];
            }
            array[i] = new Stage(no, failureRate);
        }
        
        Arrays.sort(array);
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = array[i].no;
        }
        return answer;
    }
}
