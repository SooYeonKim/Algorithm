import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2229 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			int max = 0;
			int min = Integer.MAX_VALUE;
			for (int j = i; j > 0; j--) {
				max = Math.max(max, array[j]);
				min = Math.min(min, array[j]);
				dp[i] = Math.max(dp[i], max - min + dp[j-1]);
			}
		}
		
		System.out.println(dp[N]);
	}

}
