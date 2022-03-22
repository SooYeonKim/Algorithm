import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2579 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N+1];
		dp[1] = array[1];
		
		if (N >= 2) {
			dp[2] = array[1] + array[2];
		}
		
		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3] + array[i-1], dp[i-2]) + array[i];
		}
		
		System.out.println(dp[N]);
	}

}
