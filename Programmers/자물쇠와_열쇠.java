
public class 자물쇠와_열쇠 {
    public boolean solution(int[][] key, int[][] lock) {
        int kLen = key.length - 1;
        for (int i = 0; i < lock.length + kLen; i++) {
            for (int j = 0; j < lock.length + kLen; j++) {
                for (int d = 0; d < 4; d++) {
                    int[][] newLock = new int[lock.length + kLen * 2][lock.length + kLen * 2];
                    for (int n = 0; n < lock.length; n++) {
                        for (int m = 0; m < lock.length; m++) {
                            newLock[n + kLen][m + kLen] = lock[n][m];
                        }
                    }
                    
                    add(newLock, key, i, j);
                    if (check(newLock, kLen)) return true;
                    
                    int len = key.length;
                    int[][] temp = new int[len][len];
                    for (int n = 0; n < len; n++) {
                        for (int m = 0; m < len; m++) {
                            temp[n][m] = key[len - 1 - m][n];
                        }
                    }

                    key = temp;
                }
            }
        }
        
        return false;
    }
    
    private boolean check(int[][] newLock, int kLen) {
        for (int i = kLen; i < newLock.length - kLen; i++) {
            for (int j = kLen; j < newLock.length - kLen; j++) {
                if (newLock[i][j] != 1) return false;
            }
        }
        
        return true;
    }
    
    private void add(int[][] newLock, int[][] key, int x, int y) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newLock[i + x][j + y] += key[i][j];
            }
        }
    }
}
