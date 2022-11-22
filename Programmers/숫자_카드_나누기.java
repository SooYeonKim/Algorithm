import java.util.*;

public class 숫자_카드_나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        List<Integer> listA = getCandidate(arrayA);
        List<Integer> listB = getCandidate(arrayB);
        
        int maxA = getMaxResult(arrayB, listA);
        int maxB = getMaxResult(arrayA, listB);
        
        int answer = Math.max(maxA, maxB);
        return answer;
    }
    
    private List<Integer> getCandidate(int[] array) {
        Arrays.sort(array);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= array[0]; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if (array[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) list.add(i);
        }
        
        return list;
    }
    
    private int getMaxResult(int[] array, List<Integer> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < array.length; j++) {
                if (array[j] % list.get(i) == 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) max = Math.max(max, list.get(i));
        }
        
        return max;
    }
}
