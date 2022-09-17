
public class 자물쇠와_열쇠_2 {
    public boolean solution(int[][] key, int[][] lock) {
        int kLen = key.length - 1;
        for (int i = 0; i < lock.length + kLen; i++) {
            for (int j = 0; j < lock.length + kLen; j++) {
                for (int k = 0; k < 4; k++) {
                    int[][] newLock = new int[lock.length + kLen * 2][lock.length + kLen * 2];
                    for (int n = 0; n < lock.length; n++) {
                        for (int m = 0; m < lock.length; m++) {
                            newLock[n + kLen][m + kLen] = lock[n][m];
                        }
                    }
                    
                    add(newLock, key, i, j);
                    if (check(newLock, kLen, lock.length)) return true;
                    
                    int[][] rotateKey = new int[key.length][key.length];
                    for (int n = 0; n < key.length; n++) {
                        for (int m = 0; m < key.length; m++) {
                            rotateKey[n][m] = key[m][key.length - 1 - n];
                        }
                    }
                    key = rotateKey;
                }
            }
        }
        
        return false;
    }
    
    private void add(int[][] newLock, int[][] key, int x, int y) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newLock[i + x][j + y] += key[i][j];
            }
        }
    }
    
    private boolean check(int[][] newLock, int kLen, int lLen) {
        for (int i = kLen; i < kLen + lLen; i++) {
            for (int j = kLen; j < kLen + lLen; j++) {
                if (newLock[i][j] != 1) return false;
            }
        }
        
        return true;
    }
}
