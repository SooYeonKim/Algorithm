import java.util.*;

public class 경주로_건설 {
    
    int[][] board;
    int[][] dArr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int answer = Integer.MAX_VALUE;
    
    public int solution(int[][] board) {
        this.board = board;
        
        bfs(1);
        bfs(2);
        
        return answer;
    }
    
    private void bfs(int pd) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[3] - o2[3];
            }
        });
        pq.offer(new int[]{0, 0, pd, 0});
        boolean[][][] visited = new boolean[board.length][board.length][4];
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            if (cur[0] == board.length - 1 && cur[1] == board.length - 1) {
                answer = Math.min(answer, cur[3]);
                return;
            }
            
            if (visited[cur[0]][cur[1]][cur[2]]) continue;
            visited[cur[0]][cur[1]][cur[2]] = true;
            
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dArr[i][0];
                int ny = cur[1] + dArr[i][1];
                
                if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) continue;
                if (board[nx][ny] == 1 || (cur[2] + 2) % 4 == i) continue;
                
                if (cur[2] == i) {
                    pq.offer(new int[]{nx, ny, i, cur[3] + 100});
                } else {
                    pq.offer(new int[]{nx, ny, i, cur[3] + 600});
                }
            }
        }
    }
}
