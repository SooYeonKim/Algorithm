import java.util.*;

public class 소수_만들기 {
    public int solution(int[] nums) {
        boolean[] primeNum = new boolean[3000];
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < 3000; i++) {
            boolean check = true;
            for (int j = 0; j < list.size(); j++) {
                if (i % list.get(j) == 0) {
                    check = false;
                    break;
                }
                if (i < list.get(j) * list.get(j)) break;
            }
            
            if (check) {
                primeNum[i] = true;
                list.add(i);
            }
        }
        
        int answer = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (primeNum[sum]) answer++;
                }
            }
        }
        return answer;
    }
}
