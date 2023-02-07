import java.util.*;

public class 인사고과 {
    
    class Node implements Comparable<Node> {
        int idx;
        int x;
        int y;
        
        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node o) {
            if(o.x == this.x) {
                return this.y - o.y;
            }
            return o.x - this.x;
        }
    }
    
    public int solution(int[][] scores) {
        int sum = scores[0][0] + scores[0][1];
        
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            list.add(new Node(i, scores[i][0], scores[i][1]));
        }
        
        Collections.sort(list);
        
        boolean[] check = new boolean[scores.length];
        Arrays.fill(check, true);
        boolean flag = true;
        int temp = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).y < temp) {
                check[i] = false;
                
                if (list.get(i).idx == 0) {
                    flag = false;
                    break;
                }
            } else {
                temp = list.get(i).y;
            }
        }
        
        if (!flag) return -1;
        
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if (check[i] && list.get(i).x + list.get(i).y > sum) answer++;
        }
        
        return answer + 1;
    }
}
