import java.util.*;

public class 테이블_해시_함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[col-1] == o2[col-1]) {
                    return o2[0] - o1[0];
                }
                return o1[col-1] - o2[col-1];
            }
        });
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = row_begin; i <= row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                sum += data[i-1][j] % i;
            }
            
            q.offer(sum);
        }
        
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            q.offer(a ^ b);
        }
        
        return q.poll();
    }
}
