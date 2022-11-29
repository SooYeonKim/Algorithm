import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3687 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		long[] dp = new long[101];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		
		long[] add = {Long.MAX_VALUE, Long.MAX_VALUE, 1, 7, 4, 2, 0, 8};
		for (int i = 9; i <= 100; i++) {
			for (int j = 2; j <= 7; j++) {
				String str = "" + dp[i - j] + add[j];
				dp[i] = Math.min(dp[i], Long.parseLong(str));
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int num = Integer.parseInt(br.readLine());
			
			String str = "";
			if (num % 2 == 0) {
				for (int i = 0; i < num / 2; i++) {
					str += 1;
				}
			} else {
				str += 7;
				for (int i = 0; i < (num - 3) / 2; i++) {
					str += 1;
				}
			}
			
			sb.append(dp[num] + " " + str + "\n");
		}
		
		System.out.println(sb);
	}

}
