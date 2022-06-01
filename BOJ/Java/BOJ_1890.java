import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[N][N];
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] < 1 || (i == N-1 && j == N-1)) continue;

				if (j + array[i][j] < N) {
					dp[i][j + array[i][j]] += dp[i][j];
				}
				
				if (i + array[i][j] < N) {
					dp[i + array[i][j]][j] += dp[i][j];
				}
			}
		}
		
		System.out.println(dp[N-1][N-1]);
	}

}
