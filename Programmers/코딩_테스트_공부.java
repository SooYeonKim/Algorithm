import java.util.*;

public class 코딩_테스트_공부 {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = 0;
        int maxCop = 0;
        for (int i = 0; i < problems.length; i++) {
            maxAlp = Math.max(maxAlp, problems[i][0]);
            maxCop = Math.max(maxCop, problems[i][1]);
        }
        
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        
        int[][] dp = new int[maxAlp+2][maxCop+2];
        for (int i = 0; i <= maxAlp; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[alp][cop] = 0;
        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                
                for (int[] p : problems) {
                    if (i >= p[0] && j >= p[1]) {
                        if (i + p[2] >= maxAlp && j + p[3] >= maxCop) {
                            dp[maxAlp][maxCop] = Math.min(dp[maxAlp][maxCop], dp[i][j] + p[4]);
                        } else if (i + p[2] >= maxAlp) {
                            dp[maxAlp][j + p[3]] = Math.min(dp[maxAlp][j + p[3]], dp[i][j] + p[4]);
                        } else if (j + p[3] >= maxCop) {
                            dp[i + p[2]][maxCop] = Math.min(dp[i + p[2]][maxCop], dp[i][j] + p[4]);
                        } else {
                            dp[i + p[2]][j + p[3]] = Math.min(dp[i + p[2]][j + p[3]], dp[i][j] + p[4]);
                        }
                    }
                }
            }
        }
        
        return dp[maxAlp][maxCop];
    }
}
