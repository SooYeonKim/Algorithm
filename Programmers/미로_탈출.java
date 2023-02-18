import java.util.*;

public class 미로_탈출 {
    
    int n, m, sx, sy, ex, ey, lx, ly;
    char[][] array;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        array = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] cArr = maps[i].toCharArray();
            for (int j = 0; j < m; j++) {
                array[i][j] = cArr[j];
                
                if (array[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (array[i][j] == 'E') {
                    ex = i;
                    ey = j;
                } else if (array[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }
            }
        }
        
        int result1 = bfs(sx, sy, lx, ly);
        int result2 = bfs(lx, ly, ex, ey);
        
        if (result1 == -1 || result2 == -1) return -1;
        return result1 + result2;
    }
    
    private int bfs(int dx, int dy, int tx, int ty) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{dx, dy, 0});
        boolean[][] visited = new boolean[n][m];
        visited[dx][dy] = true;
        int result = -1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == tx && cur[1] == ty) {
                return cur[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + d[i][0];
                int ny = cur[1] + d[i][1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
                if (array[nx][ny] != 'X') {
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return result;
    }
}
