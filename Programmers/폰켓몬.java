import java.util.*;

public class 폰켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        int answer = 0;
        if (set.size() > nums.length / 2) {
            answer = nums.length / 2;
        } else {
            answer = set.size();
        }
        return answer;
    }
}
