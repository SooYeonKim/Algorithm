
public class 기둥과_보_설치 {
    
    int n;
    boolean[][] pillarArr;
    boolean[][] beamArr;
    
    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        pillarArr = new boolean[n+1][n+1];
        beamArr = new boolean[n+1][n+1];
        
        int cnt = 0;
        for (int i = 0;i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            
            if (a == 0) {
                if (b == 1) {
                    if (checkPillar(x, y)) {
                        pillarArr[x][y] = true;
                        cnt++;
                    }
                } else {
                    pillarArr[x][y] = false;
                    if (!checkDelete()) pillarArr[x][y] = true;
                    else cnt--;
                }
            } else {
                if (b == 1) {
                    if (checkBeam(x, y)) {
                        beamArr[x][y] = true;
                        cnt++;
                    }
                } else {
                    beamArr[x][y] = false;
                    if (!checkDelete()) beamArr[x][y] = true;
                    else cnt--;
                }
            }
        }
        
        int[][] answer = new int[cnt][3];
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillarArr[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 0;
                }
                if (beamArr[i][j]) {
                    answer[idx][0] = i;
                    answer[idx][1] = j;
                    answer[idx++][2] = 1;
                }
            }
        }
        return answer;
    }
    
    private boolean checkPillar(int x, int y) {
        if (y == 0) return true;
        else if (beamArr[x][y] || (x > 0 && beamArr[x-1][y])) return true;
        else if (pillarArr[x][y-1]) return true;
        
        return false;
    }
    
    private boolean checkBeam(int x, int y) {
        if (pillarArr[x][y-1] || pillarArr[x+1][y-1]) return true;
        else if (x > 0 && beamArr[x-1][y] && beamArr[x+1][y]) return true;
        
        return false;
    }
    
    private boolean checkDelete() {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (pillarArr[i][j] && !checkPillar(i, j)) return false;
                else if (beamArr[i][j] && !checkBeam(i, j)) return false;
            }
        }
        
        return true;
    }
}
