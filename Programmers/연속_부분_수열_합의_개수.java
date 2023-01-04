import java.util.*;

public class 연속_부분_수열_합의_개수 {
    public int solution(int[] elements) {
        int[] array = new int[elements.length * 2];
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            array[i] = array[i + elements.length] = elements[i];
            sum += elements[i];
        }
        
        Set<Integer> set = new HashSet<>();
        set.add(sum);
        
        for (int i = 0; i < elements.length; i++) {
            sum = 0;
            for (int j = i; j < i + elements.length - 1; j++) {
                sum += array[j];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
