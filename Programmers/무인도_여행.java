import java.util.*;

public class 무인도_여행 {
    
    int n, m;
    char[][] array;
    boolean[][] visited;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    List<Integer> list;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        array = new char[n][m];
        for (int i = 0; i < n; i++) {
            array[i] = maps[i].toCharArray();
        }
        
        visited = new boolean[n][m];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] != 'X' && !visited[i][j]) {
                    visited[i][j] = true;
                    list.add(dfs(i, j));
                }
            }
        }
        
        if (list.size() == 0) {
            list.add(-1);
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    private int dfs(int x, int y) {
        int cnt = array[x][y] - '0';
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
            if (array[nx][ny] != 'X') {
                visited[nx][ny] = true;
                cnt += dfs(nx, ny);
            }
        }
        
        return cnt;
    }
}
