import java.util.*;

public class PCCP_기출문제_3번_충돌위험_찾기 {
    
    int[][] points, routes;
    int size, answer;
    Queue<int[]>[] list;
    
    public int solution(int[][] points, int[][] routes) {
        this.points = points;
        this.routes = routes;
        size = routes.length;
        answer = 0;
        list = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            list[i] = new LinkedList<>();
        }
        
        recordRoute();
        calCrash();
        
        return answer;
    }
    
    private void recordRoute() {
        for (int i = 0; i < size; i++) {
            int x = points[routes[i][0] - 1][0];
            int y = points[routes[i][0] - 1][1];
            list[i].add(new int[]{x, y});
            
            for (int j = 1; j < routes[i].length; j++) {
                int tx = points[routes[i][j] - 1][0];
                int ty = points[routes[i][j] - 1][1];
                
                int cx = tx - x;
                int cy = ty - y;
                
                while (cx != 0) {
                    if (cx > 0) {
                        x += 1;
                        cx -= 1;
                    } else {
                        x -= 1;
                        cx += 1;
                    }
                    
                    list[i].add(new int[]{x, y});
                }
                
                while (cy != 0) {
                    if (cy > 0) {
                        y += 1;
                        cy -= 1;
                    } else {
                        y -= 1;
                        cy += 1;
                    }
                    
                    list[i].add(new int[]{x, y});
                }
            }
        }
    }
    
    private void calCrash() {
        int emptyCnt = 0;
        
        while (emptyCnt != size) {
            emptyCnt = 0;
            int[][] map = new int[101][101];
            
            for (int i = 0; i < size; i++) {
                if (list[i].isEmpty()) {
                    emptyCnt++;
                    continue;
                }
                
                int[] pos = list[i].poll();
                map[pos[0]][pos[1]] += 1;
            }
            
            for (int i = 1; i <= 100; i++) {
                for (int j = 1; j <= 100; j++) {
                    if (map[i][j] > 1) answer++;
                }
            }
        }
    }
}
