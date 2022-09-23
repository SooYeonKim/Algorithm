import java.util.*;

public class 합승_택시_요금_2 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] array = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(array[i], Integer.MAX_VALUE);
            array[i][i] = 0;
        }
        
        for (int i = 0; i < fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            
            array[c][d] = f;
            array[d][c] = f;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (array[i][k] == Integer.MAX_VALUE || array[k][j] == Integer.MAX_VALUE) continue;
                    if (array[i][j] > array[i][k] + array[k][j]) {
                        array[i][j] = array[i][k] + array[k][j];
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = array[s][i] + array[i][a] + array[i][b];
            if (sum < answer) answer = sum;
        }
        return answer;
    }
}
