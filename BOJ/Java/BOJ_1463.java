import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		
		for (int i = 1; i < 1000001; i++) {
			if (i + 1 < 1000001) {
				dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
			}
			
			if (i * 2 < 1000001) {
				dp[i*2] = Math.min(dp[i*2], dp[i] + 1);
			}
			
			if (i * 3 < 1000001) {
				dp[i*3] = Math.min(dp[i*3], dp[i] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}

}
