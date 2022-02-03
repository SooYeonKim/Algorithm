import java.util.*;

public class 두_개_뽑아서_더하기 {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                treeSet.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = new int[treeSet.size()];
        int idx = 0;
        for (Integer num : treeSet) {
            answer[idx++] = num;
        }
        return answer;
    }
}
