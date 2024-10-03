import java.util.*;

public class PCCP_기출문제_2번_석유_시추 {
    
    int n, m;
    int[][] land;
    boolean[][] visited;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[] result;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        this.land = land;
        visited = new boolean[n][m];
        result = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < m; i++) {
            answer = Math.max(answer, result[i]);
        }
        return answer;
    }
    
    private void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        Set<Integer> set = new HashSet<>();
        int cnt = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            set.add(cur[1]);
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + d[i][0];
                int ny = cur[1] + d[i][1];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
                if (land[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        
        for (int temp : set) {
            result[temp] += cnt;
        }
    }
}
