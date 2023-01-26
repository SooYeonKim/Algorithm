
public class 미로_탈출_명령어 {
    
    int[][] dArr = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    char[] sArr = {'d', 'l', 'r', 'u'};
    String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        answer = "z";
        
        if ((k - (Math.abs(r - x) + Math.abs(c - y))) % 2 != 0) {
            return new String("impossible");
        }
        
        recursion(n, m, x, y, r, c, k, 0, "");
        
        if (answer.equals("z")) return new String("impossible");
        else return answer;
    }
    
    private void recursion(int n, int m, int x, int y, int r, int c, int k, int cnt, String temp) {
        if (Math.abs(r - x) + Math.abs(c - y) + cnt > k) return;
        
        if (x == r && y == c && cnt == k) {
            answer = temp;
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dArr[i][0];
            int ny = y + dArr[i][1];
            
            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
            
            String str = temp + sArr[i];
            if (str.compareTo(answer) < 0) {
                recursion(n, m, nx, ny, r, c, k, cnt + 1, str);
            }
        }
    }
}
