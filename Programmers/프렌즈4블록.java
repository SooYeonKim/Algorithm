import java.util.*;

public class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        char[][] array = new char[m][n];
        for (int i = 0; i < m; i++) {
            array[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        while (true) {
            boolean flag = false;
            boolean[][] temp = new boolean[m][n];
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n-1; j++) {
                    if (array[i][j] != '.'
                       && array[i][j] == array[i+1][j]
                       && array[i][j] == array[i][j+1]
                       && array[i][j] == array[i+1][j+1]) {
                        flag = true;
                        temp[i][j] = true;
                        temp[i+1][j] = true;
                        temp[i][j+1] = true;
                        temp[i+1][j+1] = true;
                    }
                }
            }
            
            if (!flag) {
                break;
            } else {
                for (int i = 0; i < n; i++) {
                    Queue<Character> q = new LinkedList<>();
                    for (int j = m-1; j >= 0; j--) {
                        if (!temp[j][i]) {
                            q.offer(array[j][i]);
                        } else {
                            answer++;
                        }
                    }
                    
                    int idx = m-1;
                    while (!q.isEmpty()) {
                        array[idx--][i] = q.poll();
                    }
                    for (int j = idx; j >= 0; j--) {
                        array[j][i] = '.';
                    }
                }
            }
        }

        return answer;
    }
}
