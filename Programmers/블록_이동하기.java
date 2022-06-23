import java.util.*;

public class 블록_이동하기 {
    
    int[][] array;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int answer;
    
    public int solution(int[][] board) {
        array = board;
        bfs();
        return answer;
    }
    
    private void bfs() {
        int N = array.length;
        Queue<int[]> pq = new LinkedList<>();
        pq.offer(new int[]{0, 0, 0, 1, 0});
        boolean[][][][] visited = new boolean[N][N][N][N];
        visited[0][0][0][1] = true;
        visited[0][1][0][0] = true;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x1 = cur[0];
            int y1 = cur[1];
            int x2 = cur[2];
            int y2 = cur[3];
            int time = cur[4];
            
            if ((x1 == N-1 && y1 == N-1) || (x2 == N-1 && y2 == N-1)) {
                answer = time;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx1 = x1 + d[i][0];
                int ny1 = y1 + d[i][1];
                int nx2 = x2 + d[i][0];
                int ny2 = y2 + d[i][1];
                
                if (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= N
                   || nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= N
                   || visited[nx1][ny1][nx2][ny2]
                   || array[nx1][ny1] == 1 || array[nx2][ny2] == 1) continue;
                
                pq.offer(new int[]{nx1, ny1, nx2, ny2, time + 1});
                visited[nx1][ny1][nx2][ny2] = true;
                visited[nx2][ny2][nx1][ny1] = true;
            }
            
            if (x1 == x2) { //수평 방향
                int tx1 = x1 - 1;
                int ty1 = y1;
                int tx2 = x2 - 1;
                int ty2 = y2;
                
                if (tx1 >= 0 && array[tx1][ty1] == 0 && array[tx2][ty2] == 0) {
                    if (!visited[tx1][ty1][x1][ty1]) {
                        pq.offer(new int[]{tx1, ty1, x1, ty1, time + 1});
                        visited[tx1][ty1][x1][ty1] = true;
                        visited[x1][ty1][tx1][ty1] = true;
                    }
                    if (!visited[tx2][ty2][x2][ty2]) {
                        pq.offer(new int[]{tx2, ty2, x2, ty2, time + 1});
                        visited[tx2][ty2][x2][ty2] = true;
                        visited[x2][ty2][tx2][ty2] = true;
                    }
                }
                
                tx1 = x1 + 1;
                ty1 = y1;
                tx2 = x2 + 1;
                ty2 = y2;
                
                if (tx1 < N && array[tx1][ty1] == 0 && array[tx2][ty2] == 0) {
                    if (!visited[tx1][ty1][x1][ty1]) {
                        pq.offer(new int[]{tx1, ty1, x1, ty1, time + 1});
                        visited[tx1][ty1][x1][ty1] = true;
                        visited[x1][ty1][tx1][ty1] = true;
                    }
                    if (!visited[tx2][ty2][x2][ty2]) {
                        pq.offer(new int[]{tx2, ty2, x2, ty2, time + 1});
                        visited[tx2][ty2][x2][ty2] = true;
                        visited[x2][ty2][tx2][ty2] = true;
                    }
                }
            } else { //수직 방향
                int tx1 = x1;
                int ty1 = y1 - 1;
                int tx2 = x2;
                int ty2 = y2 - 1;
                
                if (ty1 >= 0 && array[tx1][ty1] == 0 && array[tx2][ty2] == 0) {
                    if (!visited[tx1][ty1][tx1][y1]) {
                        pq.offer(new int[]{tx1, ty1, tx1, y1, time + 1});
                        visited[tx1][ty1][tx1][y1] = true;
                        visited[tx1][y1][tx1][ty1] = true;
                    }
                    if (!visited[tx2][ty2][tx2][y2]) {
                        pq.offer(new int[]{tx2, ty2, tx2, y2, time + 1});
                        visited[tx2][ty2][tx2][y2] = true;
                        visited[tx2][y2][tx2][ty2] = true;
                    }
                }
                
                tx1 = x1;
                ty1 = y1 + 1;
                tx2 = x2;
                ty2 = y2 + 1;
                
                if (ty1 < N && array[tx1][ty1] == 0 && array[tx2][ty2] == 0) {
                    if (!visited[tx1][ty1][tx1][y1]) {
                        pq.offer(new int[]{tx1, ty1, tx1, y1, time + 1});
                        visited[tx1][ty1][tx1][y1] = true;
                        visited[tx1][y1][tx1][ty1] = true;
                    }
                    if (!visited[tx2][ty2][tx2][y2]) {
                        pq.offer(new int[]{tx2, ty2, tx2, y2, time + 1});
                        visited[tx2][ty2][tx2][y2] = true;
                        visited[tx2][y2][tx2][ty2] = true;
                    }
                }
            }
        }
    }
}
