import java.util.*;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] array = new int[N+2];
        for (int i = 0; i < stages.length; i++) {
            array[stages[i]]++;
        }
        
        int[] array2 = new int[N+2];
        array2[N+1] = array[N+1];
        for (int i = N; i >= 1; i--) {
            array2[i] = array2[i+1] + array[i];
        }
        
        double[][] result = new double[N][2];
        for (int i = 0; i < N; i++) {
            result[i][0] = i + 1;
            if (array2[i+1] != 0) {
                result[i][1] = (double) array[i+1] / array2[i+1];
            }
        }
        
        Arrays.sort(result, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[1], o1[1]);
            }
        });
        
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = (int)result[i][0];
        }
        return answer;
    }
}
