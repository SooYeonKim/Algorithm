
public class 외벽_점검 {
    
    int n, answer;
    int[] weak, dist, newWeak, selected;
    boolean[] visited;
    boolean flag;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        answer = -1;
        
        makeNewWeak();
        
        for (int i = 1; i <= dist.length; i++) {
            visited = new boolean[dist.length];
            selected = new int[i];
            permutation(0);
            
            if (flag) break;
        }
        
        return answer;
    }
    
    private void makeNewWeak() {
        newWeak = new int[weak.length * 2 - 1];
        for (int i = 0; i < weak.length; i++) {
            newWeak[i] = weak[i];
        }
        for (int i = 0; i < weak.length - 1; i++) {
            newWeak[i + weak.length] = weak[i] + n;
        }
    }
    
    private void permutation(int cnt) {
        if (flag) return;
        
        if (cnt == selected.length) {
            check();
            return;
        }
        
        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            selected[cnt] = dist[i];
            permutation(cnt + 1);
            visited[i] = false;
        }
    }
    
    private void check() {
        for (int i = 0; i < weak.length; i++) {
            int start = i;
            boolean[] isCheck = new boolean[weak.length];
            for (int j = 0; j < selected.length; j++) {
                for (int k = start; k < i + weak.length; k++) {
                    if (newWeak[k] - newWeak[start] > selected[j]) {
                        start = k;
                        break;
                    }
                    
                    isCheck[k % weak.length] = true;
                }
            }
            
            int cnt = 0;
            for (int j = 0; j < weak.length; j++) {
                if (isCheck[j]) cnt++;
            }
            
            if (cnt == weak.length) {
                flag = true;
                answer = selected.length;
                return;
            }
        }
    }
}
