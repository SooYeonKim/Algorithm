import java.util.*;

public class 숫자_변환하기 {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[y] = 0;
        
        for (int i = y; i >= x + 1; i--) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            if (i - n >= x && dp[i - n] > dp[i] + 1) dp[i - n] = dp[i] + 1;
            if (i % 2 == 0 && dp[i / 2] > dp[i] + 1) dp[i / 2] = dp[i] + 1;
            if (i % 3 == 0 && dp[i / 3] > dp[i] + 1) dp[i / 3] = dp[i] + 1;
        }
        
        if (dp[x] == Integer.MAX_VALUE) return -1;
        else return dp[x];
    }
}
