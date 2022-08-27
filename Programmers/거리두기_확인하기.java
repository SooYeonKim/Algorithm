import java.util.*;

public class 거리두기_확인하기 {
    
    char[][] array;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int t = 0; t < 5; t++) {
            array = new char[5][5];
            for (int i = 0; i < 5; i++) {
                array[i] = places[t][i].toCharArray();
            }
            
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (array[i][j] == 'P') {
                        if (!bfs(i, j)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            
            if (flag) answer[t] = 1;
        }
        
        return answer;
    }
    
    private boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + d[i][0];
                int ny = cur[1] + d[i][1];
                
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny]) continue;
                if (array[nx][ny] == 'X' || cur[2] >= 2) continue;
                if (array[nx][ny] == 'P') return false;
                
                q.offer(new int[]{nx, ny, cur[2] + 1});
                visited[nx][ny] = true;
            }
        }
        
        return true;
    }
}
