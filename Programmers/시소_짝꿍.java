import java.util.*;

public class 시소_짝꿍 {
    
    int[] weights;
    
    public long solution(int[] weights) {
        this.weights = weights;
        Arrays.sort(weights);
        int[][] rate = {{1, 1}, {2, 3}, {1, 2}, {3, 4}};
        
        long answer = 0;
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (weights[i] * rate[j][1] % rate[j][0] != 0) continue;
                
                int target = weights[i] * rate[j][1] / rate[j][0];
                int upper = upperBound(target, i+1, weights.length - 1);
                int lower = lowerBound(target, i+1, upper - 1);                
                
                answer += (upper - lower);
            }
        }
        
        return answer;
    }
    
    private int lowerBound(int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (weights[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return right + 1;
    }
    
    private int upperBound(int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (weights[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}
