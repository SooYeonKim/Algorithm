
public class _2차원_동전_뒤집기 {
    public int solution(int[][] beginning, int[][] target) {
        int N = beginning.length;
        int M = beginning[0].length;
        int answer = Integer.MAX_VALUE;
        int cnt = 0;
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = beginning[i][j];
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (temp[i][0] != target[i][0]) {
                cnt++;
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == 0) temp[i][j] = 1;
                    else temp[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            if (temp[0][i] != target[0][i]) {
                cnt++;
                for (int j = 0; j < N; j++) {
                    if (temp[j][i] == 0) temp[j][i] = 1;
                    else temp[j][i] = 0;
                }
            }
        }
        
        boolean flag = true;
        here: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] != target[i][j]) {
                    flag = false;
                    break here;
                }
            }
        }
        
        if (flag) answer = cnt;
        
        cnt = 0;
        temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = beginning[i][j];
            }
        }
        
        for (int i = 0; i < N; i++) {
            if (temp[i][0] == target[i][0]) {
                cnt++;
                for (int j = 0; j < M; j++) {
                    if (temp[i][j] == 0) temp[i][j] = 1;
                    else temp[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < M; i++) {
            if (temp[0][i] != target[0][i]) {
                cnt++;
                for (int j = 0; j < N; j++) {
                    if (temp[j][i] == 0) temp[j][i] = 1;
                    else temp[j][i] = 0;
                }
            }
        }
        
        flag = true;
        here: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] != target[i][j]) {
                    flag = false;
                    break here;
                }
            }
        }
        
        if (flag) answer = Math.min(answer, cnt);
        
        if (answer == Integer.MAX_VALUE) return -1;
        else return answer;
    }
}
