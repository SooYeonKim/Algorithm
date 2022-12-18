import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5582 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int result = 0;
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i <= str1.length(); i++) {
			for (int j = 0; j <= str2.length(); j++) {
				if (i == 0 || j == 0) continue;
				if (str1.charAt(i-1) == str2.charAt(j-1)) dp[i][j] = dp[i-1][j-1] + 1;
				result = Math.max(result, dp[i][j]);
			}
		}
		
		System.out.println(result);
	}

}
