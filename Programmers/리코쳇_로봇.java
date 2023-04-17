import java.util.*;

public class 리코쳇_로봇 {
    
    int n, m;
    char[][] array;
    int[] start, end;
    int[][] dArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        array = new char[n][m];
        start = new int[2];
        end = new int[2];
        for (int i = 0; i < board.length; i++) {
            array[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (array[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (array[i][j] == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        return bfs();
    }
    
    private int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == end[0] && cur[1] == end[1]) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0];
                int ny = cur[1];
                
                while (nx >= 0 && nx < n && ny >= 0 && ny < m && array[nx][ny] != 'D') {
                    nx += dArr[i][0];
                    ny += dArr[i][1];
                }
                
                nx -= dArr[i][0];
                ny -= dArr[i][1];
                
                if (visited[nx][ny] || (nx == cur[0] && ny == cur[1])) continue;
                
                q.offer(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}
